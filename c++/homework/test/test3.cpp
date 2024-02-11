#include <iostream.h>
#include <iomanip.h>

using namespace std;

int main(){
	char rate;
	float kwh, total;
	int hourstype;
	
	
	cout << "Enter amount used: ";
	cin >> kwh;
	cout << "Enter account type. R for residential, C for commercial, I for industrial";
	cin >> rate;
	
	switch(rate){
		case 'R' :
			total = 6 + (.052*kwh);
			break;
		case 'C' :
			if(kwh > 1000)
				total = 60 + (.045*kwh);
			else
				total = 60;
			break;
		case 'I' :
			cout << "peak hours or off peak hours? 1 for peak hours, any other number for off peak hours";
			cin >> hourstype;
			if (hourstype == 1)
				total = 76 + ((kwh-1000)*.065);
			else
				total = 40 + ((kwh-1000)*.028);
			break;
		default : 
			cout << "Error. Try again.";
	}
	
	cout << "Amount due: $" << total;

	return 0;
}
/*
Enter  amount used: 2000
Enter account type. R for residential, C for commercial, I for industrialR
Amount due: $110

Enter amount used: 500
Enter account type. R for residential, C for commercial, I for industrialC
Amount due: $60

Enter  amount used: 2000
Enter account type. R for residential, C for commercial, I for industrialC
Amount due: $150

Enter amount used: 2000
Enter account type. R for residential, C for commercial, I for industrialI
peak hours or off peak hours? 1 for peak hours, any other number for off peak hours1
Amount due: $141

Enter amount used: 2000
Enter account type. R for residential, C for commercial, I for industrialI
peak hours or off peak hours? 1 for peak hours, any other number for off peak hours0
Amount due: $68
*/

