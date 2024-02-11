from collections import defaultdict

class Solution:
    def fourSumCount(self, nums1, nums2, nums3, nums4):
        ht = defaultdict(int)
        for n1 in nums1:
            for n2 in nums2:
                ht[n1 + n2] += 1
        ans = 0
        c=0
        for n3 in nums3:
            for n4 in nums4:
                c=ht[-n3 - n4]
                ans +=c
        return ans

thing = Solution()
print(thing.fourSumCount([-1,-1], [-1,1], [-1,1], [1,-1]))