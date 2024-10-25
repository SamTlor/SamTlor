class Solution:
    def maxArea(self, height):
        biggest_area = 0
        for i in range(len(height)):
            for j in range(i + 1, len(height)):
                this_area = min(height[i], height[j]) * abs(i - j)
                
                if this_area > biggest_area:
                    biggest_area = this_area

        return biggest_area

thing = Solution()
print(thing.maxArea([1,8,6,2,5,4,8,3,7]))