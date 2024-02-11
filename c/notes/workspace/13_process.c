/*

"top" to get a list of all current process
pid_t getpid() returns pid of current process
pid_t getppid() returns pid of parent process

fork (give birth to a carbon copy child, from a running parent )
    returns 0 to the child process 
    returns childs pid to parent process
    child gets an identical copy of parent's virtual address space
    child gets identical copies of parent's open file descriptors
    child get different pid than parent
    called once and returns TWICE
exec (replace contents of program with another, e.g used when shell is running a program),
wait (parent waits on child),
exit (self-termination),
kill (process receiving kill will terminate, unless handles with signal)

processes can have one of three states:
    Running: executing or waiting to be scheduled 
    Stopped: process is suspended and will not be scheduled until further notice
    Terminated: process is stopped permanently

terminating process:
    recieves a signal whose default action is terminate
    returning from the main routine
    calling the exit function which terminates the program immediately
        normal return status is 0
        nonzero means there was an error
        another way to explicitly set the exit status is to return an int from the main routine
        is called once and never returns
*/

#include <stdio.h>
#include <sys/types.h>      //so you can use pid_t

int main(){
    printf("%d", getpid());             //current process ID
    printf("%d", getppid());            //current's parent prcess ID



    pid_t pid;
    int x = 1;
    printf("forking");                  //doesn't work with windows :( why did we learn this then??????
    pid = fork();                       //there are now two PIDs ex. ppid = 4316 and pid = 6789
                                        //                       ex. ppid = 6789 and pid = 0
    if (pid == 0){                      //selects for the child
        printf("child: x=%d\n", ++x);
        exit(0);
    }

    printf("parent: x=%d\n", --x);
    exit(0);
    return 0;
}