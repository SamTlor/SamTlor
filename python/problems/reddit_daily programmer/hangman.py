man = [         "    ______     ", #0 
                "    |    }     ", #1
                "    |          ", #2
                "    |          ", #3
                "    |          ", #4
                "    |          ", #5
                "____|__________"] #6

def hang(word):
    correct = []
    incorrect = []
    for _ in range(len(word)):
        correct.append("_")


    while len(incorrect) < 7 and "_" in correct:
        print("\n\n\n\n\nCorrect: ", correct, "\nIncorrect: ", incorrect)
        for i in man:
            print(i)


        guess = input("guess a letter\n")

        if guess[0] in word:
            j = 0
            for i in word:
                if i == guess[0]:
                    correct[j] = guess[0]
                j += 1
        else:
            incorrect.append(guess[0])
            var = len(incorrect)
            if var == 1:
                man[2] = man[2][:9] + "0" + man[2][10:]
            if var == 2:
                man[3] = man[3][:9] + "|" + man[3][10:]
            if var == 3:
                man[3] = man[3][:8] + "/" + man[3][9:]
            if var == 4:
                man[3] = man[3][:10] + "\\" + man[3][11:]
            if var == 5:
                man[4] = man[4][:9] + "|" + man[4][10:]
            if var == 6:
                man[5] = man[5][:8] + "/" + man[5][9:]
            if var == 7:
                man[5] = man[5][:10] + "\\" + man[5][11:] 
                man.append("You lose :(\nThe answer was: " + word)
    print("\n\n\n\n\n")
    if len(man) != 8:
        man.append("Woohoo! You win! :D\nThe answer was: " + word)
    for j in man:
        print(j)        


hang(input("Have someone write a word."))