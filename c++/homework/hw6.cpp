#include <iostream.h>
#include <iomanip.h>

using namespace std;

int main(){
	int messages, extra = 0;
	cout << "Enter amount of messages: ";
	cin >> messages;

	if (messages > 80){
		if (messages > 140){
			if (messages > 200){
				extra = (.06*60)+(60/20)+(.04*(messages-200));
			} else {
				extra = (.06*60)+((messages-140)/20);
			}
		} else {
			extra = (.06*(messages-80));
		}
	}

	cout << "Telephone bill: " << (7.5+extra);
	
	return 0;
}

/*
Enter amount of messages: 250
Telephone bill: 15.5

Enter amount of messages: 175
Telephone bill: 11.5

Enter amount of messages: 100
Telephone bill: 8.5

Enter amount of messages: 50
Telephone bill: 7.5
*/

