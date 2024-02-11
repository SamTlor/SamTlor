class Solution():
    def addDigits(self, num):

        added = 0

        while num:
            added += num % 10
            num //= 10

        if added // 10 == 0:
            return added
        else:
            return self.addDigits(added)


"""
class Solution:
    def addDigits(self, num):
        if(num == 0):
            return 0
        elif(num % 9 == 0):
            return 9
        else:
            return num % 9
"""

thing = Solution()
print(thing.addDigits(38))