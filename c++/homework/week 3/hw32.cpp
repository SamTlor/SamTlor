#include <iostream.h>
#include <iomanip.h>

using namespace std;

int main(){

	int i=0, amount_sold=0, bill=0, discount=0, count=0, no_discount=0;
	
	for (i=0; i<10; i++){
		cout << "Enter amount sold and discount: ";
		cin >> amount_sold >> discount;

		if(amount_sold > 200){
			bill = amount_sold-discount;
			count += discount;
		} else{
			bill = amount_sold;
			no_discount++;
		}
	}
	
	
	cout << no_discount << " people didn't get a discount\n" << "Total amount discounted is: " << count;

	return 0;
}

/*
Enter amount sold and discount: 23
6
Enter amount sold and discount: 600
23
Enter amount sold and discount: 11
44
Enter amount sold and discount: 877
45
Enter amount sold and discount: 250
50
Enter amount sold and discount: 54
123
Enter amount sold and discount: 23
66
Enter amount sold and discount: 900
400
Enter amount sold and discount: 657
45
Enter amount sold and discount: 777
55
4 people didn't get a discount
Total amount discounted is: 618
*/

