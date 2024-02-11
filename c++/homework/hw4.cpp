#include <iostream.h>
#include <iomanip.h>

using namespace std;

int main(){
	int bonus, sales;

	cout << "Enter sales: ";
	cin >> sales;

	if(sales > 2000){
		if (sales > 5000){
			bonus = 500 + (.05*(sales-5000));
		} else {
			bonus = sales*.1;
		}
	} else{
		bonus = 0;
	}


	cout << "Bonus is: " << bonus;

	return 0;
}

/*
Enter sales: 100
Bonus is: 0

Enter sales: 2500
Bonus is: 250

Enter sales: 6000
Bonus is: 550
*/

