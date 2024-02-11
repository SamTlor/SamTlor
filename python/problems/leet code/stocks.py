#all you need to do is find a low number and then a higher number after it for there to be a profit

class Solution:
    def maxProfit(self, prices):
        i = 0
        max_profit = 0
        while i < len(prices) - 1:
            i += 1
            if prices[i] > prices[i-1]:
                max_profit += prices[i] - prices[i-1]

        return max_profit 


thing = Solution()
print(thing.maxProfit([7,1,5,3,6,4]))
