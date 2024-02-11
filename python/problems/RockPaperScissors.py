import random

WhatItBe = {1: "Rock", 2: "Paper", 3 : "Scissors"}

player = 0
cpu = 0

var = input("Rock, paper, or Scissors?")
while var != 'q':
    try:
        var = int(var)
        if var > 3:
            raise Exception()
    except:
        print("some'n hat'nd")
        var = input("Rock, paper, Scissors?")
        continue

    oponent = random.randint(1,3)
    print(f"\nPlayer: {WhatItBe[var]}\t cpu: {WhatItBe[oponent]}")
    if (oponent == var + 1) or (oponent == 1 and var == 3):
        cpu += 1
        print("cpu wins :(")
    elif (oponent == var - 1) or (var == 1 and oponent == 3):
        player += 1
        print("player wins! :D")
    else:
        print("Tie")
    
    var = input("Rock, paper, or Scissors?")

print(f"\n\n\n\nFinal score: \nCPU: {cpu}\nPlayer: {player}\n\n")
if cpu > player:
    print("CPU wins")
elif cpu < player: 
    print("PLAYER WINS!!!")
elif cpu == player:
    print("tie")