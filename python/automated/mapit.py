# shouts out to automate the boring stuff by Al Sweigart

import webbrowser, sys, pyperclip

if len(sys.argv) > 1:
    address = ' '.join(sys.argv[1:])
else:
    address = pyperclip.paste()

webbrowser.open("https://google.com/maps/place/" + address)