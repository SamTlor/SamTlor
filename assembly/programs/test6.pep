;Sam Taylor
;Program 3
;convert to uppercase


start:   BR      main

         ;data segments
         .BLOCK 5
         CHAR1:  .BLOCK 0
         .BLOCK 5
         CHAR2:  .BLOCK 0 
         ifran:   .ASCII "\nThe if part ran\n"
         elran:   .ASCII "\nThe else part ran\n"     

main:    LDBA 0xFC15, d      ;input first character
         ADDA -32, i         ;convert to uppercase
         STBA CHAR1, d       ;store it in char1
;         STBA 0xFC16, d      ;print it out
         
         LDBA 0xFC15, d      ;input first character
         ADDA -32, i         ;convert to uppercase
         STBA CHAR2, d       ;store it in char2
;         STBA 0xFC16, d      ;print it out
        
if:      LDBA CHAR1,s        ;if (CHAR1 >= CHAR2)
         CPBA CHAR2,d        ;if char2 is less than char 1 on ascii
         BRLT else           ;char2 comes first alphabetically

;char2 comes first  
         ;STRO ifran, d
         LDBA CHAR2, d
         STBA CHAR2, d
         STBA 0xFC16, d
         LDBA CHAR1, d
         STBA CHAR1, d
         STBA 0xFC16, d

;char1 comes first
    ;STRO elran, d 
else:    LDBA CHAR1, d
         STBA CHAR1, d
         STBA 0xFC16, d
         LDBA CHAR2, d
         STBA CHAR2, d
         STBA 0xFC16, d

.END

