# You have N boxes in your room which you want to carry to a different place. There are too many to carry in one trip, 
# so you want to split them into several piles using the following algorithm: if the current pile has at most M boxes, 
# you can carry it as is, otherwise you split it into P parts as equally as possible (i.e. so that the sizes of the 
# parts differ at most by 1) and apply the same algorithm to each of the parts. If you're trying to split less than P
# boxes into P piles, discard resulting zero-sized piles (see example 2).

# Calculate the number of piles you'll get in the end.

# The only line of input contains three space-separated integers: N, M and P. 
# 1 <= N <= 100, 
# 1 <= M <= 5, 
# 2 <= P <= 5.






# Example 1
# input 11 2 2
# output 7

# The sequence of pile splits you do is:
# 11 -> 6 + 5
# 6 -> 3 + 3
# 5 -> 3 + 2
# 3 -> 2 + 1 (applied to three piles of 3 boxes each)

# You end up with 4 piles of 2 boxes and 3 piles of 1 boxes, a total of 7 piles.





# Example 2
# input 3 2 5
# output 3

# The sequence of pile splits you do is:
# 3 -> 1 + 1 + 1 + 0 + 0

# You have to split a pile of 3 boxes into 5 parts, so you get 3 piles of 1 box and 2 empty piles which you discard.




def split_evenly(number, piles):
    
    # // always rounds down
    quotient = number // piles
    
    # gets the remainder from ^
    remainder = number % piles
    
    # quotient is always rounded down so we always get (quotient + 1) for 
    result = [quotient] * (piles - remainder) + [quotient + 1] * remainder

    return result



def real(number, most, piles, holder = {}):
        
    # base case: 0's get discarded
    if number == 0: return 0

    # base case: number less than most takes 1 trip
    if number <= most: return 1
    
    # check if result has been memoized yet
    if number in holder: return holder[number]
    
    # sum the results of the split
    adder = 0
    for i in split_evenly(number, piles):
        adder += real(i, most, piles, holder)
        
    # then memoize that result for the other calls
    holder[number] = adder
    
    
    # all done
    return holder[number]

print(real(11, 2, 2))
print(real(3, 2, 5))
print(real(10, 2, 2))