#include <iostream.h>
#include <iomanip.h>

using namespace std;

main(){
	int amount_sold, bill, discount;

	cout << "Enter amount sold and discount: ";
	cin >> amount_sold;
	
	if(amount_sold > 200){
		bill = amount_sold-discount;
	} else{
		bill = amount_sold;
	}
	
	cout << bill;
	
	return 0;
}

