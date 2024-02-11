import pyautogui

pyautogui.hotkey("alt", "tab")

x, y = pyautogui.position()
pyautogui.write(f"{x}, {y}")