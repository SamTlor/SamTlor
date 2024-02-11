#in calculus i hated doing numerical integration
#cuz like, cmon we spend all semester learning how to do integrals and 
#then we have to do it like this?? no way am i spending an hour doing 
#all that work when i could spend 2 hours making sure this works right

import math, numpy

#variables. i could ask the user to input but i'm the user so like..
#i'll just input here myself
a = 4
b = 6
n = 50
change = (b-a) / n

#the equation
def mather(x):
    return math.e ** math.cos(x)



midpoint = 0
for i in numpy.arange(a,b,change):
    i = round(i, 5)
    midpoint += mather((i + i + change)/2)
print(change * midpoint)


trapezoid = (mather(a) + mather(b))/2
for i in numpy.arange(a + change,b,change):
    i = round(i,5)
    trapezoid += mather(i)
print(change * trapezoid)


simpson = mather(a) + mather(b)
outer = 0
for i in numpy.arange(a + change, b, change):
    i = round(i, 5)
    if (outer == 0):
        simpson += 4 * mather(i)
        outer += 1
    else:
        simpson += 2 * mather(i)
        outer -= 1
print((change/ 3) * simpson)