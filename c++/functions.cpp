/*#include <iostream.h>

int main(){

	int add_them(int, int);// prototype
	
	
	int num1, num2, sum;
	
	cout << "Enter two numbers";
	cin >> num1 >> num2;
	
	sum = add_them(num1, num2);// call
	
	cout << num1 << "+" << num2 << "=" << sum;
	return 0; 

}

int add_them(int x, int y){
	return (x+y);
}
*/

/*
#include <iostream.h>

int main(){
	int compare (int, int);
	
	cout << "Enter two numbers: ";
	cin >> num1 >> num2; 
	
	larger = compare(num1, num2);
	
	cout << "Larger value is: " << larger
}

int compare(int x, int y){
	return (x>y ? x:y);
}
*/
/*
#include <iostream.h>

int main(){
	int average (int, int, int, int);
	
	int a, b, c, d;
	cout << "Enter four test scores: ";
	cin >> a >> b >> c >> d;
	
	int output = average(a, b, c, d);
	
	cout << "Average is: " << output;
}

int average(int a, int b, int c, int d){
	return ((a+b+c+d)/4);
}
*/
/*
#include <iostream.h>

int main(){
	int convert (char, char);
	char num1, num2;
	
	cout << "Enter two nums: ";
	cin >> num1 >> num2;
	
	int ch = convert(num1, num2);
	cout << ch;
	
	return 0;
}

int convert (char n, char m){
	return(n+m);
}
*/
#include <iostream.h>

int main(){
	int add_them(int, int), sub_them(int, int);
	
	int num1, num2, sum, dif;
	
	cout << "Enter two numbers: ";
	cin >> num1 >> num2;
	
	sum = add_them(num1, num2);
	dif = sub_them(num1, num2);
	
	cout << "Sum: " << sum << endl << "Difference: " << dif;
}
int add_them(int num1, int num2){
	return (num1+num2);
}
int sub_them(int num1, int num2){
	return (num1-num2);
}




