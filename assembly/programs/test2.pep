BR main

txt:     .ASCII "Enter a char: \x00"
char1:    .BLOCK 2
char2:   .BLOCK 2
num1:     .word 0
num2:    .word 0

main:    ldba 0xFC15, d
         adda -32, i
         stba char1, d
         stba num1, d


         ldba 0xFC15, d
         adda -32, i
         stba char2, d
         stba num2, d




if:      ldba num1, d
         cpba num2, d
         brlt else


         LDBA char2, d 
         STBA char2, d
         STBA 0xFC16, d
         LDBA char1, d
         STBA char1, d
         STBA 0xFC16, d


         BR ending
else:    LDBA char1, d
         STBA char1, d
         STBA 0xFC16, d
         LDBA char2, d
         STBA char2, d
         STBA 0xFC16, d
         BR ending


ending:  stop
.end
