import pyperclip, pyautogui

pyautogui.hotkey("alt", "tab")
pyautogui.write(f"{pyperclip.paste().upper()}")