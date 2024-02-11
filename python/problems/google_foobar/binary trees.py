hold = []
top = []
bottom = []

def factorial(n):
    if n <= 1:
        hold.append(1)
    else:
        factorial(n-1)
        hold.append(n)
        hold.append(factorial(n-1)) 

def solution(h,q):
    index = []

    for x in range(1, h + 1):
        index.append(2 ** x - 1)
    for y in range(len(index)-1):
        if index[y] < q < index[y+1]:
            between = index[y], index[y+1], y, y+1
            factorial(y+1)
    first = between[0]+1
    for b in range(1,between[3]+1):
        height = 2 ** b - 2
        for a in hold:
            if a != None and first < between[1]:
                bottom.append(first)
                first = first + a + height
        first = between[0]+1+2**(b+1)-2
    
    var = bottom.index(q)
    bounds = 0
    count = 0
    adder = []

    for z in reversed(range(4)):
        if bounds <= var < (2 ** z + bounds):
            print(bounds, var, (2 ** z + bounds), count)
            adder.append((bounds,(2 ** z + bounds)))
        bounds = 2 ** z + bounds
        count += 1

    print(adder)
    return bottom


print(solution(5,16))