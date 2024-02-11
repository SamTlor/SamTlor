#include <iostream.h>
#include <iomanip.h>

using namespace std;

int main(){

	char gender, married;
	int years, allowance, children, age;

	for (int i = 0; i < 10; i++){
		cout << "Enter gender(m for male, f for female), years of service, and amount of children";
		cin >> gender >> years >> children;
		
		if(gender == 'm' && years >= 20){
			cout << "How many under 18?";
			cin >> children;
			allowance = 300;
		} else if (gender == 'f' && years >= 25){
			cout << "Married? y for yes, n for no";
			cin >> married;
			if (married == 'y')
				allowance = 250;
			else 
				allowance = 275;
		} else {
			cout << "How many are not attending college?";
			cin >> children;
			if(children>2)
				children = 2;
			allowance = 100;
			
		}
		
		cout << "Your allowance is: " << allowance*children << endl;
	}
	
	return 0;
}
/*
Enter gender(m for male, f for female), years of service, and amount of childrenm
25
3
How many under 18?2
Your allowance is: 600
Enter gender(m for male, f for female), years of service, and amount of childrenm
26
3
How many under 18?3
Your allowance is: 900
Enter gender(m for male, f for female), years of service, and amount of childrenf
35
3
Married? y for yes, n for noy
Your allowance is: 750
Enter gender(m for male, f for female), years of service, and amount of childrenf
35
3
Married? y for yes, n for non
Your allowance is: 825
Enter gender(m for male, f for female), years of service, and amount of childrenf
12
3
How many are not attending college?3
Your allowance is: 200
Enter gender(m for male, f for female), years of service, and amount of childrenm
12
1
How many are not attending college?1
Your allowance is: 100
Enter gender(m for male, f for female), years of service, and amount of childrenf
3
2
How many are not attending college?2
Your allowance is: 200
Enter gender(m for male, f for female), years of service, and amount of childrenf
3
2
How many are not attending college?1
Your allowance is: 100
Enter gender(m for male, f for female), years of service, and amount of childrenm
45
5
How many under 18?3
Your allowance is: 900
Enter gender(m for male, f for female), years of service, and amount of childrenm
34
5
How many under 18?5
Your allowance is: 1500
*/

