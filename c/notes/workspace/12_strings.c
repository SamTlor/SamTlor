#include <stdio.h>
#include <string.h>

int main(){

    char* x0 = "hello\n";               //different ways of declaring strings
    char x1[] = "hello\n";
    char x2[7] = "hello\n";             //this one can't be modified before C99


/*
    char white_space[20];
    char set_length[20];
    scanf("%s", white_space);           //allows length of array or until white space
    scanf("%4s", set_length);           //allow certain amount of characters
    printf("your name is %s.\n", white_space);
    printf("your name is %s.\n", set_length);



    char string[20];
    fgets(string, sizeof(string), stdin);
    printf("THe string is: ");
    puts(string);
*/


    sizeof(x2);                         //how many the array can hold
    strlen(x2);                         //how many until '\0



    char comp1[] = "allo";
    char comp2[] = "bllo";
    printf("%d\n", strcmp(comp1, comp2));   //says which comes first alphabetically. negative for first one first



    char* phrase = "semen";
    char* search = "advertisements";
    printf("%d\n", strchr(search, "m")); //search the search term for the phrase front to back



    //idk how to get this to work but you can, like, have a dynamic array pretty much
    char* infinite_string;
    infinite_string = "Hello";
    char addon[] = " i'm writing onto a var";
    char addon2[] = " that can have any number of chars in it";
    strcat(infinite_string, addon);
    strcat(infinite_string, addon2);
    printf("%s", infinite_string);
    return 0;
}