#include <iostream.h>
#include <ctype.h>


using namespace std;

int main(){

	char response;
	char *c_ptr;
	int *i_ptr;
	
	cout << "Enter 'c' for char or 'i' for integer: ";
	cin >> response;
	
	if (response == 'c')
		c_ptr = (char*)malloc(1);
	else							//i'm trusting you here
		i_ptr = (int*)malloc(1);
		
	cout << c_ptr << '\n' << i_ptr;

	return 0;
}



/*
#include <iostream>

using namespace std;

int main() {
	
	int *ptr = newint(65);
	
	cout << *ptr << endl;
	delete ptr;
	cout << *ptr;
	
	return 0;
}
*/

