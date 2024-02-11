def solution(xs):
    xs.sort()
    result = 1
    negs = 0
    pos = False
    smol_neg = xs[0]

    for i in xs: 
        if i != 0:
            result *= i
        if i < 0:
            negs += 1
            if i > smol_neg:
                smol_neg = i
        if i > 0:
            pos = True
            
    if result < 0:
        if negs > 2 or pos:
            result = result / smol_neg
        elif 0 in xs:
            result = 0
    if not pos and negs == 0:
        result = 0

        
    return(str(int(result)))