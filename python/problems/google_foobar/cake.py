def solution(s):

    var = len(s)
    maximum = 0

    for i in range(var,0,-1):
        sub = s[0:i]
        foo = s.count(sub)#how many times sub appears in s
        temp = ""
        for _ in range(foo):
            temp += sub
        if temp == s:
            if foo > maximum:
                maximum = foo

    return maximum



print(solution("abcabcabcabcabc"))