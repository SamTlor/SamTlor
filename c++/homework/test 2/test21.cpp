#include <iostream>

using namespace std;

int main(){
	float sales, total, i = 0;
	
	cout << "-999 to stop.\n";
	
	do{
		cout << "Enter the sales amount: ";
		cin >> sales;
		if (sales > 100.00){
			cout << sales << endl;
			total += sales;
			i++;
		}
	} while (sales != -999);

	cout << "Average of all sales combined: " <<(total/i);

	return 0;
}

/*
-999 to stop.
Enter the sales amount: 100
Enter the sales amount: 200
200
Enter the sales amount: 300
300
Enter the sales amount: 100.01
100.01
Enter the sales amount: -999
Average of all sales combined: 200.003
Press Enter to return to Quincy...

*/

