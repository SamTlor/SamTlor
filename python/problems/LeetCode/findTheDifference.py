class Solution():
    def findTheDifference(self, s, t):

        s = "".join(sorted(s))
        t = "".join(sorted(t))


        for i in range(max(len(s), len(t)) - 1):
            if s[i] != t[i]:
                return t[i]
        return t[len(t) - 1]


thing = Solution()
print(thing.findTheDifference("acbd", "dcbae"))