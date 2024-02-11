/*

type var_name[size]
allocates size * sizeof(type) bytes 
WHEN DECLARED THIS WAY THE ARRAY CAN ONLY HAVE THE AMOUNT OF MEMORY IT STARTS WITH
initially the values are garbage. they'll be random or something idk

arrays don't know how big they are
but you can use "sizeof(var_name) / sizeof(type)"
passing arrays to a function turns them into pointers
changing the pointers changes the array outside of the function

*/

#include <stdio.h>

void array_info();
void copy_array();

int main(int argc, char** argv){
    
    int numbers[] = {1,2,3,4,5};                                            //can also do "numbers[5] = {1,2,3,4,5}"

    printf("sizeof:\n");
    printf("Size of an int: %d\n", sizeof(numbers[0]));    
    printf("Size of the array: %d\n", sizeof(numbers));                     //size multiplied by sizeof(type)
    printf("Size of address of int: %d\n", sizeof(&numbers[0]));
    array_info(numbers);



    int source[5] = {0,5,10,20,25};
    int destination[5];
    copy_array(source, destination, 5);

    int i;
    for(i = 0; i < sizeof(source) / sizeof(source[0]); i++){    
        printf("src[i] = %d\n", source[i]);
        printf("dst[i] = %d\n\n", destination[i]);
    }

    return 0;
}

void array_info(int* numbers){
    printf("Size of array inside a function: %d\n\n\n", sizeof(numbers));   //sizeof the pointer
}

void copy_array(int* src, int dst[], int size){                             //specifying pointer or not changes nothing
    int i;
    for(i = 0; i < size; i++){
        dst[i] = src[i];
    }                                                                       //affects outside of scope of this function
}