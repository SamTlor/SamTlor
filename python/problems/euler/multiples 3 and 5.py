hold = []

for i in range(1000):
    if i % 3 == 0 or i % 5 == 0:
        hold.append(i)
        
print(sum(hold))