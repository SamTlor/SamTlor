#include <iostream.h>
#include <iomanip.h>

using namespace std;

int main(){
	int num; 

	cout << "Enter an odd number, 999 to stop\n";
	cin >> num; 
	while (num != 999){
		if (num % 2 == 1)
			cout << num;
		cout << "Enter an odd number, 999 to stop\n";
		cin >> num;
	}
	cout << "999 entered. Program ends";
	
	return 0;
}

