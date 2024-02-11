         DECI width, d 
         DECI length, d
         LDWA perim, d

         ADDA width, i
         ADDA width, i
         ADDA length, i
         ADDA length, i

         STRO widmsg, d
         DECO width, d
         STRO lenmsg, d
         DECO length, d
         STRO permsg, d
         DECO perim, d

; data vars
width:   .word 0
length:  .word 0
perim:   .word 0

widmsg:  .ASCII "width = \x00"
lenmsg:  .ASCII "length = \x00"
permsg:  .ASCII "perim = \x00"

         .END