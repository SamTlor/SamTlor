# this won't work anymore since yahtzee left the escapist :(
# i should make a new one for his new channel :)


import smtplib
from login import email, password

from datetime import date

from selenium import webdriver
from selenium.webdriver.chrome.options import Options

options = Options()# instantiates selenium and chromedriver
options.headless = True
driver = webdriver.Chrome(options=options, executable_path="C:/Users/samtl/Documents/zome_files/python/jar/chromedriver.exe")
driver.set_window_size(1920,1080)
driver.get("https://www.youtube.com/Escapist/videos")



videos = driver.find_elements_by_css_selector("#video-title")
for i in videos:
    title = i.get_attribute("title")
    zero = "(Zero Punctuation)"
    dev_diary = "Yahtzee's Dev Diary"

    if (zero in title)  or  (dev_diary in title):

        conn = smtplib.SMTP("smtp.gmail.com", 587)
        conn.ehlo()
        conn.starttls()
        conn.login(email, password)
        conn.sendmail(  email,                                                                  #who's sending the email
                        "sam.tlor1@gmail.com",                                                  #who's getting the email
                        f"""Subject: New Yahtzee post.{date.today().strftime('%m/%d/%Y')}\n\n   
                            {title}\n
                            {i.get_attribute('href')}&t=11
                        """)
        conn.quit()

        break


driver.close()