class Solution():
    def prime_numbers(self, num):
        if num > 1:
            for i in range(2, num // 2 + 1):
                if num % i == 0:
                    return False
            return True
        else:
            return False

thing = Solution()
print(thing.prime_numbers(11))