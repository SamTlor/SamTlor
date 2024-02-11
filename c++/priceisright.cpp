#include <iostream.h>
#include <iomanip.h>

using namespace std;

int main(){
/*
	int price, high=0, low=0;
	
	cout << "Enter a price: ";
	cin >> price;
	
	while (price != 23){
		cout << "Nope. try again\n";
		
		if (price > 23){
			cout << "Too high\n";
			high++;
		} else if (price < 23){
			cout << "Too low\n";
			low++;
		}
		
		if (low == 7 || high == 7){
			cout << "I'll give it to you\nThe answer is 23\n";
			price = 23;
		}else{
			cin >> price;
		}
	}
	
	cout << "You got it";
*/


/*
	int row=1, col;
	
	while (row < 11){
		col = 1;
		while (col < 11){
			cout << setw(4) << row*col;
			col++;
		}
		row++;
		cout << '\n';
	}
*/
/*
	int row = 1, col;
	
	do {
		col = 1;
		do {
			cout << setw(4) << row*col;
			col++;
		} while (col < 11);
		row++;
		cout << '\n';
	} while (row < 11);
*/

	int st_id, credits, total_credits = 0, tuition=0, total_tuition=0;
	
	cout << "Enter st_id: ";
	cin >> st_id;
	
	while (st_id != 999){
		total_credits = 0;
		cout << "Enter credit unit. -1 to stop: ";
		cin >> credits;
		while (credits != -1){
			total_credits += credits;
			cout << "Enter credits. -1 to stop: ";
			cin >> credits;
		}
		cout << "You took: " << total_credits;
		tuition = total_credits * 100;
		cout << "\nYour tuition is: " << tuition;
		total_tuition += tuition;
		cout << "Enter st_id, 999 to stop: ";
		cin >> st_id;
	}
	cout << "Total tuition earned is: $" << total_tuition;
		
	return 0;
}

