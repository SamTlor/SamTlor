;Sam Taylor
;Program 3
;convert to uppercase and say which comes first alphabetically
BR main
char1:   .BLOCK 2
char2:   .BLOCK 2
num1:    .word 0
num2:    .word 0
diffmsg: .ASCII "\nThe first letter alphabetically is: \x00"
samemsg: .ASCII "\nThey are the same letter so they can't be sorted"

main:    ldba 0xFC15, d           ;take input
         adda -32, i              ;convert to lowercase
         stba char1, d            ;store character for printing
         stba 0xFC16, d           ;print out letter
         stba num1, d             ;store decimal value for comparing

         ldba 0xFC15, d           ;same as above but with 2
         adda -32, i
         stba char2, d
         stba 0xFC16, d
         stba num2, d

if:      ldba num1, d             ;use the nums to compare
         cpba num2, d
         breq samelet             ;if they're the same letter
         stro diffmsg, d 
         brlt else                ;if char1 comes first alphabetically

         ldba char2, d
         stba 0xFC16, d
         stop

else:    ldba char1, d
         stba 0xFC16, d
         stop

samelet: stro samemsg, d
         .end
