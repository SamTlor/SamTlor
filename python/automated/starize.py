import pyperclip, pyautogui

pyautogui.hotkey("alt", "tab")
pyautogui.hotkey("ctrl", "c")
copied = pyperclip.paste()
howManyStars = len(copied) + 4


withStars = f"""/{"*" * (howManyStars - 1)}
* {copied.upper()} *
{"*" * (howManyStars - 1)}/"""

pyperclip.copy(withStars)
pyautogui.hotkey("ctrl", "v")

