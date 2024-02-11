#include <iostream.h>
#include <iomanip.h>

using namespace std;

int main(){
	float start, length, gross, net, rate=.4;
	
	cout << "Enter start time: ";
	cin >> start;
	cout <<"Enter the length of the call: ";
	cin >> length;
	
	gross = rate * length;
	
	if (start > 1800)
		rate = rate/2;
		
	if (length > 60)
		rate += rate*.15;
		
	net = rate * length + (rate*length*.04);
	cout << "Gross cost: $" << gross << "\nNet cost: $" << net;

	return 0;
}
/*
Enter start time: 500
Enter the length of the call: 20
Gross cost: $8
Net cost: $8.32

Enter start time: 500
Enter the length of the call: 90
Gross cost: $36
Net cost: $43.056

Enter start time: 2000
Enter the length of the call: 20
Gross cost: $8
Net cost: $4.16

Enter start time: 2000
Enter the length of the call: 90
Gross cost: $36
Net cost: $21.528
*/

