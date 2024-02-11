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
    
    for b in range(h-1):
        height = 2 ** b - 2
        first = between[0] + 2 + height

        for a in hold:
            if a != None and first < between[1]:
                if first not in bottom:
                    bottom.append(first)
                first = first + a + height
        if q in bottom:
            for num in bottom:
                if num - 2**b == q or num - 1 == q:
                    print("works:", q - 2**(b), q-1)
                    break
    print(bottom)


print(solution(5,25))