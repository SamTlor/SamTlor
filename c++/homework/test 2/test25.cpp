#include <iostream>

using namespace std;

int main(){
	
	float year_ago, today;
	double inflation;
	int again;
	
	do {

		cout << "Enter the price of your item from one year ago and then the current price: ";
		cin >> year_ago >> today;
		
		inflation = ((today - year_ago)/year_ago)*100;

		cout << "Inflation rate for this item is: " << inflation << "%";
		 
		cout << "\nAgain? 1 for yes. 0 for no.";
		cin >> again;
	} while (again == 1);
	
	return 0;

}


/*
Enter the price of your item from one year ago and then the current price: 10
20
Inflation rate for this item is: 100%
Again? 1 for yes. 0 for no.1
Enter the price of your item from one year ago and then the current price: 100
50
Inflation rate for this item is: -50%
Again? 1 for yes. 0 for no.0

Press Enter to return to Quincy...

*/

