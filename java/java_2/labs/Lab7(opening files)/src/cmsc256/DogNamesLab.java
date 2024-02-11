package cmsc256;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class DogNamesLab {

	private static String promptForFileName() {
		System.out.println("Enter the file name: ");
		@SuppressWarnings("resource")
		Scanner keyIn = new Scanner(System.in);
		return keyIn.next();
	}

	private static Scanner openFile(String fileName) throws FileNotFoundException {
		File file = new File(fileName);
		while (!file.exists()) {
			file = new File(promptForFileName());
		}
		return new Scanner(file);
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		// Read data file to build data structure
		ArrayList<Dog> doglist = new ArrayList<>();
		
		try {
			// verify file and create file Scanner
			Scanner fileReader = openFile("Dog_Names.csv");

			//  Discard header line
			fileReader.nextLine();
			 
			while(fileReader.hasNextLine()) {										//while there is data to read
			 	String line = fileReader.nextLine();								//get that next data
			 	int commaIndex = line.indexOf(',');									//find where the comma is
			 	String name = line.substring(0, commaIndex).trim();					//save from beginning of the line to the comma
			 	int count = Integer.parseInt(line.substring(commaIndex+1).trim());	//read the count of the name
				doglist.add(new Dog(name, count));									//add new dog object to doglist
			}
			fileReader.close();
		}
		catch(FileNotFoundException noFile){
			System.out.println("There was an error opening or reading from the file.");
			System.exit(0);
		}

		Scanner readInput = new Scanner(System.in);
		String prompt = "\nWhat do you want to do?\n" +						//options user has
					    "\t1. Check a dog name\n" + 						//input dog name see what its count is
						"\t2. See all the dog names\n" +					//vomits all the data out
				 		"\t3. Play a game\n" + 								//Which is more popular
						"\t4. Exit.\n" +									//just default
						"Enter the number corresponding to your choice.";
		
		System.out.println(prompt);											//output ^^
		int option = readInput.nextInt();									//get user choice
		
		switch(option) {
		case 1:
			System.out.println("Enter a dog’s name?");
			String name = in.nextLine();
			int nameCount = getCountForDog(doglist, name);
			System.out.println(name + " is registered " + nameCount + " times.");
			break;
		case 2:
			System.out.println(getDogNamesAlphabetically(doglist));
			break;
		case 3:
			playGuessingGame(doglist, in);
			break;
		default: System.out.println("Invalid option.");
		}
		readInput.close();
		in.close();
	}

	public static int getCountForDog(ArrayList<Dog> dogs, String name) {
        for (Dog i : dogs){							//loop through dogs
            if( i.getDogName().equals(name) ){		//if dog name is the same as name
                return i.getCount();				//return dogname count
            }
        }
		return 0;									//if it doesn't find the dogname
	}
	
	public static String getDogNamesAlphabetically(ArrayList<Dog> dogs) {
        Collections.sort(dogs);														//all you need when it's compareTo
        String ending = "";
        for (Dog i : dogs){															//for i in dogs
            ending += "Name: " + i.getDogName() + " count: " + i.getCount() + "\n";	//append to ending
        }
		return ending;
	}

	public static void playGuessingGame(ArrayList<Dog> dogs, Scanner readIn) {
		Random random = new Random();										//create a random object

		int win_count, total, other;
		win_count = total = 0;

		char response = 'y';												//start off playing the game
		while (response == 'y'){
			total++;														//count the first round

			Dog[] array_for_guess = new Dog[2];								//make an array to hold all of the possible popular dogs

			array_for_guess[0] = dogs.get(random.nextInt(dogs.size()));		//could easily be made into a for loop to add more dogs
			array_for_guess[1] = dogs.get(random.nextInt(dogs.size()));

			System.out.println("Which name is more popular for Anchorage dogs?" 
								+ "\n1. " + array_for_guess[0].getDogName() 
								+ "\n2. " + array_for_guess[1].getDogName()
							);

			int guess = readIn.nextInt() - 1;								//programming numbering is funny isn't it
			if (guess == 1){												//set other
				other = 0;
			}else{
				other = 1;
			}

			if (array_for_guess[guess].getCount() > array_for_guess[other].getCount()){ 		//if guess is bigger than the other
				System.out.println("Yes, that's right.");
				win_count++;
			}else{
				System.out.println("Nope, the more popular dog name is " + array_for_guess[other].getDogName());
			}

			System.out.println("Do you want to play again (Y/N)");								//only plays again with 'y'
			response = readIn.next().charAt(0);													//doesn't check for anything else
		}
		readIn.close();
		System.out.println("You guessed corectly " + win_count + " out of " + total + " times.");
	}
}