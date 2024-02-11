#include <iostream.h>

using namespace std;


int main(){
	int travel(), lodging(), meals(); 
	
	int price = travel() + lodging() + meals();
	
	if (price > 720)
		cout << "Company paid $720. Amount remaining: $" << (price-720);
	else
		cout << "Company paid: " << price;
		
	return 0;
}

int travel(){
	int a;
	cout << "Enter travel expenses: ";
	cin >> a;
	return a;
}

int lodging(){
	int b;
	cout << "Enter lodging expenses: ";
	cin >> b;
	return b;
}

int meals(){
	int c;
	cout << "Enter meals expenses: ";
	cin >> c;
	return c;
}

