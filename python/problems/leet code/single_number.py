class Solution:
    def singleNumber(self, nums):
        ending = 0
        for i in nums:
            ending ^= i

        return ending

thing = Solution()
print(thing.singleNumber([4,1,2,1,2]))