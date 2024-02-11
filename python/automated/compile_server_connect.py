from config import compile_username, vcu_username, vcu_password
import os, time
import pyautogui as pag
pag.hotkey("alt", "tab")

os.startfile("C:/Program Files/PuTTY/putty.exe")

time.sleep(.5)
pag.write(compile_username)
pag.press("enter")

time.sleep(.5)
pag.write(vcu_username)
pag.press("enter")

time.sleep(.5)
pag.write(vcu_password)
pag.press("enter")