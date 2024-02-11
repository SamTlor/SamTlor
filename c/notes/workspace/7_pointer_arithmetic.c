#include <stdio.h>

void swap();

int main(){

    int arr[3] = {2,3,4};           //array
    int* p = &arr[1];               //pointer to arr[1]
    int** dp = &p;                  //pointer to a pointer

    printf("Before\n");
    printf("%d\n", arr[0]);         //  2
    printf("%d\n", arr[1]);         //  3
    printf("%d\n", arr[2]);         //  4
    printf("%p\n", p);
    printf("%p\n", dp);



    *(*dp) += 1;                    //one asterisk gets p. two asterisks gets arr[1]
    p += 1;                         //pointer + 1 means it goes up by how much space the type uses. p points at arr[2] now
    *(*dp) += 1;                    //one asterisk gets p. two asterisks gets arr[2] now

    printf("\nAfter\n");
    printf("%d\n", arr[0]);         //  2
    printf("%d\n", arr[1]);         //  4
    printf("%d\n", arr[2]);         //  5
    printf("%p\n", p);
    printf("%p\n\n", dp);



    p--;
    p[1] = 111;                     //pointer as an array makes it go up by how many elements in []
                                    //the element the pointer is on doesn't change though
    printf("After after\n");
    int i;
    for(i = 0; i < 3; i++){
        printf("%d\n", arr[i]);
    }
    printf("pointer is still on this element: %d\n\n", *p);



    int orig_a = 42;
    int orig_b = 3;
    printf("a before:%d\n", orig_a);
    printf("b before:%d\n", orig_b);
    swap(&orig_a, &orig_b);             //pointers can be used to change variables outside of their scope
    printf("a now:%d\n", orig_a);
    printf("b now:%d\n", orig_b);
    return 0;

}

void swap(int* a, int* b){
    int tmp = *a;
    *a = *b;
    *b = tmp;
}