from config import vcu_password
import pyautogui as pag

pag.hotkey("alt", "tab")
pag.write(vcu_password)