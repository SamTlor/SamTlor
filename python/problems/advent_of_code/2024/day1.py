def part_one():
    lefts = []
    rights = []

    with open("day1.txt") as f:
        while line := f.readline():
            left, right = line.split("   ")
            lefts.append(left)
            rights.append(right)
            
        
    lefts.sort()
    rights.sort()


    ending = 0
    for i in range(0, len(lefts)):
        ending += abs(int(lefts[i]) - int(rights[i]))

    print(ending)
    
def part_two():
    lefts = []
    rights = {}
    ending = 0
    
    with open("day1.txt") as f:
        while line := f.readline():
            left, right = line.split("   ")
            
            # store all of the numbers on the left because they all need to be multiplied by the number of rights
            lefts.append(left)
            
            # while we're looking through every line use this opportunity to 
            # count the amount of times right appears in rights
            if int(right) not in rights:
                rights[int(right)] = 1
            else:
                rights[int(right)] = rights[int(right)] + 1
                
    for left in lefts:
        if int(left) in rights:
            ending += int(left) * rights[int(left)]
        
    print(ending)



part_one()
part_two()