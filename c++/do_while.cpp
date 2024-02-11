/*
#include <iostream.h>
#include <iomanip.h>

using namespace std;

int main(){
	char play_or_no_play = 'y', ch; 
	
	while (play_or_no_play == 'y'){
		cout << "Enter a char: ";
		cin >> ch;
		
		while (ch != 'c'){
			cout << "You are wrong try again\n";
			cin >> ch;
		}
		cout << "you got it\n" << "Do you want to try again?\n";
		cin >> play_or_no_play;
	}
	
	
	return 0;
}
*/

#include <iostream.h>
#include <iomanip.h>

using namespace std;

int main(){
	char play_or_no_play, ch, character, store; 
	
	do {
		cout << "Enter a char: ";
		cin >> ch;
		
		while (ch != 'c'){
			cout << "You are wrong. Try again\n";
			cin >> ch;
		}
		cout << "You got it\nDo you want to try again?\n";
		cin >> play_or_no_play;
	} while (play_or_no_play == 'y');
	
	return 0;

/*

	char ch, again, rand; 
    
	
	int n = rand() % 26;
    char c = (char)(n+65);
    cout << c << "\n";
    return 0;
	
	cout << "Enter a char";
	while (ch != 'c'){
		cout << "You are wrong try again\n";
		cin >> ch;
	}
	
	cout << "you got it\nDo you want to play again?\n";
	cin >> again;
	
	while (again == 'y'){
		cout << "Enter a char: ";
		cin >> ch;
		
		while (ch != 'c'){
			cout << "You are wrong try again\n";
			cin >> ch;
		}
		cin >> again;
	}
*/	  
	
	return 0;

}

