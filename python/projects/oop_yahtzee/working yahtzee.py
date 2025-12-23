import hands

final = []
def numbers():                                                          #the actual Yahtzee game display
    print("\n\n\nlives: ", lives-1, "\n")
    print("Holding: ", keep)
    print("roll: ", hand)

#dictionary stores all player scores
card = {"ones": 0,
        "twos": 0,
        "threes": 0,
        "fours": 0,
        "fives": 0,
        "sixes": 0,
        "three of a kind": 0,
        "four of a kind": 0,
        "full house": 0,
        "small straight": 0,
        "large straight": 0,
        "chance": 0,
        "yahtzee": 0
        }


def filled():                                                           #makes sure the player still has empty values on their scorecard
    for i in card.values():
        if i == 0:
            return True
    return False


while filled():                                                         #makes sure the player still has empty values on their scorecard
    hand = hands.Yahtzee()
    keep = []
    lives = 3
    
    while lives != 1 and hand:   
        numbers()                                                       #the actual Yahtzee game display
        test = input("Which would you like to keep? or remove?").split(",")        #seperates on comma (array of str values)
        if test[0] == "remove":                                         #if the user wants to remove numbers
            for r in test[1::]:
                save = int(r)
                keep.remove(save)
                hand.append(save)
            continue
        if test == [""]:                                                #if the user wants to reroll without keeping any
            hand = hands.Yahtzee(size = (5 - len(keep)))
            lives -= 1
            continue  
        
        test = [int(i) for i in test]                                   #changes string input to int
        if all(item in hand for item in test):                          #if all of the items in test are in hand
            for t in test:
                hand.remove(t)                      #remove from hand the values of test
            keep.extend(test)                       #  add to keep    the values of test
            
            hand = hands.Yahtzee(size = (5 - len(keep)))                #set up next roll with the new sized hand
            lives -= 1

        else:
            print("That wasn't one of the numbers that was rolled. Try again.")
    
    keep.extend(hand)
    keep.sort()
    
    while True:
        try:
            print("\n\nend: ", keep)
            combo_type = input("How do you want to score these numbers? ")          #asks how to add to scorecard
            if combo_type == "chance":
                pass
            elif card[combo_type] != 0:                                               #if that combo has already been filled
                print("that one already has a value")
                raise Exception()
            points = hands.Yahtzee(keep = keep)
            var = points.method(combo_type)                                         #returns number of points you get
            break
        except:
            print("Incorrect input")
            pass

    card[combo_type] = var
    for a in card:
        print(f"{a}: {card[a]}\n")
    final.append(var)
    
print("final score: ", sum(final))