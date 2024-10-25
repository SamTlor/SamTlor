from typing import List


class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        skip = 0

        i = 0
        for j in range(1, len(nums)):
            if nums[j] != nums[i]:
                i += 1
                nums[i] = nums[j]

        return i + 1

if __name__ == "__main__":
    thing = Solution()
    
    stufs = [3,4,5,0, 0]

    print(thing.removeDuplicates(stufs))