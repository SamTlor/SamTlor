/*
Description: This is an example of a c program with command line arguments running on VScode
Author: Sam Taylor
*/


#include <stdio.h>

int main(int argc, char *argv[]){
    printf("argc: \t%d \n", argc);          //if there is only one value argc = 3
    printf("argv[0]: \t%s \n", argv[0]);    //prints whole file name
    printf("argv[1]: \t%s \n", argv[1]);    //prints argc
    printf("argv[2]: \t%s \n", argv[2]);    //prints the first thing that was entered

    return 0;
}