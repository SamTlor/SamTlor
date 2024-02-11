pattern = []

def zimin(n,a):
    if n <= a:
        pattern.append(a)
    else:
        zimin(n-1,a)
        pattern.append(n)
        pattern.append(zimin(n-1,a)) 

zimin(31,30)
print(pattern)

#go backwards through the list
#get the child numbers of all numbers until it finds q
#child numbers are defined as (the parent - 1) and (the parent - 2 ** height )