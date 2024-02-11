#include <iostream>

using namespace std;

int main(){
/*	  
	for (;;)
		if(i < 10)
			cout << i++ << endl;
		else
			break;

*/

/*
	for (int i=0; i<10; cout << i << endl, i++);
*/

/*
	for ( i = 0; i < 10; i++){
		cout << "Enter a number: ";
		cin >> num;
			if (i==0)
				large=small=num;
			else if (num > large){
				large = num;
			}
			else if (num < small){
				small=num;
			}
	}
	
	cout << "Largest: " << large << '\n' << "Smallest: " << small;
*/

/*
	for (i=0; i < 10; i++){
		sum += i;
		cout << "Sum: " << sum << '\n';
	}
*/

/*
	for (day = 1; day <=7; day++){
		cout << "Enter amount in cents: ";
		cin >> coins;
		pb = pb + coins;
	}
	
	cout << "$" << (pb/100) << endl << "¢" << (pb%100);
*/	  
	int i, num, large, small, sum, day, coins, pb, men = 0, women = 0;
	char guest;	   
	
	
	for (i = 0; i < 10; ){
		cout << "Enter gender: ";
		cin >> guest;
		
		switch (guest) {
			case 'm':
				men++;
				i++;
				break;
			case 'f':
				women++;
				i++;
				break;
			default:
				cout << "N/A\n";
		}
	}
	
	cout << "Men: " << men << endl << "Women: " << women;
	return 0;
}

