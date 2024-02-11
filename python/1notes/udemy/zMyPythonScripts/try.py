cats = input("How many cats do you own?")

try: 
    if int(cats) >= 4:
        print("That's a lot of cats")
    else:
        print("That's not that many cats")
except ValueError:
    print("That wasn't a number")