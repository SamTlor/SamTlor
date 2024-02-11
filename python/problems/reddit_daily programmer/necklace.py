phrase1 = list(input("\nWhat's the first word?"))
phrase2 = list(input("And the second?"))

def necklace(first, second):
    for i in range(len(first)):
        test = first[i:] + first[:i]

        if test == second:
            return True
    return False



print(necklace(phrase1, phrase2))