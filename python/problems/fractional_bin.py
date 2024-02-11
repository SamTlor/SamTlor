import math



num = 94.8198 
num = round(num - math.floor(num), 4)

print(num)

ending = ""
for i in range(7):
    print(num * 2)
    if num * 2 > 1:
        num = num * 2 -1
        ending += '1'
    else:
        num *= 2
        ending += '0'

print(ending)