#include <iostream.h>
#include <iomanip.h>

using namespace std;

int main(){
	
	char employee;
	float pay;
	
	do {
		cout << "Enter education history and pay rate.\nH for high school diploma, C for 2-year college degree, B for B.S. degree, M for M.S. degree, P for PhD degree, N to stop\n";
		cin >> employee >> pay;
		
		switch(employee) {
	      case 'H' :
    	  	pay += (pay*.1);
      		break;
      	case 'C' :
    	  	pay += (pay*.15);
			break;
      	case 'B' :
    	  	pay += (pay*.2);
        	break;
      	case 'M' :
    	  	pay += (pay*.2);
        	break;
      	case 'P' :
    	  	pay += (pay*.2);
        	break;
		case 'N' :
			employee = 'N';
		default :
			cout << "Error. Invalid education. Try again.";
		}
		
		cout << "New pay: " << pay << '\n'; 
	} while (employee != 'N');

	return 0;
}

/*
Enter education history and pay rate.
H for high school diploma, C for 2-year college degree, B for B.S. degree, M for M.S. degree, P for PhD degree, N to stop
H
10
New pay: 11
Enter education history and pay rate.
H for high school diploma, C for 2-year college degree, B for B.S. degree, M for M.S. degree, P for PhD degree, N to stop
C
10
New pay: 11.5
Enter education history and pay rate.
H for high school diploma, C for 2-year college degree, B for B.S. degree, M for M.S. degree, P for PhD degree, N to stop
B
10
New pay: 12
Enter education history and pay rate.
H for high school diploma, C for 2-year college degree, B for B.S. degree, M for M.S. degree, P for PhD degree, N to stop
M
10
New pay: 12
Enter education history and pay rate.
H for high school diploma, C for 2-year college degree, B for B.S. degree, M for M.S. degree, P for PhD degree, N to stop
P
10
New pay: 12
Enter education history and pay rate.
H for high school diploma, C for 2-year college degree, B for B.S. degree, M for M.S. degree, P for PhD degree, N to stop
N
10
Error. Invalid education. Try again.New pay: 10
*/

