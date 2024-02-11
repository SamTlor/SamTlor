"for i in range(5):"                    #for:       lets you do the same action multiple times. this runs 5 times
"for i in range(1,6)"                               #also runs 5 times
"with pag.hold('ctrl'):"                #hold:      holds a key while do other stuff
"pag.press(['left', 'backspace'])"      #press:     presses everythin in the array in order
"pag.hotkey('ctrl', 'backspace')"       #hotkey:    presses two buttons at the same time
"pag.write('whatever')"                 #write:     writes whatever. works with f"{var}"
"pag.position()"                        #position:  just use cursor_find.py one file over
"pag.click(x,y)"                        #click:     clicks on position (x, y) with the mouse
"pag.moveTo(x,y)"                       #moveTo:    moves the mouse to position (x,y)
"pag.screenshot('something.png')"       #screenshot:always use the full file name to be safe and do it with a png





import pyautogui as pag
pag.hotkey("alt", "tab")                #EVERY hotkey_do HAS to start with alt tab so the cmd window closes

for i in range(10):
    pag.press("tab", "left", "delete")  #does these things in this order