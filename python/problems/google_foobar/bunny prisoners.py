def solution(x,y):
    x = int(x)
    y = int(y)

    stack = []
    build = x + y - 1               #how tall to stack the boxes
    cell = 1                        #pyramid starts at 1

    for r in range(build):          #find the number of the highest box
        cell += r                   

    while build > 0:                
        stack.append(cell)
        cell += 1
        build -= 1

    return str(stack[x-1])

print(solution(input(),input()))    #first number is how many boxes in a row to go to. second number is the height of the row. x,y