def binary(head):
    hold = []
    for i in range(len(head)):
        hold.append(i)
    
    real = []
    for j, k in zip(reversed(head), hold):
        real.append(j * 2 ** k)
    return sum(real)

print(binary([0,0]))