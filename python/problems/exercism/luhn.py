import re

num = "8273 1232 7352 0569"
string = ""


foo = re.compile(r"\d\d\d\d")
bar = foo.findall(num)

for a in bar:
    for b in range(len(a)):
        if b % 2 == 0:
            temp = int(a[b]) * 2
            if temp > 10:
                temp = temp - 9
            string += str(temp)
            continue
        string += a[b]

add = 0
for q in string:
    add += int(q)

print(add)