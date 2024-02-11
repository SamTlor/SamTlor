# include <stdio.h> // line 1
int a = 101; 
char b = 'z'; 

int q(char b) {
    int a = 89;
	printf ("%c\n",a);	
    printf("%d\n",b);		// line 7
	return a;
}

void p() {
    double b = 2.6;
    printf("%c\n",a);
    printf("%f\n",b); 	// line 13 
    a = q(a);
}

int main() {
	char a = 'L'; 
	printf("%c\n",b); 	// line 17 
	p();
	return 0;
}
