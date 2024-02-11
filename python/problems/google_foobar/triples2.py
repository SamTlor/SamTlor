def solution(l):

    hold = {}

    index = len(l) - 1

    factors = []
    for i in l[::-1]:
        for j in l[index::-1]:
            if i % j == 0:
                factors.append(j)
        if len(factors) > 2:
            for a in range(len(factors)-2):
                for b in range(a+1, len(factors)):
                    if factors[a] % factors[b] == 0:
                        for c in range(b+1, len(factors)):
                            if factors[b] % factors[c] == 0:
                                #print("A: ",factors[a] ,"B: ",factors[b] ,"C: ",factors[c])
                                hold[factors[a], factors[b], factors[c]] = ""
                                #hold.append([factors[a], factors[b], factors[c]])
        factors = []
        index -= 1


    return len(hold)


test1 = [1, 1, 1, 2, 3, 4, 5, 6]
test2 = [1, 1, 1,1,1,1]
test3 = [1,6,11]


print(solution(test1))
#print(solution(test2))
#print(solution(test3))