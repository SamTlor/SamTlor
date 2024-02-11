import random
name = input("What is your name?")
number = random.randint(1,20)

guess = print(f"Hello, {name}, I'm thinking of a number between 1 and 20.")
tries = 5

while guess != number and tries != 0:
    guess=int(input(f"Take a guess. You have {tries} more tries\n"))
    tries -= 1
    if guess > number:
        print("Nope. Too high")
    elif guess < number:
        print("Nope. Too low")

if guess == number:
    print(f"You got it, {name}! Congratulations! It only took you {tries} tries!")
else:
    print(f"Sorry, the number I was thinking of was {number}")