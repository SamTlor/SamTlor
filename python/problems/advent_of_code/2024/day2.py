safepos = set([1, 2, 3])
safeneg = set([-1, -2, -3])
           
def helper(line):
    inc = True
    dec = True
    valid_diff = True
    
    for i in range(1, len(line)):
        diff = line[i - 1] - line[i]

        if line[i - 1] < line[i]:
            dec = False
        elif line[i - 1] > line[i]:
            inc = False
            
        if diff not in safepos and diff not in safeneg:
            valid_diff = False
            break

    if (inc or dec) and valid_diff:
        return(1)
    return(0)
    
            
def part_one():
    ending = 0
    with open("day2.txt") as f:
        while line := f.readline().strip():
            line = list(map(int, line.split()))
            ending += helper(line)
            
            
    print(ending)

#  O(n) idgaf7
def part_two():
    ending = 0
    with open("day2.txt") as f:
        while line := f.readline().strip():
            line = list(map(int, line.split()))
            if helper(line) != 1:
                for i in range(0, len(line)):
                    thing = line[:i] + line[i+1:]
                    if helper(thing) == 1:
                        ending += 1
                        break
            else:
                ending += 1
            
    print(ending)
            

part_one()
part_two()