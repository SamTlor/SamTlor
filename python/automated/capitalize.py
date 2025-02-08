import pyperclip, pyautogui

pyautogui.hotkey("alt", "tab")
pyautogui.hotkey("ctrl", "c")
pyautogui.write(f"{pyperclip.paste().upper()}")