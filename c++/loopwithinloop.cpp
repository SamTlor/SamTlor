#include <iostream.h>
#include <iomanip.h>

using namespace std;

int main(){
/*	  
	for (int row = 1; row <= 10; row++){
		for (int col = 1; col <= 10; col++){
			cout << setw(4) << row*col;
		}
		cout << '\n';
	}	 
*/
/*
	int score, sum, avg;
	
	for (int st=1; st <= 5; st++){
		int sum =0;
		for (int exam= 1; exam <= 4; exam++){
			cout << "Enter a score: ";
			cin >> score;
			sum += score;
		}
		avg= sum/4; 
		cout << "Your average is: " << avg << endl;
	}

*/


	int avg, max, min, avgmax, avgmin, ultmax, ultmin, sum=0;

	for (int day = 1; day < 8; day++){
			for (int record= 1; record < 4; record++){
				int temp;
				cout << "Enter temperature for time number " << record << ": ";
				cin >> temp;
				sum += temp;
				if(record == 1){
					max = min = temp;
				} else if(temp > max){
					max = temp;
				} else if (temp < min){
					min = temp;
				}
			}
			avg = sum/3;
			if (day == 1){
				avgmax = avgmin = avg;
				ultmax = max;
				ultmin = min;
			} else if (avg > avgmax){
				avgmax = avg;
			} else if(avg < avgmin){
				avgmin = avg;
			} 
			
			if (max > ultmax){
				ultmax = max;
			} else if (min < ultmin){
				ultmin = min;
			}
			sum = 0;
	}
	
	cout << "Hottest temperature: " << ultmax << "\nColdest temperature: " << ultmin << "\nHighest average: " << avgmax << "\nColdest average: " << ultmin;
	
	return 0;
}

