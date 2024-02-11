/*

LINUX FOLDER COMMANDS:
/       the root directory
.       the current directory
..      the parent directory
~       the home directory

LINUX COMMANDS:
ls      list the contents of a folder
-l      long listing option. includes permissions, date created, etc.
>       redirect output to a file
<       get input from from a file
cp      copies everything from <file1> and puts it all in <file2>. <file1> stays
mv      copies everything from <file1> and puts it all in <file2>. <file1> deleted
rm      removes <file> or <dir> that is empty
rm -r   removes <dir> and all of its contents
mkdir   creates a new directory
who     lists who is logged onto the system
whoami  says what user you are logged in as
ps      lists your processes on the system
ps aux  lists all processes on the system
pwd     you are here. prints out current folder

HELP:
help    for built in commands like cd, exit, pwd
man     anything else

FILE PERMISSIONS:
TYPE        ABBREVIATION        BIT VALUE
read        r                   4
write       w                   2
execute     x                   1

every file has an OWNER, GROUP, OTHER
owner      group       other
-rwx        rwx         rwx

chmod_ _ _   gives permissions to a file based on the bit value where the _ are
7 is rwx because 4+2+1 = 7
5 is r x because 4+0+1 = 5

*/