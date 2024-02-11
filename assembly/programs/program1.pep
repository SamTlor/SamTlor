; Sam Taylor
; Program 1
; calculate the sum and difference between two numbers
         STRO prompt, d
         DECI NUM1, d
         STRO prompt, d
         DECI NUM2, d

; processing
         LDWA NUM1, d
         ADDA NUM2, d
         STWA SUM, d
         
         SUBA NUM2, d
         SUBA NUM2, d
         STWA DIF, d

; Output
         STRO MSG, d
         DECO SUM, d
         LDBA '\n', i

         STRO MSG2, d
         DECO DIF, d
         LDBA '\n', i

         STBA charOut, d
         STOP

;data segments
NUM1:    .word 0
NUM2:    .word 0
SUM:     .word 0
DIF:     .word 0

prompt:  .ASCII "Enter a number: \x00"
MSG:     .ASCII "\nSum is: \x00"
MSG2:    .ASCII "\nDifference is: \x00"
         .END