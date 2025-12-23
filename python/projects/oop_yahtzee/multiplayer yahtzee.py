import hands

final = {}
def numbers(keep, hand, player_id, lives):                    #the actual Yahtzee game display
    if lives == 3:
        print(f"\n\n\nPlayer  {player_id}: {player_number[player_id]}\n")
        for a in card:
            print(f"{a}: {card[a][player_id+1]}")
    print("\n\n\nlives: ", lives-1, "\n")
    print("Holding: ", keep)
    print("roll: ", hand)

#dictionary stores all player scores
card = {"ones": [0],
        "twos": [0],
        "threes": [0],
        "fours": [0],
        "fives": [0],
        "sixes": [0],
        "three of a kind": [0],
        "four of a kind": [0],
        "full house": [0],
        "small straight": [0],
        "large straight": [0],
        "chance": [0],
        "yahtzee": [0]
        }
player_number = {}

#asks how many players and assigns names and numbers
def players():
    how_many = int(input("How many people are playing?"))

    for y in range(how_many):
        name = input(f"What is your name, player {y}?")
        player_number[y] = name
        for z in card:
            temp = card[z]
            temp.append(0)

#checks scores of whichever player it is. 
def filled(player_number):
    for i in card.values():                                   #every list in the card dictionary
        if i[player_number+1] == 0:                           #the value at player_number of the list in the card dictionary
            return True
    return False



def game(player_id):
    hand = hands.Yahtzee()
    keep = []
    lives = 3

    while lives != 1 and hand:   
        numbers(keep, hand, player_id, lives)
        test = input("Which would you like to keep?").split(",")

        if test[0] == "remove":
            for r in test[1::]:
                save = int(r)
                keep.remove(save)
                hand.append(save)
            continue
        if test == [""]:
            hand = hands.Yahtzee(size = (5 - len(keep)))
            lives -=1
            continue  
        
        test = [int(i) for i in test]
        if all(item in hand for item in test):
            for t in test:
                hand.remove(t)
            keep.extend(test)
            
            hand = hands.Yahtzee(size = (5 - len(keep)))
            lives -= 1

        else:
            print("That wasn't one of the numbers that was rolled. Try again.")
    
    keep.extend(hand)
    keep.sort()

    while True:
        try:
            print("\n\nend: ", keep)
            combo_type = input("How do you want to score these numbers? ")
            if combo_type == "chance":
                pass
            elif card[combo_type][player_id+1] != 0:
                print("\nThat one already has a value")
                print(f"Here's your card, player {player_number[player_id]}:\n ")
                for a in card:
                    print(f"{a}: {card[a][player_id+1]}")
                numbers(keep, hand, player_id, lives)
                raise Exception
            points = hands.Yahtzee(keep = keep)
            num = points.method(combo_type)
            card[combo_type][player_id+1] = num
            break
        except:
            pass
    for a in card:
        print(f"{a}: {card[a][player_id+1]}")



players()
var = [i[0] for i in card.values()]                             #all of the first numbers in the dictionary list
while 0 in var:                             
    for a in card.values():                             
        if 0 not in a[1:]:                                      #if all of the players have a score for a combo type
            a[0] = 1                                            #set the first number in the array to one

    for j in player_number:
        if filled(j):
            game(j)
    var = [i[0] for i in card.values()]



for player_id in player_number:
    final = 0
    for end in card.values():
        final += end[player_id+1]
    print(player_number[player_id], " final: ", final)