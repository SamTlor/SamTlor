import sys, re, pyautogui, pygetwindow, time, pyperclip

def terminal_open(filename):
    pyautogui.hotkey("ctrl", "shift", "`")                  #opens new terminal
    
    if (len(sys.argv) == 2) and (sys.argv[1] == "package") :        
        pyautogui.hotkey("ctrl", "j")
        pyautogui.hotkey("shift", "alt", "c")               #get the name of the full file path     
        pyautogui.hotkey("ctrl", "j")
        
        look = re.compile(r"(.*?)\\cmsc256\\")              #stops once it finds /cmsc256/
        change_directory = look.findall(pyperclip.paste())  #saves just the parent directory

        pyautogui.write("cd " + change_directory[0])        #changes directory
        pyautogui.hotkey("enter")
        
        pyautogui.write(f"javac ./cmsc256/{filename}")      #writes out the package part
        pyautogui.hotkey("enter")
        pyautogui.write(f"java cmsc256/{filename[:-5]}")
        pyautogui.hotkey("enter")

    else:
        time.sleep(.25)
        pyautogui.write(f"javac {filename}")                #doesn't write out the package part
        pyautogui.hotkey("enter")
        pyautogui.write(f"java {filename[:-5]}")
        pyautogui.hotkey("enter")


#if __name__ == "__main__":
windows = pygetwindow.getAllWindows()[1:5]          #gets the names of all open windows in an array
search = re.compile(r"(.*?).java")                  #is looking for something that ends in .java

pyautogui.hotkey("alt", "tab")
for current in windows:                             #current is one of the open windows
    var = search.search(current.title)              #finds the first open window
    if var != None:
        terminal_open(var.group())
        break