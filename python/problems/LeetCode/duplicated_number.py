class Solution:
    def findDuplicate(self, nums):

        #using sort
        """
        nums.sort()
        for i in range(0, len(nums) - 1):
            if nums[i] == nums[i + 1]:
                return nums[i]
        """

        #using hash
        seen = set()
        for i in nums:
            if i in seen:
                return i
            seen.add(i)

thing = Solution()
print(thing.findDuplicate([3,1,3,4,2]))