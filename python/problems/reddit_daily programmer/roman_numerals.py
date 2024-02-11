characters = {"M" : 1000, "D" : 500, "C" : 100, "L" : 50, "X" : 10, "V" : 5, "I" : 1}

def roman(num):
    total = 0
    for i in range(len(num) - 2, -1, -1):
        if characters[num[i]] >= characters[num[i + 1]]: total += characters[num[i+1]]
        else: total -= characters[num[i+1]]
    total += characters[num[0]]

    return total

def numcompare(num1, num2):
    if roman(num1) < roman(num2):
        return True
    return False


"""
#better version. IV doesn't work in the old one

characters = {"M" : 1000, "D" : 500, "C" : 100, "L" : 50, "X" : 10, "V" : 5, "I" : 1}

def roman(num):
    total = 0 

    #i gets me the letters
    #index gets me the index of the string 

    for index, i in enumerate(num):
        try:
            if characters[i] >= characters[num[index + 1]]:     #if the value of the letter is bigger than the value of the next letter
                total += characters[i]
            else:                                               #if IV or XL 
                total -= characters[i]
        except:                                                 #at the end, num[index + 1] will be out of bounds
            total += characters[num[index]]

    return total

    
print(roman("IV"))
"""


"""
#best version.
#idk how it works

def numcompare(x, y):
    m = dict(zip("MDCLXVI", "🟥🟧🟨🟩🟦🟪🟫"))
    return x.translate(m) < y.translate(m)
"""

#print(numcompare("MM", "MMM"))
print(roman("IV"))