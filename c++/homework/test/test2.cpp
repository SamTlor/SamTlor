#include <iostream.h>
#include <iomanip.h>

using namespace std;

int main(){
	char room;
	int refrigerator=0, bed=0;
	float extra=0, price=0;
	
	cout << "Enter room type. G for garden-view, P for pool-view, L for lake-view\n";
	
	while (price < 125){
		cin >> room;
	
		switch (room){
			case 'G' :
				price = 125.00;
				break;
			case 'P' :
				price = 145.00;
				break;
			case 'L' :
				price = 180.00;
				break;
			default :
				cout << "Invalid room type try again\n";	
		}
	}
	
	cout << "Do you want a refrigerator? 1 for yes. Any other number for no.";
	cin >> refrigerator;
	if (refrigerator == 1)
		extra = 2.5;
	else 
		extra = 0;
		
	cout << "Do you want an extra bed? 1 for yes. Any other number for no.";
	cin >> bed;
	if (bed == 1){
		if(price == 180.00)
			extra += 20;
		else 
			extra += 15;
	}


	cout << "Room type: ";
	switch (room){
		case 'G' : 
			cout << "Garden-view";
			break;
		case 'P' : 
			cout << "Pool-view";
			break;
		case 'L' :
			cout << "Lake-view";
			break;
	}
	cout << "\nBasic daily room rate: $" << price;
	if (refrigerator == 1)
		cout << "\nCharge for the refrigerator: $2.50";
	if (bed == 1){
		cout << "\nCharge for the extra bed: $";
		if (price == 180)
			cout << "20";
		else
			cout << "15";
	}
	cout << "\nTotal charge: $" << (price+extra);

	return 0;
}
/*
Enter room type. G for garden-view, P for pool-view, L for lake-view
G
Do you want a refrigerator? 1 for yes. Any other number for no.1
Do you want an extra bed? 1 for yes. Any other number for no.1
Room type: Garden-view
Basic daily room rate: $125
Charge for the refrigerator: $2.50
Charge for the extra bed: $15
Total charge: $142.5

Enter room type. G for garden-view, P for pool-view, L for lake-view
G
Do you want a refrigerator? 1 for yes. Any other number for no.1
Do you want an extra bed? 1 for yes. Any other number for no.0
Room type: Garden-view
Basic daily room rate: $125
Charge for the refrigerator: $2.50
Total charge: $127.5

Enter room type. G for garden-view, P for pool-view, L for lake-view
G
Do you want a refrigerator? 1 for yes. Any other number for no.0
Do you want an extra bed? 1 for yes. Any other number for no.1
Room type: Garden-view
Basic daily room rate: $125
Charge for the extra bed: $15
Total charge: $140

Enter room type. G for garden-view, P for pool-view, L for lake-view
P
Do you want a refrigerator? 1 for yes. Any other number for no.1
Do you want an extra bed? 1 for yes. Any other number for no.1
Room type: Pool-view
Basic daily room rate: $145
Charge for the refrigerator: $2.50
Charge for the extra bed: $15
Total charge: $162.5

Enter room type. G for garden-view, P for pool-view, L for lake-view
L
Do you want a refrigerator? 1 for yes. Any other number for no.1
Do you want an extra bed? 1 for yes. Any other number for no.1
Room type: Lake-view
Basic daily room rate: $180
Charge for the refrigerator: $2.50
Charge for the extra bed: $20
Total charge: $202.5
*/

