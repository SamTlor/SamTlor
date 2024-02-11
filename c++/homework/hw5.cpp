#include <iostream.h>
#include <iomanip.h>

using namespace std;


int main(){
	string name;
	int hours, overtime, extra_hours, pay, rate, extra = 0;

	cout << "Enter name, hours, and rate";
	cin >> name >> hours >> rate;

	if(hours > 40)
	{
		overtime = hours-40;
		extra_hours = overtime*1.5;
		extra = extra_hours*rate;
		hours = 40;
	}
			
	pay = ((hours*rate) + extra);

	cout << "Name: " << name << "\nPay: " << pay;
	return 0;
}

/*
Enter name, hours, and ratesam
10
10
Name: sam
Pay: 100

Enter name, hours, and ratesam
50
10
Name: sam
Pay: 550
*/

