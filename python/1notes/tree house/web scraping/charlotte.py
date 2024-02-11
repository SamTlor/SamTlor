from urllib.request import urlopen
from bs4 import BeautifulSoup

import re

links = []

def internal(url):
    html = urlopen("https://treehouse-projects.github.io/horse-land/{}".format(url))

    soup = BeautifulSoup(html, "html.parser")
    
    return soup.find("a", href=re.compile("(.html)$"))
    
links = []

if __name__ == "__main__":
    urls = internal("index.html")
    while len(urls) > 0:
        page = urls.attrs["href"]
        if page not in links:
            links.append(page)
            print(page)
            print("\n==========================\n")
            urls = internal(page)
        else:
            break