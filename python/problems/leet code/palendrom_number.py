"""
class Solution:
    def isPalindrome(self, x):
        string = str(x)

        for i in range(len(string)):
            if string[i] != string[len(string) - 1 - i]:
                return False
        return True
"""

class Solution:                                             #this version is faster
    def isPalindrome(self, x):
        var = str(x)

        first = var[: len(var) // 2]

        if len(var) % 2 == 1:
            second = var[(len(var) // 2) + 1:]
        else:
            second = var[(len(var) // 2):]

        return first == second[::-1]

thing = Solution()
print(thing.isPalindrome(121))