/*

The OS gives each process the illusion of its own private memory
"The address space"
contains the process' virtual memory

STACK is for local variables
DATA is for global and static variables
HEAP is for dynamically allocated data
    malloc() to borrow
    free() to return


POINTERS are variables that store addresses
store a location on the address space 

*/

#include <stdio.h>

int show_static(){
    static int count = 0;               //makes it so that this number will change every time the function is called
    count++;                            //but this function can only be called from this file
    return count;
}

int main(){
    //static
    printf("Show static:\n");
    printf("%d\n", show_static());
    printf("%d\n\n", show_static());



    //pointers
    int var = 1;                        //a value
    int* var_pointer = &var;            //the memory address of the value

    printf("Value and its address:\n");
    printf("%d\n", var);
    printf("%p\n\n", var_pointer);



    int* address = &var;                //you can still get the address from the actual value
    int actual_value = *var_pointer;    //you can still get the actual value from a pointer

    printf("The address and its value:\n");
    printf("%p\n", address);
    printf("%d\n\n", actual_value);



    return 0;
}