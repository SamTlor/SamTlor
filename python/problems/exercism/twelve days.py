#messing with regex
import re

lyrics = "12 drummers drumming, 11 pipers piping, 10 lords a leaping, 9 ladies dancing, 8 maids a milking, 7 swans swimming, 6 geese a laying, 5 golden rings, 4 calling birds, 3 french hens, 2 turtle doves, and 1 partridge in a pear tree"

#one or more digits followed by a space then a word between 2 and 25 characters long
xmasregex = re.compile(r"\d+[\s\w]{2,25}")
search = xmasregex.findall(lyrics)

day = 1
string = ""
for i in reversed(search):
    string = i + ", " + string
    print(f"On the {day} day of Christmas my true love gave to me: {string}\n")

    day += 1
