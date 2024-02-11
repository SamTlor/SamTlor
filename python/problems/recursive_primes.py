#sees if a number is prime
#but recursively

class Solution():
    def is_prime(self, num, i = 2):             #base cases
        if num <= 2:                            #if number is 2
            return True
        if num % i == 0:                        #if number is divisible by i 
            return False                        #def cant be prime
        if i * i > num:                         #cool math thing lol
            return True

        return self.is_prime(num, i + 1)        #recursive step

print(Solution().is_prime(2))