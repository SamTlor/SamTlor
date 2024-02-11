/*

Struct is a C datatype that contains fields
similar to a class but it doesn't have methods or constructors

*/

#include <stdio.h>

struct Point{
    int x, y;                               //variables can't be initialized here
} p1;

struct Employee{
    char name[20];
    double salary;
    struct date{
        int day;
        int month;
        int year;
    } dob;
} emp = {"Sam", 1000.00, {5,18,98}};           //struct inside a struct

typedef struct sq_point{
    int a, b;
} p3, *p3_pointer;

void square_numbers();

int main(){
    p1.x = 3;
    p1.y = 5;
    printf("X: %d\nY: %d\n\n", p1.x, p1.y);

    struct Point p2;                        //two ways of declaring a struct variable
    p2.x = 46;
    p2.y = 98;
    printf("X: %d\nY: %d\n\n", p2.x, p2.y);



    struct Point* pointer = &p1;            //pointer to a struct. needs -> to get vars
    printf("X: %d\nY: %d\n\n", pointer -> x, pointer -> y);



    struct Point arr[3];                    //array of structs
    arr[0].x = 1;
    arr[0].y = 2;
    arr[1].x = 3;
    arr[1].y = 4;
    arr[2].x = 5;
    arr[2].y = 6;
    printf("X: %d\nY: %d\n", arr[0].x, arr[0].y);
    printf("X: %d\nY: %d\n", arr[1].x, arr[1].y);
    printf("X: %d\nY: %d\n", arr[2].x, arr[2].y);



    printf("emp name: %s ", emp.name);      //showing struct in a struct
    printf("emp salary: %f ", emp.salary);
    printf("emp DOB: %d/%d/%d\n\n", emp.dob.day, emp.dob.month, emp.dob.year);



    struct Point p3 = {3,4}, *p3_pointer;
    square_numbers(&p3);
    printf("x: %d\n", p3.x);
    printf("y: %d\n", p3.y);



    return 0;
}

void square_numbers(p3_pointer in_struct){
    in_struct -> a = in_struct -> a * in_struct -> a;   //refers to a pointer so ->
    in_struct -> b = in_struct -> b * in_struct -> b;
}