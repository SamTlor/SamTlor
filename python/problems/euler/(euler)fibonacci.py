fib = ['1','1']
def test():
    if len(fib[-1]) == 4:
        return False
    else:
        return True

while test():
    last = int(fib[-1])
    second = int(fib[-2])
    fib.append(str(last+second))

i = fib[-1]
print(fib.index(i))