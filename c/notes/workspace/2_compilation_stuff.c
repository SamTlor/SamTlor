/*

COMPILATION PROCESS:
hello.c                 src
    >PRE-PROCESSOR
hello.i                 modified src
    >COMPILER
hello.s                 assembly program
    >ASSEMBLER
hello.o                 object programs
printf.o
    >LINKER
hello                   executable

*/

#include <stdio.h>

int main(){
    printf("hello\n");
}