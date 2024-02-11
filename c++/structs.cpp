#include <iostream>
#include <ctype.h>

using namespace std;
/*
int main(){

	char *ptr, *get_name();
	
	ptr = get_name();
	cout << "Your name is: " << ptr;
	
	return 0;

}

static char *get_name(){
	char name [80];
	cout << "Enter your name: ";
	cin >> name;
	return (name);
}
*/

/*	  
char msg[] = "haha \"you know\" I am good \"you know\" and all \"you know\"";

int main(){
	
	cout << strrstr(msg, "you know");
	
	return 0;
	
}
*/

/*
int main(){
	char s1[] = "ABCD";
	char s2[] = "abcd";
	
	
	if (stricmp(s1,s2, 4) == 0)
		cout << "They are the same";
	else
		cout << "They are different";
	
	return 0;
}
*/

/*
int main() {
	char s1[] = "Mama";
	char s2[] = "Hi Mommy, I am tired";
	
	strcpy(s1,s2);
	
	cout << s1 << endl << s2;
	
	return 0;
}
*/

/*
int main(){
	char f_name[] = "Sam";
	char l_name[] = " Taylor";
	
	strcat(f_name, "!");
	
	cout << f_name;

	return 0;
}
*/


int main(){
	struct info{
		int month, day, year;
		char m_name[4];
	}x = {12, 28, 1975, "Nov"};
	
	/*	  
	cout << x.month << "/" << x.day << "/" << x.year;
	cout << endl << "Month name is: " << x.m_name;
	*/
	
	struct employee{
		int struct_hired;
		int struct_fired;
	}a;
	
	a.hired.month = 12;
	a.hired.day = 28;
	a.hired.year = 1965
	
	a.fired.month = 4;
	a.fired.day = 18;
	a.fired.year = 2018;
	
	return 0;
}

