#include <iostream.h>
#include <iomanip.h>
#include <tgmath.h>

using namespace std;

int main(){
	float loan=5000, payment=100, newloan=0, newpayment=0; 
	int time=0; 
	
	newloan = loan;
	newpayment = payment; 
	
	while (newpayment < newloan){
		newloan = newloan + (loan*.01);
		newpayment = newpayment + payment;
		time++;
	}
	
	cout << "Years: " << floor(time/12) << "	Months: " << time%12 << "\nInterest: " << newloan-loan << "\nTotal payment: " << newpayment;
	
	return 0;
}

/*
Years: 8        Months: 2
Interest: 4900
Total payment: 9900
*/

