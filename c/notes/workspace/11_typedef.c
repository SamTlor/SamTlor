/*

"typedef type name;"
allows you to define datatypes as keywords

*/

typedef unsigned long long superlong;
typedef char* str;                              //"str" is a synonym for char*

#include <stdio.h>

int main(){

    superlong number = 939359520934759;
    str speech = "hello this is a thing that i am saying in front of a lot of ppl";

    printf("%lld\n", number);
    printf("%s", speech);



    return 0;
}