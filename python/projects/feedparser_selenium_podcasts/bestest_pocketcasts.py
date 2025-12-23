import feedparser, re, requests, time, os, login

from selenium import webdriver
from selenium.webdriver.chrome.service import Service
from selenium.webdriver.chrome.options import Options
from webdriver_manager.chrome import ChromeDriverManager

for a in feedparser.parse("https://feeds.megaphone.fm/dailyzeitgeist").entries:    #feedparser. it's slow but it works
    if re.match("Weekly Zeitgeist 207", a.title):                                      #if it finds an episode with thte name weekly zeitgeist
        page = requests.get(a.links[0]["href"])                                    #store page as the link to the episode
        title = str(a.title)[0:20]                                                 #save the title for the upload
        break                                                                      #done searching
open(f'C:/Users/samtl/OneDrive/Documents/zome_files/python/projects/pocketcasts/holder/{title}.mp3', 'wb').write(page.content)


chrome_options = Options()
chrome_options.add_argument("headless")
#chrome_options.headless = True
driver = webdriver.Chrome(service = Service(ChromeDriverManager().install()), options=chrome_options)
driver.set_window_size(1920,1080)



def element_clicker(elem):#clicks on any element you tell it to
    try:
        action = webdriver.ActionChains(driver)
        driver.implicitly_wait(3)
        action.move_to_element(elem)
        elem.click()
    except:
        time.sleep(1)
        action = webdriver.ActionChains(driver)
        driver.implicitly_wait(3)
        action.move_to_element(elem)
        elem.click()

#logs in
driver.get("https://play.pocketcasts.com/podcasts")#goes to login page
email = driver.find_element_by_xpath("/html/body/div[1]/div/div/div[2]/div/div/form/div[1]/div/input")#types in email
email.send_keys(login.email)
password = driver.find_element_by_xpath("/html/body/div[1]/div/div/div[2]/div/div/form/div[3]/div/input")#types in password
password.send_keys(login.password)
sign_in = driver.find_element_by_xpath("/html/body/div[1]/div/div/div[2]/div/div/form/div[7]/button")#signs in
element_clicker(sign_in)


#goes to the upload page
profile = driver.find_element_by_xpath("/html/body/div[1]/div/div/div[2]/div[1]/div/div/header/div[2]")#goes to my profile dropdown
element_clicker(profile)
files = driver.find_element_by_xpath("/html/body/div[1]/div/div/div[2]/div[1]/div/div/header/div[2]/div/div/div/div[3]/div[2]/p")#goes to files
element_clicker(files)
try:                    #sees if the "No Files" input tag is there
    upload = driver.find_element_by_xpath("/html/body/div[1]/div/div/div[2]/div[1]/div/div/div/input")
except:                 #if "no files" isn't there then the "upload new" one must be there
    upload = driver.find_element_by_xpath("/html/body/div[1]/div/div/div[2]/div[1]/div/div/div/table/tbody/tr[1]/th[5]/div/div[2]/input")
upload.send_keys(f"C:/Users/samtl/Documents/zome_files/python/projects/pocketcasts/holder/{title}.mp3")      #upload the podcast


#sorts the items by most recent upload
arrow = driver.find_element_by_xpath("/html/body/div[1]/div/div/div[2]/div[1]/div/div/div/table/tbody/tr[1]/th[4]/p")
if arrow.text != "UPLOAD DATE ▼":
    element_clicker(arrow)
    

#waits 15 minutes for the podcast to upload
i = 0
while i < 180:
    try:                                    #clicks on the title of the podcast to pull up the add to queue buttons
        dots = driver.find_element_by_xpath("/html/body/div[1]/div/div/div[2]/div[1]/div/div/div/table/tbody/tr[2]/td[1]/div/p")
        if dots.text == f"{title}.mp3":     #when the first item is the one i want stop waiting
            break
    except:
        i += 1
        time.sleep(5)


episodes = driver.find_elements_by_xpath("/html/body/div[1]/div/div/div[2]/div[1]/div/div/div/table/tbody/tr")
for j in range(2, len(episodes) + 1): #goes through the list of episodes that have already been uploaded
    ep = driver.find_element_by_xpath(f"/html/body/div[1]/div/div/div[2]/div[1]/div/div/div/table/tbody/tr[{j}]/td[4]/p")
    color = driver.find_element_by_xpath(f"/html/body/div[1]/div/div/div[2]/div[1]/div/div/div/table/tbody/tr[{j}]")
    if color.value_of_css_property("color") == "rgba(95, 101, 104, 1)": #deletes any that are grey because they've already been listened to
        time.sleep(2)
        element_clicker(ep)
        delete = driver.find_element_by_xpath("/html/body/div[3]/div[3]/div/div[1]/div[2]/div/div/div[2]/div[2]/div[6]")
        element_clicker(delete)
        yes = driver.find_element_by_xpath("/html/body/div[3]/div/div[3]/div[1]/div[3]/div[3]/button[2]")
        element_clicker(yes)
element_clicker(dots)
time.sleep(1)

last = driver.find_element_by_xpath("/html/body/div[3]/div[3]/div/div[1]/div[2]/div/div/div[2]/div[2]/div[3]")#clicks the add last button
element_clicker(last)

driver.close()
time.sleep(1)

os.remove(f'C:/Users/samtl/Documents/zome_files/python/projects/pocketcasts/holder/{title}.mp3')