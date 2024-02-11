#include <iostream.h>
#include <iomanip.h>

using namespace std;

int main(){
	float purchase, tax=0;
	
	cout << "Enter price: ";
	cin >> purchase;
	
	if ((1 > purchase) && (purchase > 0)){
		if(purchase < .08)
			tax = 0;
		else if (purchase < .22)
			tax = .01;
		else if (purchase < .36)
			tax = .02;
		else if (purchase < .50)
			tax = .03;
		else if (purchase < .65)
			tax = .04;
		else if (purchase < .79)
			tax = .05;
		else if (purchase < 1)
			tax = .06;
	} else
		cout << "Error. Purchase is not valid.\n";
		
		
	cout << "Sales tax amount: " << tax;

	return 0;
}
/*
Enter price: 0
Error. Purchase is not valid.
Sales tax amount: 0

Enter price: .1
Sales tax amount: 0.01

Enter price: .24
Sales tax amount: 0.02

Enter price: .37
Sales tax amount: 0.03

Enter price: .55
Sales tax amount: 0.04

Enter price: .70
Sales tax amount: 0.05

Enter price: .85
Sales tax amount: 0.06

Enter price: 1.2
Error. Purchase is not valid.
Sales tax amount: 0
*/

