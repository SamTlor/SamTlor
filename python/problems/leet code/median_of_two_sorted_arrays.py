class Solution:
    def findMedianSortedArrays(self, nums1, nums2):
        nums3 = nums1 + nums2
        nums3.sort()

        if len(nums3) % 2 == 1:
            return nums3[len(nums3) // 2]
        else:
            return (nums3[len(nums3) // 2] + nums3[len(nums3) // 2 - 1]) / 2


sol = Solution()
print(sol.findMedianSortedArrays([1,2], [3,4]))