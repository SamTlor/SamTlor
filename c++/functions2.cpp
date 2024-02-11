/*

#include <iostream>

using namespace std;

int addthem(), multthem();
int num1, num2;

int main(){

	cout << "Enter 2 nums\n";
	cin >> num1 >> num2;

	int sum = addthem();
	cout << "Sum is: " << sum;

	return 0;
}

int addthem(){
	int subthem();
	int dif = subthem();
	cout << "Difference is: " << dif << endl;
	return(num1+num2);
}

int subthem(){
	int prod = multthem();
	cout << "Product is: " << prod << endl;
	return(num1-num2);
}

int multthem(){
	return(num1*num2);
}

*/



/*
#include <iostream>

using namespace std;

int num = 0;

void f(), g(int), h();

int main(){
	cout << "Original num: " << num << endl << endl;
	f();
	cout << "Num after f() is: " << num << endl;
	g(num);
	cout << "Num after g(num) is: " << num << endl;
	h();
	cout << "Num after h() is: " << num << endl;

	return 0;
}

void f(){
	int num = 100;
}

void g(int num){
	num = 100;
}

void h(){
	num = 100;
}

*/



/*
#include <iostream>

using namespace std;

int i = 0;

int main(){
	void hill (int);
	hill(1);
	
	return 0;
}

void hill (int n){
	if (n < 101){
		hill(3*n-1);
	}
	cout << n << '\n';
}
*/




#include <iostream>

using namespace std;

int main(){
	void write_it_backward();

	cout << "Enter a sentence: ";
	write_it_backward();
	cout << "\nThanks\n";
	
	return 0;
}

void write_it_backward(){
	char ch;
	
	if ((ch = cin.get()) != '\n'){
		write_it_backward();
		cout << ch;
	}
}



/*
#include <iostream>

using namespace std;

int factorial(long);

int main(){
	long num, ans;
	
	cout << "Enter a number: ";
	cin >> num;
	
	ans = factorial(num);
	
	cout << num << "! = " << (unsigned) ans;
	
	return 0;
}

int factorial(long n){
	if (n <= 1)
		return (1);
	else
		return (n*factorial(n-1));
}
*/

