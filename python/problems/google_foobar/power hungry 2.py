def solution(xs):
    xs.sort()
    positive = []
    negative = []
    zeros = []
    for i in xs: 
        if i > 0:
            positive.append(i)
        if i < 0:
            negative.append(i)
        if i == 0:
            zeros.append(i)
    if len(negative) % 2 == 1 and len(negative) > 1: #if three or more negatives
        del negative[-1]
    
    if len(negative) == 1 and len(positive) == 0 and len(zeros) > 0: #if one negative, no positives, and some zeros
        positive.extend(zeros)

    positive.extend(negative)   

    answer = None
    for r in positive:
        if answer == None:
            answer = r
        else:
            answer *= r
    if answer == None:
        answer = 0
    return str(answer)
    
test1 = [2,-3,1,0,-5]
test2 = [2, 0, 2, 2, 0]
test3 = [-2, -3, -5]
test4 = [-3]
test5 = [0]


print(solution(test1))
print(solution(test2))
print(solution(test3))
print(solution(test4))
print(solution(test5))