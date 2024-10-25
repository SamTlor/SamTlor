class Solution:
    def myAtoi(self, s):
        s = s.strip()
        blanks = ["0", "-", "+", ""]
        if s in blanks:
            return 0

        i = 0
        ending = ""
        if s[i] == "-" and s[i + 1].isnumeric():
            ending += s[i]
            i += 1
        if s[i] == "+" and s[i + 1].isnumeric():
            i += 1

        while i < len(s) and s[i].isnumeric():
            ending += s[i]
            i += 1
        
        if ending in blanks:
            return 0 





        real_ending = int(ending)
        if real_ending < (2 ** 31) * -1:
            return (2 ** 31) * -1
        if real_ending > (2 ** 31) -1:
            return (2 ** 31) -1
        return real_ending



thing = Solution()
print(thing.myAtoi("42"))