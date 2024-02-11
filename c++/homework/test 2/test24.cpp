#include <iostream>

using namespace std;


float liter = 0.264179;


int main(){

	float gas, miles, answer;
	int again = 1;
	float mpg(float, float);
	
	while (again == 1 ){
		cout << "Enter number of litters of gasoline consumed by the your car and the number of miles traveled by your car: ";
		cin >> gas >> miles;

		answer = mpg(gas, miles);
		
		cout << "MPG: " << answer;
	
		cout << "\nAgain? \n1 for yes. 0 for no.";
		cin >> again;
	}
	


	return 0;

}

float mpg(float a, float b){

	return (b/(a*liter));

}
/*
Enter number of litters of gasoline consumed by the your car and the number of miles traveled by your car: 10
20
MPG: 7.57062
Again?
1 for yes. 0 for no.1
Enter number of litters of gasoline consumed by the your car and the number of miles traveled by your car: 500
2
MPG: 0.0151412
Again?
1 for yes. 0 for no.1
Enter number of litters of gasoline consumed by the your car and the number of miles traveled by your car: 1
500
MPG: 1892.66
Again?
1 for yes. 0 for no.0

Press Enter to return to Quincy...

*/

