#this subreddit is like dead now :( 
#but every now and then they'll post a new one and i want to know when they do
#also i wanted to learn more about praw


import praw, smtplib, login
from datetime import date




def new_url(new_one):
    file1 = open("login.py", "r").readlines()                   #save login.py for later

    rewritten = open("login.py", "w")                           #so i can write to login now
    for i in file1:
        if (i == f"last_daily = \"{login.last_daily}\""):       #find the old last_daily
            rewritten.write(f"last_daily = \"{new_one}\"")      #change it to the new daily
        else:
            rewritten.write(i)                                  #keep the file the same otherwise
    rewritten.close()







#connecting to reddit
reddit = praw.Reddit(client_id = login.client_id, 
                     client_secret = login.client_secret, 
                     user_agent = login.user_agent)

#getting correct subreddit
sub = [reddit.subreddit("dailyprogrammer").new(limit = 1)]


#so dumb it's just one item but this is the best way to access it
for item in sub:
    if item.url != login.last_daily:
        new_url(item.url)
        
        #smtplib connection
        conn = smtplib.SMTP("smtp.gmail.com", 587)
        conn.ehlo()
        conn.starttls()
        conn.login(login.email, login.password)
        conn.sendmail(login.email, login.destination, f"Subject: New Daily Programmer post. {date.today().strftime('%m/%d/%Y')}\n\n{item.title}\n{item.url}")
        conn.quit()