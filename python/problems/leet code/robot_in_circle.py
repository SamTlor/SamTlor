import math

class Solution:
    def isRobotBounded(self, instructions):
        ordered_pair = [0,0]

        direction = 0
        for i in instructions:
            if i == "G":
                ordered_pair[direction % 2] += round(math.cos( (direction // 2) * math.pi) )
            if i == "L":
                direction += 1
            if i == "R":
                direction -= 1

        return ordered_pair[0] == ordered_pair[1] == 0 or direction % 4 != 0


thing = Solution()
print(thing.isRobotBounded("GGLLGG"))

