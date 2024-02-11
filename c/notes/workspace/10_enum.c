/*

associates int constants with names

*/

#include <stdio.h>

enum year{Jan, Feb, Mar, Apr, May, Jun, Jul, Aug, Sep, Oct, Nov, Dec};      //automatically assigns consecutive nums

int main(){
    int i;
    for (i = Jan; i <= Dec; i++){
        printf("%d ", i + 1);
    }

    return 0;
}