#include <iostream.h>
#include <iomanip.h>

using namespace std;

int main(){
	int i, ticket = 0, total = 0, go=0, dontgo=0;

	for (i=0; i < 10; i++){
		cout << "Enter ticket price: ";
		cin >> ticket;
		if (ticket > 5){
			cout << "Don't go to the movies\n";
			dontgo++;
		} else {
			cout << "Go to the movies\n";
			total += ticket;
			go++;
		}
	}
	
	cout << "Total cost of the movie tickets: $" << total << "\nAmount of people that go to the movies: " << go << "\nAmount of people that don't go to the movies: " << dontgo;
	return 0;
}

/*
Enter ticket price: 2
Go to the movies
Enter ticket price: 3
Go to the movies
Enter ticket price:
1
Go to the movies
Enter ticket price: 3
Go to the movies
Enter ticket price: 7
Don't go to the movies
Enter ticket price: 9
Don't go to the movies
Enter ticket price: 0
Go to the movies
Enter ticket price: 5
Go to the movies
Enter ticket price: 6
Don't go to the movies
Enter ticket price: 4
Go to the movies
Total cost of the movie tickets: $18
Amount of people that go to the movies: 7
Amount of people that don't go to the movies: 3
*/

