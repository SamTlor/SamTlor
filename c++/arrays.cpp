#include <iostream>

using namespace std;

int main(){


	char stooge1[6] = "Larry";
	char stooge2[6];
	char stooge3[4];

	cout << "Enter stooge2's name: ";
	cin >> stooge2;
	
	stooge3[0] = 'M';
	stooge3[1] = 'o';
	stooge3[2] = 'e';
	stooge3[3] = '\0';
	
	cout << stooge1 << endl << stooge2 << endl << stooge3;


/*	  
	float shipping_cost[4] = {3.2,4.5,6.7,9.8};
	
	int zip_code;
	cout << "Enter your zip code: ";
	cin >> zip_code;
	cout << "Your cost is: " << shipping_cost[zip_code];
*/

/*
	int nums[5];
	int i =0;
	
	cout << "Enter 5 numbers: ";
	
	for (i = 0; i < 5; i++){
		cin >> nums[i];
	}
	cout << "The values of the array are: ";
	for (i = 0; i < 5; i++){
		cout << nums[i] << " ";
	}
*/

/*
	int numbers[9] = {62, 7, 95, 18, 7, 31, 93, 7, 100};
		for (int i = 0; i < 9; i++){
		if (numbers[i] % 2 == 0){
			cout << numbers[i] << endl;
			cout << numbers+i << endl;
		}
	}

*/

/*	  
	int num1[5], num2[5], sum[5];
	
	for (int i = 0; i < 5; i++){
		cout << "Enter 2 numbers: ";
		cin >> num1[i] >> num2[i];
		sum[i] = num1[i] + num2[i];
	}
	
	for (int i = 0; i < 5; i++){
		cout << sum[i] << endl;
	}
*/

/*
	float biggest, smallest;

	int part[10] = {1,2,3,4,5,6,7,8,9,10};
	char part[10] = {'a','b','c','d','e','f','g','h','i','j'};
	int quantity[10] = {5,2,4,6,7,8,8,5,2,3};
	float price[10] = {2.4,1.5,1,4,5,6,7,8,9,10};
	float sum[10];
	
	for (int i = 0; i < 10; i++){
		sum[i] = quantity[i]*price[i];
	}
	
	for (int a = 0; i < 10; i++){
		if (a == 0)
			biggest = smallest = total[a];
		else if (total[a] > biggest)
			biggest = total[a];
		else if (total[a] < smallest)
			smallest = total[a];
	}
*/

/*
	int nums[10];
	int added = 0;
	int count=0;
	
	cout << "Enter 10 numbers: \n";
	for (int i = 0; i < 10; i++){
		cin >> nums[i];
		if (nums[i] % 5 == 0){
			count++;
			added += nums[i];
		}
	}
	
	
	cout << "The amount of numbers that are divisible by 5 are: " << count << endl << "Those numbers added up are: " << added << endl << "Those numbers are: ";
	do {
		if (nums[a] % 5 == 0){
			cout << nums[a] << " "; 
		}	   
	} while (int a = 0; a < 10; a++);
*/
	
	return 0;

}

