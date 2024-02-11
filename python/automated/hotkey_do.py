import pyautogui as pag
import time, random
pag.hotkey("alt", "tab")                        #EVERY hotkey_do HAS to start with alt tab so the cmd window closes


for i in range(26):
    pag.click(2598, 398)
    time.sleep(5)
    pag.click(3329, 1245)
    time.sleep(5)