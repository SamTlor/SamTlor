#include <iostream.h>
#include <iomanip.h>

int main(){
	int movie; 
	
	cout << "Enter ticket price: ";
	cin >> movie;
	
	if (movie < 5)
		cout << "go to the movie";
	else
		cout << "stay home and study";
	
	
	return 0;
}


/*
Enter ticket price: 1
go to the movie

Enter ticket price: 6
stay home and study
*/

