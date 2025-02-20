import pyperclip, pyautogui
import time

pyautogui.hotkey("alt", "tab")

# copy till home
pyautogui.keyDown('shiftleft')
pyautogui.keyDown('shiftright')
pyautogui.press("home")
pyautogui.keyUp('shiftleft')
pyautogui.keyUp('shiftright')

pyautogui.hotkey("ctrl", "c")
copied = pyperclip.paste()
howManyStars = len(copied) + 4


withStars = f"""/{"*" * (howManyStars - 1)}
* {copied.upper()} *
{"*" * (howManyStars - 1)}/"""

pyperclip.copy(withStars)
pyautogui.hotkey("ctrl", "v")