# this makes a new java file with potential parameters

import sys, re, pyautogui, pygetwindow

search = re.compile(r"(.*?).java")              #something that ends in .java
windows = pygetwindow.getAllWindows()           #get names of all windows

pyautogui.hotkey("alt", "tab")
for current in windows:                         #go through all the windows that are open
    var = search.search(current.title)          #to find the one we're on
    if var != None:                             #returns None if it's not a match
        extras = []                             #for imports

        for a in range(1, len(sys.argv)):                                               #go through system variables
            if sys.argv[a].upper() == "SCANNER":                                        #Scanner is different because it needs System.in
                pyautogui.write("import java.util.Scanner;\n")
                extras.append("Scanner scan = new Scanner(System.in);")
            elif sys.argv[a].upper() == "ARRAYLIST":
                pyautogui.write("import java.util.ArrayList;\n")
                extras.append("ArrayList<    type    >    vrbl   = new ArrayList<>();")
            elif sys.argv[a].upper() == "PACKAGE":
                pyautogui.write("package cmsc256;\n\n")
            else:
                pyautogui.write(f"import java.util.{sys.argv[a]};\n")
                extras.append(f"{sys.argv[a]} {sys.argv[a][0:4]} = new {sys.argv[a]}();")
            if a == len(sys.argv) - 1:
                pyautogui.write("\n")

        pyautogui.write(f"public class {var.group()[:-5]} {{\npublic static void main(String[] args) {{\n\t")
        for b in extras:
            pyautogui.write(f"{b}\n")
        pyautogui.write(f"\nSystem.out.println(\"\");\n")
        pyautogui.press("backspace")
        pyautogui.write("}\n")
        pyautogui.press("backspace")
        pyautogui.press("backspace")

        break