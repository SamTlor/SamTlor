/*

dynamically allocated memory
memory whose size is not known in advance by the caller 
C requires you to Manualy Manage Memory

malloc allocates a block of memory of the requested size

forget to free a malloced block and get a MEMORY LEAK

*/


#include <stdio.h>
#include <stdlib.h>

int i;                                                      //global variable so it goes in the data section
int main(){
    int j;                                                  //local to main() so it goes in the stack section
    int* k = (int*) malloc(sizeof(int));                    //dynamically allocated so it goes in the heap section



    int* first_byte = (int*) malloc(10 * sizeof(int));      //for an array of 10 items
    printf("%p\n", first_byte);                             //first_byte is the address of the first element of array



    int* all_zeros = (int*) calloc(10, sizeof(int));        //for an array of 10 items
    printf("%d\n", all_zeros[0]);



    all_zeros = (int*) realloc(all_zeros, 20 * sizeof(int));//all_zeros does not have all zeros anymore
    printf("%d\n", all_zeros[13]);                          //realloc gives garbage values



    free(first_byte);                                       //gives the memory back any values are deleted
    free(all_zeros);
    printf("%d\n", all_zeros[0]);                           //now they have garbage values



    //common mistakes
    int a[2];
    int* b = (int*) malloc(2 * sizeof(int));
    int* c;
    
/*
    a[2] = 5;                                               //assign past the end of the array
    b[0] += 2;                                              //assume a value created by malloc is 0. malloc makes garbage
    c = b + 3;                                              //make a pointer past end of the array
    free(&(a[0]));                                          //free something not made by malloc or calloc
    free(b);
    free(b);                                                //double free same block
    b[0] = 5;                                               //use a freed pointer
*/
    free(b);                                                //don't forget to free malloced things


    
    return 0;
}