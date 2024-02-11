#include <iostream>
#include <string>

using namespace std;

int main(){
	
	int i = 1, total=0, sales, good=0;
	string goodsales[201];

	while (i < 5){
		
		string salesman;
	
		cout << "Enter the salesman's name: ";
		cin >> salesman;
		cout << "Enter their sales: ";
		cin >> sales;
	
		if (sales > 5000){
			goodsales[good] = salesman;
			good++;
		} else if (sales < 200)
			cout << "BAD SALES.\n";
		if(sales < 5000)
			total++;
			
		i++;
	
	}
	cout << "The salesmen who exceeded $5000 are: " << endl;
	while (good > 0){
		cout << goodsales[good-1] << endl;
		good--;
	}
	cout << "Amount of sales less than 5000: " << total;
	
	return 0;
}


/*
Enter the salesman's name: a
Enter their sales: 50
BAD SALES.
Enter the salesman's name: b
Enter their sales: 500
Enter the salesman's name: c
Enter their sales: 5500
Enter the salesman's name: d
Enter their sales: 6000
The salesmen who exceeded $5000 are:
d
c
Amount of sales less than 5000: 2
Press Enter to return to Quincy...
*/

