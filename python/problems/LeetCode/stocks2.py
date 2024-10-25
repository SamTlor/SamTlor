class Solution:
    def maxProfit(self, prices):
        if len(prices) == 1:
            return 0

        max_profit = start = 0
        end = 1

        while end < len(prices):
            if prices[start] < prices[end]:
                max_profit = max(max_profit, prices[end] - prices[start])
            else:
                start = end
            end += 1
        return max_profit



thing = Solution()
print(thing.maxProfit([7,1,5,3,6,4]))
print(thing.maxProfit([7,6,4,3,1]))