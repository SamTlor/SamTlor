#include <iostream>

using namespace std;

int main(){
	int amount_sold, bill, discount;

	cout << "Enter amount sold and discount: ";
	cin >> amount_sold >> discount;

	if(amount_sold > 200){
		bill = amount_sold-discount;
	} else{
		bill = amount_sold;
	}

	cout << "Bill: " << bill;

	return 0;
}

/*
Enter amount sold and discount: 4
1
Bill: 4

Enter amount sold and discount: 204
1
Bill: 203
*/

