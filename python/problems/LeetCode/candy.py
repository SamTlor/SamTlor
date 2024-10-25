class Solution:
    def candy(self, ratings) -> int:
        start = ratings.index(min(ratings))
        ending = []
        
        ending[start] = 1
        
        # from (the element after start) -> (end of the array) - 1
        for i in range(start + 1, len(ratings) - 1):
            three = self.candy_helper(ratings, i)
            
            ending[i - 1] += three[0]
            ending[i] += three[1]
            ending[i + 1] += three[2]
        
        # from (the element before start) -> 1
        for i in range(start - 1, 0, -1):
            three = self.candy_helper(ratings, i)
            
            ending[i - 1] += three[0]
            ending[i] += three[1]
            ending[i + 1] += three[2]
            
            
            
        return sum(ending)
            
        
        
    
    def candy_helper(self, ratings, start):
        try:
            left = ratings[start - 1]
        except:
            left = 0
        
        try:
            right = ratings[start + 1]
        except:
            right = 0
            
        these_three = []
        these_three[0] = 2 if ratings[start] > left else 1
        these_three[1] = 1
        these_three[2] = 2 if ratings[start] > right else 1
        
        return these_three
            
        
        
print(Solution().candy([1,0,2]))