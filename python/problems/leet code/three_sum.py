class Solution:
    def threeSum(self, nums):
        ending = []

        for i in nums:
            index = nums.index(i) + 1
            for j in nums[index:]:
                if i + j in nums:
                    ending.append[nums.index(i), nums.index(j), nums.index(i + j)]

        return ending


thing = Solution()
print(thing.threeSum([-1,0,1,2,-1,-4]))