;Sam Taylor
;Program 3
;convert to uppercase

         BR      main
char1:   .EQUATE 0           ;local variable #2d
char2:   .EQUATE 0


main:            LDBA 0xFC15, d       ;take input
                 ADDA -32, i          ;change to uppercase
                 STWA char1, d        ;save value in limit
                 STBA 0xFC16, d       ;output value

                 LDBA 0xFC15, d       ;input second character
                 ADDA -32, i          ;convert to uppercase
                 STWA char2, d        ;store it in num
                 STBA 0xFC16, d       ;print it out

if:              LDWA char1, s
                 CPWA char2, i
                 BREQ else
                 STRO msg1, d
                 BR   endIf

else:            STRO msg1, d
endIf:           STOP

msg1:            .ASCII "\nthe OTHER part ran \x00"
msg2:            .ASCII "\nEQUALS"
                 .END