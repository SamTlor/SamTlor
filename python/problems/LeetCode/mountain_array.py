"""
class Solution:                                         #mine was fatser but used way more memory
    def validMountainArray(self, arr):
        peak = arr[0]

        if len(arr) < 3:
            return False

        up = arr[0] < arr[1]
        if up == False:
            return False

        for i in range(1, len(arr)):
            if arr[i] == peak: return False

            if up == True:
                if arr[i] > peak:
                    peak = arr[i]
                else:
                    up = False

            if up == False:
                if arr[i] < peak:
                    peak = arr[i]
                else:
                    return False
        return not up
"""

class Solution:
    def validMountainArray(self, arr):
        n = len(arr)
        
        i = 0
        while i + 1 < n and arr[i] < arr[i + 1]:
            i += 1
        
        if i == 0 or i == n - 1:
            return False

        while i + 1 < n and arr[i] > arr[i + 1]:
            i += 1

        return i == n - 1

thing = Solution()
var = [9,8,7,6,5,4,3,2,1,0]
print(thing.validMountainArray(var))