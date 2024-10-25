class Soluion:
    def fizzbuzz(self, num):
        i = 1                           #where to start
        while i <= num:                 #don't use for i in range
            ending = ""

            if i % 3 == 0:              #divisible by 3
                ending += "fizz"
            if i % 5 == 0:              #divisible by 5
                ending += "buzz"
            
            if ending:                  
                print(ending)
            else:
                print(i)
            
            i += 1

thing = Soluion()
thing.fizzbuzz(115)