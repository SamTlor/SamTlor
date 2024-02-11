import bs4, requests
from urllib.request import urlopen

html = urlopen("https://treehouse-projects.github.io/horse-land/index.html")
soup = bs4.BeautifulSoup(html.read(), "html.parser")

div = soup.find("div", {"class" : "featured"})

print(div.get_text())