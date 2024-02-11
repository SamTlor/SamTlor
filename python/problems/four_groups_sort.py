houses = ['h','h','g','r','r','h','h','r','r','g','h','s','h','h','h','r','s','s','h','g','g','r','s','g','g']

low = 0                                 # g
high = len(houses) - 1                  # s
mid = 0                                 # r
mid2 = 0                                # h

#main loop from 0 to n
while mid2 <= high:
    if houses[mid2] == 'g':                                         #
        houses[low], houses[mid2] = houses[mid2], houses[low]
        low += 1
        if mid < low:
            mid += 1
        if mid2 < low:
            mid2 += 1
    elif houses[mid2] == 'h':
        mid2 += 1
    elif houses[mid2] == 'r':
        houses[mid], houses[mid2] = houses[mid2], houses[mid]
        mid += 1
        mid2 += 1
    else:
        houses[mid2], houses[high] = houses[high], houses[mid2]
        high -= 1
        

        
print(houses)