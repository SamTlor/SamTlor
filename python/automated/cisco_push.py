from config import vcu_password
import pyautogui as pag
import time

time.sleep(1)
pag.press("win")
pag.write("cisco")
pag.press("enter")
time.sleep(.5)
pag.press("enter")
time.sleep(2)
pag.write(vcu_password)
pag.press("tab")
pag.write("push")
pag.press("enter")