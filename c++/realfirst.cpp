#include <iostream>

using namespace std;

int main(){


/*
	int num = 0;

	cout << "original num is: " << num;
	cout << "\nwhat is in num: " << num++;
	cout << "\nno it is: " << num;
	cout << "\ninsert other line here: " << --num;
	cout << "\nanother line as well: " << num--;
	cout << "\nlast one: " << num << endl << endl << endl;

*/


/*
	int s1, s2, s3, s4;
	float avg;

	cout << "Enter 4 test scores: \n";

	cin >> s1 >> s2 >> s3 >> s4;

	avg = (s1 + s2 + s3 + s4)/4.0;

	cout << setprecision(2);
	cout << set iosflags(ios::fixed|ios::showpoint);

	cout << "Average is: " << avg;

*/

/*
	int w, x, y , z;
	cout << "Enter 4 numbers: ";
	cin >> w >> x >> y >> z;

	cout <<w << '\t' << x << '\t' << y << '\t' << z << '\n';

	cout << setw(4) << w << setw(4) << x << setw(4) << y << setw(4) << z;

*/






/*
	float fah, c;
	cout << "Enter fahrenheit degree: ";
	cin >> fah;

	c = (5.0/9.0)*(fah-32);

	cout << "celcius degree is: " << c;
*/




/*
	int a, b;
	cout << "Enter two numbers: ";

	cin >> a >> b;



	if (a == b)
		cout << "They are equal";
	else{
		cout << "The bigger number is : ";
		if (a > b)
			cout << a;
		else
			cout << b;
	}

	if (a == b)
		cout << "They are equal";
	else
		cout << "The bigger number is: "<< ((a > b) ? a : b);



*/

/*
	int c, d, e;
	int max;


	cout << "Enter three numbers: ";

	cin >> c >> d >> e;

	if ((c == d) && (c == e))
		cout << "Identical numbers" << endl;
	else{
		cout << "The biggest number is: ";
		if (c > d)
			max = c;
		else
			max = d;

		if (max > e)
			cout << max;
		else
			cout << e;
	}
*/


	int hours, rate, salary;
	cout << "Enter hours and rate: ";
	cin >> hours >> rate;

	if (hours > 40)
		if (hours > 60)
			if (hours > 80)
				salary = 2*hours*rate;
			else {
				salary = (40*rate) + (1.5*rate*(hours-40)) + 20;
			}
		else{
			salary = (40 * rate) + (1.5*rate*(hours-40));
		}
	else{
		salary = hours * rate;
	}

	cout << salary;


	return 0;
}

/*
Enter hours and rate: 4
2
8
Press Enter to return to Quincy...
*/

