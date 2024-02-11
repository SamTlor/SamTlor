import random

while True:
    dice = input("What kind of dice?")
    if dice == "aaa":
        break

    if "d" in dice:
        split = dice.split("d")
        sum = 0
        for i in range(int(split[0])):
            sum += random.randint(1,int(split[1]))
        print(sum)