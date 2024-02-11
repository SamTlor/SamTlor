import pyautogui as pag
import time


# im = pag.screenshot()
# px = im.getpixel(1634, 199)

# pag.write(px)




with pag.hold("alt"):
    pag.press("tab")
    pag.press("tab")


time.sleep(3)
pix = pag.pixel(1634, 199)

with pag.hold("alt"):
    pag.press("tab")
    pag.press("tab")

pag.write(f"{pix}")

(148, 238, 62)