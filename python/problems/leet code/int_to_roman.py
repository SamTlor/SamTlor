class Solution:
    def __init__(self):     #hash map. all of the possible letters correlating to their numbers. IX'x and CM's included
        self.numerals = { "M" : 1000, "CM" : 900, "D" : 500, "CD" : 400, "C" : 100, "XC" : 90, "L" : 50, "XL" : 40, "X" : 10, "IX" : 9, "V" : 5, "IV" : 4, "I" : 1 }

    def intToRoman(self, num):
        ending = ""

        for i in self.numerals:                                     #small numbers // big numbers == zero so wont change anything
            ending += ( num // self.numerals[i] ) * str(i)          #otherwise its the amount of times a roman number goes into num
            num %= self.numerals[i]                                 
        return ending



thing = Solution()
print(thing.intToRoman(450))