def solution(l):
    l.sort()
    count = 0

    webster = {}

    for i in reversed(range(len(l))):
        string = ""
        for j in reversed(range(i)):
            if l[i] % l[j] == 0:    
                for k in reversed(range(j)):
                    if l[j] % l[k] == 0:
                        string += str(l[i])
                        string += ","
                        string += str(l[j])
                        string += ","
                        string += str(l[k])
                        webster[string] = ""
    for x in webster:
        if isinstance(webster[x], str):
            count += 1
    return count


test1 = [1, 2, 3, 4, 5, 6]
test2 = [1, 1, 1]
test3 = [1,6]

print(solution(test1))
print(solution(test2))
print(solution(test3))