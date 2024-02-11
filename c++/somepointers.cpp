/*
#include <iostream.h>

using namespace std;

int main(){

	int nums[] = {10,20,30};
	
	void change_values(int[], int);
	
	cout << "Before passing array to a function, array's values are: ";
	
	for (int i = 0; i < 3; i++)
		cout << nums[i] << " ";
	
	change_values(nums, 3);
	
	cout << "\nAfter calling the function, values of array are: ";
	for(int i = 0; i < 3; i++) 
		cout << nums[i] << " ";


	return 0;
}


void change_values(int vals[], int n){
	
	for (int i = 0; i < n; i++)
		vals[i] += 11;
		
}
*/ // void functions can still change the value of arrays

/*
#include <iostream.h>

using namespace std;

int main(){

	int * ptr, num;
	cout << "Enter a number: ";
	cin >> num;
	
	ptr = &num;
	
	cout << "The value of the number is: " << num << endl;// 6
	cout << "By pointer, the number is: " << *ptr << endl;// 6
	cout << "The number is at location: " << &num << endl;// location
	cout << "By pointer, the number is at: " << ptr << endl;// location
	cout << "The pointer is at location: " << &ptr << endl;// location

	return 0;
} // pointer is a variable that can have the address of a data item. It is always 4 bytes
*/

/*
#include <iostream.h> 

using namespace std;

int main(){

	char ch='A';
	
	char *ptr1=&ch;//*ptr1 has the value of the location of ch
	
	char **ptr2, ***ptr3;
	
	ptr2=&ptr1;
	ptr3=&ptr2;
	cout << *ptr1 << endl;
	cout << **ptr2 << endl;
	cout << ***ptr3;

	return 0;
}
*/

/*
#include <iostream.h>

using namespace std;

int main(){

	int num = 4;
	int *ptr = &num;
	
	*ptr = 100;
	
	cout << "num is: " << num;
	
	return 0;
}
*/


#include <iostream.h>

using namespace std;

int main(){

	int x = 2, y = 3;
	int *xptr = &x, *yptr = &y;
	
	
	cout << *xptr << " " << *yptr << endl;
	
	int temp = *xptr;
	*xptr = *yptr;
	*yptr = temp;
	
	cout << *xptr << " " << *yptr;
	return 0;
}


/*
#include <iostream.h>

using namespace std;

int main(){

	int compare(int *, int *);	  
	int num1 = 8, num2 = 2;
	
	int larger = compare(&num1, &num2);
	
	cout << "The larger value is: " << larger;
	
	return 0;
}

int compare(int *ptr1, int *ptr2){

	if (*ptr1 > *ptr2)
		return (*ptr1);
	else 
		return (*ptr2);
}
*/

/*
#include <iostream.h>

using namespace std;

char msg[] = "Mom I am...";

int main(){
	
	char *ptr;
	ptr = msg;
	
	
	cout << ptr << endl;
	cout << *ptr << endl;
	cout << (void*)ptr << endl;
	
	return 0;
}
*/

/*
#include <iostream.h>

using namespace std;

int main(){
	
	int num1, num2, num3;
	
	cout << "Enter three numbers: ";
	cin >> num1 >> num2 >> num3;
	
	int big(int *, int *, int *);
	
	int largest = big(&num1, &num2, &num3);
	
	cout << "The biggest number is: " << largest;
	
	return 0;
}

int big(int *a,int *b,int *c){
	int nowbig;
	
	if (*a > *b)
		nowbig = *a;
	else if (*b > *a)
		 nowbig = *b;
	
	
	if (*c > nowbig)
		nowbig = *c;
		
		
	return nowbig;

}
*/

