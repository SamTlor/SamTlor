import math

class Solution:
    def isPowerOfTwo(self, n):
            if(n <= 0): return False
            return round(float(math.log(n, 2)), 9).is_integer()


thing = Solution()
print(thing.isPowerOfTwo(8))