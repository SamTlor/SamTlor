#include <iostream>
#include <string>

using namespace std;

int main(){

	int item_num, zero_below=0, i = 0;
	float cost, average, total=0;
	int names[100];
	
	for (int a = 0; a < 100; a++){
		names[a] = a;
	}
	
	for (i = 1; i < 6; i++){
		cout << "Enter the item number and the cost: ";
		cin >> item_num >> cost;
		
		if (cost == 0) { 
			cout << "FREE ITEM\n";
			zero_below++;
		} else if (cost < 0){
			cout << "DATA ERROR\n";
			zero_below++;
		} else
			total += cost;
			
		cout << "Item: " << names[item_num] << endl << "Price: " << cost << endl << "Average price: " << (total/(i-zero_below)) << endl;
	
	}

	return 0;

}

/*
Enter the item number and the cost: 1
10
Item: 1
Price: 10
Average price: 10
Enter the item number and the cost: 2
50
Item: 2
Price: 50
Average price: 30
Enter the item number and the cost: 0
0
FREE ITEM
Item: 0
Price: 0
Average price: 30
Enter the item number and the cost: -344
-40
DATA ERROR
Item: 127
Price: -40
Average price: 30
Enter the item number and the cost: 45
45
Item: 45
Price: 45
Average price: 35
*/

