#include <iostream.h>
#include <iomanip.h>

using namespace std;

int main(){
	int bonus, sales, nobonus=0, tenbonus=0, fivehundredbonus=0;
	for (int i = 0; i < 10; i++){
		cout << "Enter sales: ";
		cin >> sales;

		if(sales > 2000){
			if (sales > 5000){
				bonus = 500 + (.05*(sales-5000));
				fivehundredbonus++;
			} else {
				bonus = sales*.1;
				tenbonus++;
			}
		} else{
			bonus = 0;
			nobonus++;
		}
	}

	cout << nobonus << " people got no bonus\n" << tenbonus << " people got a 10% bonus\n" << fivehundredbonus << " people got the five hundred plus 5% of extra sales";

	return 0;
}

/*
Enter sales: 34
Enter sales: 55
Enter sales: 8666
Enter sales: 5222
Enter sales: 4232
Enter sales: 3111
Enter sales: 2555
Enter sales: 1753
Enter sales: 1441
Enter sales: 982
5 people got no bonus
3 people got a 10% bonus
2 people got the five hundred plus 5% of extra sales
*/

