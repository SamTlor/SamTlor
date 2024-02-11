#include <iostream.h>
#include <iomanip.h>

using namespace std;

int main(){
	
	float sales = 0, goal, test;
	
	cout << "What is your goal for the year?";
	cin >> goal;
	
	goal -= 300;
		
	while(test < goal){
		test = sales;
			
		if (test < 4000)
			test += (test*.08); 
		else if (test < 8000)
			test += (test*.1);
		else
			test += (test*.12);
		
		sales += .01;
	}
	cout << "Necessary sales to reach your goal:" << sales;
	return 0;
}

/*
17589.3
*/

