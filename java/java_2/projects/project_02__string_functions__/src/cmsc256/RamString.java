/*

Sam Taylor
9/22/2021
CMSC256 - Section 001

*/


package cmsc256;

public class RamString implements WackyStringInterface {
    
    private String theString;

    //default constructor
    public RamString() {
        this.theString = "Rams! Let's Go Rams and CS@VCU!";
    }
    //paramaterized constructor
    public RamString(String newString){
        setWackyString(newString);
    }




    public void setWackyString(String newString){
        if (newString != null){                             //if it doesn't equal null
            theString = newString;                          //set it there's nothing wrong
        }else { 
            throw new java.lang.IllegalArgumentException(); //else throw exception
        }
    }
    public String getWackyString(){
        return theString;
    }
    
    public int countVCURams(){
        int count = 0;

        for (int i = 0; i < theString.length()-2; i++){     //string length minus 2 because
            if(theString.substring(i, i+3).equals("VCU")){  //vcu has 3 letters
                count++;
            }
            //as long as i doesn't equal length minus 3 because rams has 4 letters
            if ( (i != theString.length() - 3) && theString.substring(i, i+4).toUpperCase().equals("RAMS") ){
                count++;
            }
        }

        return count;
    }

    public boolean hasRams(){
        return theString.startsWith("rams") || theString.startsWith("rams", 1);
    }

    public boolean hasRepeatingPrefix(int numChars){
        String prefix = theString.substring(0, numChars);                   //set the tester

        for (int i = numChars; i < theString.length() - numChars+1; i++){   //plus 1 to get whole string
            if(theString.substring(i, i + numChars).equals(prefix)){        //if test case is true
                return true;
            }
        }
        return false;                                                   //if true hasn't been returned
    }

    public String makeNumberSubstitutions(){
        String ending = "";                             //thing to add to
        for (int i = 0; i < theString.length(); i++){   //go through the string
            char letter = theString.charAt(i);          //get every letter

            switch(letter){                             //switch
                case 'i':                           
                    ending += '1';                      //add to the thing to add to
                    break;
                case 'I':
                    ending += '1';
                    break;
                case 'e':
                    ending += '3';
                    break;
                case 'E':
                    ending += '3';
                    break;
                case 's':
                    ending += '5';
                    break;
                case 'S':
                    ending += '5';
                    break;
                case 'o':
                    ending += '0';
                    break;
                case 'O':
                    ending += '0';
                    break;
                default:
                    ending += letter;
                    break;
            }
        }
        return ending;
    }


    public String removeNot(){
        if (theString.contains("not")){                             //if not is in the string 
            for (int i = 0; i < theString.length() - 4; i++){       //4 is the length of 'not '
                if(theString.contains("not ")){                     //if 'not ' is there
                    theString = theString.replaceAll("not ", "");   //set the string to be the old
                }                                                   //without the 'not 's
            }
            return theString.replaceAll("not", "");                 //take out all of the nots if there
        }                                                           //are still some there
        return theString;                                           //end
    }
}