#i used this in my 301 class a bunch of times to see all the possible permutations of stuff
import itertools

for i in list(itertools.product("HT", repeat= 4)):
    print(i)