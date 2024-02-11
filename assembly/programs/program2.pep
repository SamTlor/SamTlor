; Sam Taylor
; Program 2
; calculate the sum and difference between two numbers
         STRO whatNUM, d
         DECI NUM1, d
         STRO whatNUM, d
         DECI NUM2, d

; processing
         LDWA NUM1, d        ;put num1 into the A memory
         ADDA NUM2, d        ;add num2 onto the A memory
         STWA SUM, d         ;store into sum the value in A 
         
         SUBA NUM2, d        ;A currently has sum so get num1 back
         SUBA NUM2, d        ;take off num2 again to get dif
         STWA DIF, d

Repeat:  LDWA PROD, d
         ADDA NUM1, d
         STWA PROD, d

         LDWA NUM2, d        ;decrement
         ADDA -1, i
         STWA NUM2, d
         BRNE Repeat         ;if num2 is not 0 keep going


; Output
         STRO MSG, d
         DECO SUM, d
         LDBA '\n', i

         STRO MSG2, d
         DECO DIF, d
         LDBA '\n', i

         STRO MSG3, d
         DECO PROD, d
         LDBA '\n', i

         STBA charOut, d
         STOP

;data segments
NUM1:    .word 0
NUM2:    .word 0
SUM:     .word 0
DIF:     .word 0
PROD:    .word 0

whatNUM: .ASCII "Enter a number: \x00"
MSG:     .ASCII "\nSum is: \x00"
MSG2:    .ASCII "\nDifference is: \x00"
MSG3:    .ASCII "\nProduct is: \x00"
         .END