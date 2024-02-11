from config import rPi_ipAddy, rPi_name, rPi_password
import pyautogui, time, os

def write_enter(var):
    time.sleep(.5)
    pyautogui.write(var)
    time.sleep(.5)
    pyautogui.press("enter")

os.startfile("C:/Program Files/PuTTY/putty.exe")
time.sleep(.5)
write_enter(rPi_ipAddy)
write_enter(rPi_name)
write_enter(rPi_password)
write_enter("tightvncserver")
os.startfile("C:/Program Files/RealVNC/VNC Viewer/vncviewer.exe")
time.sleep(2)
write_enter(rPi_ipAddy)
time.sleep(4)
write_enter(rPi_password)