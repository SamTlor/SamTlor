#include <stdio.h>

int main(){
    //variables
    //data type                                 32-bit  64-bit      printf
    char                var_chr = 'a';  //      1       1           %c

    short int           var_sint = 1;   //      2       2           %hd
    unsigned short int  var_usint = 2;  //      2       2           %hu
    int                 var_int = 3;    //      4       4           %d or %i
    unsigned int        var_uint = 4;   //      4       4           %u
    long int            var_long = 5;   //      4       4           %l
    long long int       var_llong = 6;  //      8       8           %lld

    float               var_float = 7.5;//      4       4           %f
    double              var_dub = 8.5;  //      8       8           %lf

    printf("%c\n", var_chr);
    printf("%hd\n", var_sint);
    printf("%hu\n", var_usint);
    printf("%i\n", var_int);
    printf("%u\n", var_uint);
    printf("%ld\n", var_long);
    printf("%lld\n", var_llong);
    printf("%f\n", var_float);
    printf("%lf\n", var_dub);



    //casting
    float var_cast = (float) 11 / 2;
    printf("%f\n", var_cast);
    int var_fti = (int) var_dub;
    printf("%d\n\n", var_fti);



    //expressions
    var_sint++;                         //increment. also uses +=, -=, *=, /=, %=
    printf("%d\n", var_sint);
    var_sint--;                         //decrement
    printf("%d\n", var_sint);
    printf("%lf\n", var_sint * var_int);//multiplication
    printf("%d\n", var_sint / var_int); //division
    printf("%d\n", var_sint + var_int); //addition
    printf("%d\n", var_sint - var_int); //subtraction
    printf("%d\n\n", var_sint % 2);     //modulus



    //booleans
    if(var_int < var_dub)
        printf("var_int < var_dub\n");
    if(var_int <= var_dub)
        printf("var_int <= var_dub\n");
    if(var_int == 1)
        printf("var_int == 1\n");
    if(var_int != 9)
        printf("var_int != 9\n");
    if(var_int < var_dub && 2 == 2)
        printf("var_int < var_dub && 2 == 2\n");
    if(var_int != 9 || 2 == 2)
        printf("var_int != 9 || 2 == 2\n\n");



    //user input
    int var_input;
    scanf("%d", &var_input);
    printf("%d\n\n", var_input);



    //loops
    for (int i = 0; i < 10; i++){
        printf("%d ", i);
    }
    printf("\n");

    int i = 0;
    while (i < 10){
        printf("%d ", i);
        i++;
    }

    //other stuff
    const int var_const = 3;            //cant be changed 'var_const = 5' gives error
     


    return 0;
}