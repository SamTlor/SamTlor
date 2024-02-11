import pyperclip, pyautogui, math


### if you want it to print out after running this then here it is
### this method uses the built in binary commands from python
#pyautogui.hotkey("alt", "tab")

### this is how i tested it. 
# thing = [182, 216, 73, 17, 43, 52, 212, 121, 19, 134]
# for i in range(10):
#     pyautogui.press("tab")

#     var = thing[i]
#     var = bin(var).replace('0b', '')
#     x = var[::-1]
#     while len(x) < 8:
#         x += '0'
#     var = x[::-1]

#     pyautogui.write(f"{var}")
#     pyautogui.press("tab")



### this version is more readable
start = float(pyperclip.paste().strip())
num = round(start - math.floor(start), 4)
binned = int(round(start - num, 1))

ending = bin(binned) + '.'
for i in range(11):
    if num * 2 > 1:
        num = num * 2 -1
        ending += '1'
    else:
        num *= 2
        ending += '0'

pyperclip.copy(ending)