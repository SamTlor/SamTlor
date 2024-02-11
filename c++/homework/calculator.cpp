#include <iostream>
#include <iomanip>

using namespace std;

int main(){
	int num1, num2, answer;
	char op;

	cout << "Enter equation\n";
	cin >> num1 >> op;

	switch(op)
	{
      case '+' :
	  	cin >> num2;
		answer = num1 + num2;
      	break;
      case '-' :
	  	cin >> num2;
		answer = num1 - num2;
		break;
      case '*' :
	  	cin >> num2;
		answer = num1 * num2;
        break;
      case '/' :
	  	cin >> num2;
		if (num2 == 0){
			cout << "no\n";
			answer = 0;
		} else {
			answer = num1 / num2;
		}
        break;
      default :
        cout << "Invalid operator" << endl;
	}

	cout << num1 << op << num2 << " = " << answer;
	return 0;
}
