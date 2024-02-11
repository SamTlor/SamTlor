index = []

def zimin(n,a):
    if n <= a:
        pattern.append(a)
    else:
        zimin(n-1,a)
        pattern.append(n)
        pattern.append(zimin(n-1,a)) 

def list_solution(h,items):
    final = []
    for q in items:
        final.append(solution(h,q))
    return final

def solution(h,q):
    for x in range(1, h + 1):
        index.append(2 ** x - 1)
    if q == index[-1]:
        return -1
    for y in range(len(index)-1):
        if index[y] <= q <= index[y+1]:
            between = index[y], index[y+1], y, y+1
    count = 0

    for row in index[between[3]::-1]:
        global pattern 
        global test
        pattern = []
        test = []

        zimin(row + count,row)
        count += 1

        start = row
        for a in pattern:
            if a != None:
                test.append(start)
                start = a + start
        if start < between[1]:
            test.append(start)
    

        for b in test:
            if b - 1 == q:
                return b
            elif b - int((row-1)/2 + 1) == q:
                return b
            

print(list_solution(3, [1, 4, 7]))