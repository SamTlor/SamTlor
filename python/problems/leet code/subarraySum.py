class Solution():
    def subarraySum(self, nums, k):
        """
        caboose = len(nums) - 1

        table = {}
        while caboose != 0:
            table[nums[caboose]] = nums[:caboose]
            table[nums[caboose]].append(0)
            caboose -= 1

        return table
        """


        table = {}
        for i in range(len(nums)):
            table[nums[i]] = nums[:i]
            table[nums[i]].append(0)

        counting = 0
        for a in table:
            for b in table[a]:
                if a + b == k:
                    counting += 1
        return counting


thing = Solution()
print(thing.subarraySum([-1,-1, 1], 0))     #this breaks it because the output should be 1. but that's stupid becuase
                                            #you could do -1 and 1 or the second -1 and 1. idk