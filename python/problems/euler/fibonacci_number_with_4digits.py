# this finds which element of the fibonacci sequence is the first that has 4 digits
# in this case the 0th element is 1 and the 1st element is also 1
# the 15th element is 987 and the 16th element is 1597
fib = ['1','1']

# test sees if the last element of the list has 4 digits in it yet
# if it does then the while loop will break
def test():
    if len(fib[-1]) == 4:
        return False
    else:
        return True

# use memoization to 
while test():
    last = int(fib[-1])
    second = int(fib[-2])
    fib.append(str(last+second))

print(fib.index(fib[-1]))