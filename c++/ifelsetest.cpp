
#include <iostream.h>
#include <iomanip.h>

/*
int main(){

	int i = 2;
	
	if (i==2){
		cout << "You are okay";
		cout << "\nI knew you would learn";
	}	 
	else{
		cout << "\nyou have a problem";
		cout << "\nwow I am learning";
	}
	return 0;	 
}
*/

/*
int main(){
	int num;
	
	cout << "Enter 1 to 3";
	cin >> num;
	
	if (num == 1){
		cout << "1 entered\n";
	} else if(num == 2){
		cout << "2 entered\n";
	} else if(num == 3){
			cout << "3 entered\n";
	} else {
		cout << "Wrong number";
	}
	
	return 0;
	
*/

/*
int main(){
	int num;
	
	cout << "Enter a number between 1 and 5";
	cin >> num;
	
	switch(num)
	{
		case 1:
			cout << "1 entered \n";
			break;

		case 2:
			cout << "2 entered \n";
			break;

		case 3:
			cout << "3 entered \n";
			break;

		case 4:
			cout << "4 entered \n";
			break;

		case 5:
			cout << "5 entered \n";
			break;
		
		default:
			cout << "wrong number";
	}
	return 0;
}
*/

/*
int main(){

	char coll;
	cout << "enter college level";
	cin >> coll;

	switch(coll)
	{
		case 'f':
			cout << "freshman \n";
			break;

		case 's':
			cout << "sophmore \n";
			break;

		case 'j':
			cout << "junior \n";
			break;

		case 'S':
			cout << "senior \n";
			break;

		case 'g':
			cout << "graduate \n";
			break;
		
		default:
			cout << "invalid letter";
	}
	
return 0;
}
*/

int main(){

	float balance = 1000.00;
	int amount;
	char trans_code;
	cout << "Enter D for deposit, W for withdraw, B for balance check";
	cin >> trans_code;
	
	switch(trans_code)
	{
		case 'D':
			cout << "enter amount: ";
			cin >> amount;
			balance = balance + amount;
			break;
		case 'W':
			cout << "enter amount: ";
			cin >> amount;
			if(amount > balance){
				cout << "insufficient funds\n";
			}else{
				balance = balance - amount;
			}
			break;
		case 'B':
			break;
		default:
			cout << "wrong operation";
	}
	cout << "Current balance: " << balance;
	
	return 0;
}

