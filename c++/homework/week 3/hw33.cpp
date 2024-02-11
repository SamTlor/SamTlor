#include <iostream.h>
#include <iomanip.h>

using namespace std;

int main(){

	int test, five_percent=0, seven_percent=0;
	for (int i=0; i < 10; i++){
		cout << "Enter test score: ";
		cin >> test;

		if (test < 80){
			test += 5;
			five_percent++;
		} else {
			test += 7;
			seven_percent++;
		}
	}
	
	cout << five_percent << " people got the 5% discount \n" << seven_percent << " people got the 7% discount";
	return 0;
}

/*
Enter test score: 21
Enter test score: 55
Enter test score: 78
Enter test score: 90
Enter test score: 98
Enter test score: 76
Enter test score: 33
Enter test score: 68
Enter test score: 98
Enter test score: 94
6 people got the 5% discount
4 people got the 7% discount
*/

