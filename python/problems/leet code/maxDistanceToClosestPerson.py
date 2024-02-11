import math

class Solution:
    def maxDistToClosest(self, seats):
        filled = [-1]

        for i, s in enumerate(seats):
            if s == 1:
                filled.append(i)

        if len(filled) == 2:
            distance_from_start = filled[1]
            distance_from_end = len(seats) - 1 - filled[1]
            return max(distance_from_start, distance_from_end)
            

        most_dist = 0
        for i in range(len(filled) - 1):
            seat_gap = math.floor((filled[i + 1] - filled[i]) / 2)

            if seat_gap > most_dist:
                most_dist = seat_gap
            

        return most_dist




thing = Solution()
print(thing.maxDistToClosest([0,1]))