word = input("What word do you want to test?")

def test(word):
    for i in word:
        if word.count(str(i)) > 1:
            return False
    return True

print(test(word))
