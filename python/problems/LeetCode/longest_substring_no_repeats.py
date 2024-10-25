class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        seen = {}
        start = max_length = 0
        
        for i in range(len(s)):
            if s[i] in seen and start <= seen[s[i]]:
                start = seen[s[i]] + 1
            else:
                max_length = max(max_length, i - start + 1)

            seen[s[i]] = i

        return max_length


thing = Solution()
print(thing.lengthOfLongestSubstring("abcabcbb"))