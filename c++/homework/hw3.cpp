#include <iostream>
#include <iomanip>

using namespace std;

int main(){
	int test;

	cout << "Enter test score: ";
	cin >> test;

	if (test < 80){
		test += 5;
	} else {
		test += 7;
	}

	cout << "Final test score is: " << test;
	return 0;
}

/*
Enter test score: 50
Final test score is: 55

Enter test score: 85
Final test score is: 92
*/

