;Sam Taylor 
;Program 3 
;convert to uppercase 
  
         STRO txt, d
         LDBA 0xFC15, d      ;input first character 
         ;ADDA -32, i         ;convert to uppercase 
         STBA CHAR1, d       ;store it in char1 
         
         STBA charnum1, d
  
         STRO txt, d
         LDBA 0xFC15, d      ;input second character 
         ;ADDA -32, i         ;convert to uppercase 
         STBA CHAR2, d       ;store it in char2 
         STBA charnum2, d


         DECO charnum1, d
         DECO charnum2, d  

  
;data segments 
         txt:    .ASCII "Enter chars"
         CHAR1:  .BLOCK 2
         CHAR2:  .BLOCK 2 
         charnum1:           .word 0
         charnum2:           .word 0
         .END 