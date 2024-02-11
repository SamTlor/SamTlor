#include <stdio.h>

//main has to go at the end 
//or have helper functions declared like 'int sumTo(int);'
//or or have '#include "sumTo.h"' at the beginning where sumTo.h is a file that has 
//                                                          'int sumTo(int);' in it

int sumTo(int num){
    int i, sum = 0;
    for (i = 1; i <= num; i++){
        sum += i;
    }

    return sum;
}

int main(int argc, char** argv){
    printf("All these number added together is %d", sumTo(5));

    return 0;
}