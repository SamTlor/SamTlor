#include <iostream.h>
#include <iomanip.h>

using namespace std;

int main(){
	char employee;

	cout  << "Enter employee class: ";
	cin >> employee;

	switch(employee) {
      case 'A' :
      	cout << "Administrative" << endl; 
      	break;
      case 'F' :
	  	cout << "Faculty" << endl;
		break;
      case 'M' :
      	cout << "Maintenance" << endl;
        break;
      case 'S' :
        cout << "Secretarial" << endl;
        break;
      case 'C' :
        cout << "Classified" << endl;
        break;
      case 'P' :
        cout << "Part-Time" << endl;
        break;
      default :
        cout << "Invalid employee" << endl;
	};
 
	return 0;
}

/*
Enter employee class: A
Administrative

Enter employee class: F
Faculty

Enter employee class: M
Maintenance

Enter employee class: S
Secretarial

Enter employee class: C
Classified

Enter employee class: P
Part-time

Enter employee class: r
Invalid employee
*/

