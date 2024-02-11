import pyperclip, pyautogui

better = ""
for i in pyperclip.paste():
    if i == "\\":
        better += "/"
        continue
    better += i

pyperclip.copy(better + "/")
pyautogui.hotkey("alt", "tab")
pyautogui.hotkey("ctrl", "v")