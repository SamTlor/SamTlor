# i would just use chatGPT for this now


import re

# ()? means that the stuff inside the parentheses is optional
# it will return the word in compile or it will cause an error
batregex = re.compile(r"Bat(wo)?man")
var1 = batregex.search("The adventures of Batwoman")                                        #Batwoman
var2 = batregex.search("The adventures of Batman")                                          #Batman
var3 = batregex.search("The adventures of Superman")                                        #""
for i in [var1, var2, var3]:
    try:
        print(f"{i.group()}")
    except:
        print("\"\"")
print("\n\n")

# a common use for ^^ is phone numbers
phoneregex = re.compile(r"(\d\d\d-)?\d\d\d-\d\d\d\d")
var4 = phoneregex.search("My phone number is 867-5309. call me tomolly")                 #867-5309
var5 = phoneregex.search("My phone number is 703-867-5309. call me tomolly")             #867-5309
var6 = phoneregex.search("My phone number is (703) 867-5309. call me tomolly")           #867-5309
for i in [var4, var5, var6]:
    try:
        print(f"{i.group()}")
    except:
        print("\"\"")
print("\n\n")

#returns if the stuff next to the "*" or if it's not
batregex = re.compile(r"Bat(wo)*man")
two = batregex.search("The adventures of Batman")                                       #Batman
three = batregex.search("The adventures of Batwoman")                                   #Batwoman
print(two.group() + "\n" + three.group() + "\n\n")

#returns (thing){however many times} if it's there. error otherwise
ha_regex = re.compile(r"(ha){3}")
three = ha_regex.search("he said hahahahahaha")                                         #hahaha
four = ha_regex.search("he said haha")                                                  #              error
try:
    print(three.group(), four.group())
except:
    print(three.group(), "\nFour.group() caused an error\n\n")

#returns (thing){however many times based on how many are there between the values} if it's there
ha_two_regex = re.compile(r"(ha){3,5}")
nother = ha_two_regex.search("he said haha")                                            #               error
nother1 = ha_two_regex.search("he said hahaha")                                         #hahaha
nother2 = ha_two_regex.search("he said hahahaha")                                       #hahahaha
nother3 = ha_two_regex.search("he said hahahahaha")                                     #hahahahaha
nother4 = ha_two_regex.search("he said hahahahahaha")                                   #               error
try:
    print(nother.group(), nother1.group(), nother2.group(), nother3.group(), nother4.group() + "\n")
except:
    print( "nother.group() caused an error" )
    print( nother1.group() ) 
    print( nother2.group() )
    print( nother3.group() )
    print( "nother4.group() caused an error\n\n" )

#returns any digits if their quantity is between the {}. It will stop after the upper value. error otherwise
digit_regex = re.compile(r"\d{3,5}")
digs = digit_regex.search("1")                                                          #               error
digs1 = digit_regex.search("123")                                                       #123
digs2 = digit_regex.search("12345")                                                     #12345
digs3 = digit_regex.search("123456789")                                                 #12345
try:
    print( digs.group() )
except:
    print("digs.group() caused an error")
    print( digs1.group() )
    print( digs2.group() )
    print( digs3.group() + "\n\n")


#returns any amount of digits, a space, any amount of things that are not commas. commas tell it to start a new amount of things
# "\d+" for any amount of digits, " " for a space, "[^,]+" for amount of things that aren't commas
lyrics = "12 drummers drumming, 11 pipers piping, 10 lords a leaping, 9 ladies danceing, 8 maids a milking, 7 swans a swimming, 6  geese a laying, 5 golden rings, 4 calling birds, 3 french hens, 2 turtle doves, and 1 partridge in a pear tree"
xmasregex = re.compile(r"\d+ [^,]+")
real = xmasregex.findall(lyrics)                                                        #find all returns an array
print(real, "\n\n")

#returns [any of the letters between the square brackets]{when this many of them are next to each other} in a list
brackets_regex = re.compile(r"[aeiouAEIOU]{2}")
fake = brackets_regex.findall("robocop eats baby food")                                 #ea, oo
print(fake)
print("\n")

#returns [any of the letters between the square brackets] but it can be single letters OR letters next to each other
plus_regex = re.compile(r"[aeiouAEIOU]+")
opaque = plus_regex.findall("robocop eats baby food")                                   #o,o,o,e,a,a,o,o
print(opaque, "\n\n")

#returns [any of the letters between the square brackets] in a list
cons_regex = re.compile(r"[aeiouAEIOU]")
obscure = cons_regex.findall("robocop eats baby food")                                  #o,o,o,e,a,a,o,o
print(obscure, "\n\n")

#returns the thing if the thing after "^" is at the beginning of the sentence/variable
begin_regex = re.compile(r"^Hello")
grevious = begin_regex.search("Hello there. General Kenobi")                            #Hello
greeting = begin_regex.search("Uhh Hello")                                              #               None
print( grevious.group() )
print( greeting, "\n\n")

#returns the thing if the thing before "$" is at the end of the sentence/variable
end_regex = re.compile(r"world!$")
endr = end_regex.search("Hello world!")                                                 #world!
endr_two = end_regex.search("Hello world!asdf")                                         #               None
print( endr.group() )
print( endr_two, "\n\n")

#returns if any amount of digits starts and ends the sentence and are there without letters there too
all_digit_regex = re.compile(r"^\d+$")
works = all_digit_regex.search("2493858795")                                            #2493858795
will = all_digit_regex.search("skdjfl2493858795sldkjfskd")                              #               None
dont = all_digit_regex.search("24938XXXXXXX58795")                                      #               None
print( works.group() )
print( will )
print( dont, "\n\n")

#returns the first letter before the thing that comes after "."
atregex = re.compile(r".at")
foo = atregex.findall("the cat in the hat shat on the flat mat")                        #'cat', 'hat', 'hat', 'lat', 'mat'
print(foo)
print("\n")

#returns {this many if they're there} before the thing that comes after "."
newatregex = re.compile(r".{1,2}at")
bar = newatregex.findall("the cat in the hat shat on the flat mat at brrat")            #' cat', ' hat', 'shat', 'flat', ' mat', rrat'
print(bar)
print("\n")

#matches the thing in the r" " and any amount of words after that
nameregex = re.compile(r"First name: (.*) Last name: (.*)")
fubar = nameregex.findall("First name: Sam Last name: Taylor")                          #('Sam', 'Taylor')
fuckedupbar = nameregex.findall("First name: Sam Zachary Last name: Taylor")            #('Sam Zachary', 'Taylor')
print( fubar ) 
print( fuckedupbar, "\n\n")

#returns once it finds the thing after what's in parentheses
nongreedy = re.compile(r"<(.*?)>")
variable = nongreedy.findall("<To serve humans> for dinner.>and maybe desert>")         #to serve humans
print(variable)

#returns once it finds the last time that it finds the thing after what's in parentheses
greedy = re.compile(r"<(.*)>")
clever_variable_name = greedy.findall("<To serve humans> for dinner.>and maybe desert>")#to serve humans> for dinner.>and maybe dessert
print(clever_variable_name)