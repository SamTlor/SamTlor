from operator import add, mul

def helper(answer, nums, operations):
    if len(nums) == 1:
        return int(answer) == nums[0]
    
    a, b, *rest = nums
    for op in operations:
        if helper(answer, [op(a, b)] + rest, operations):
            return answer
    return 0



def part_one():
    
        
    ending = 0
    operations = [add, mul]
    for answer in equations:
        if helper(answer[0], answer[1:], operations):
            ending += answer[0]
            
    print(ending)

def part_two():
    
            
    ending = 0
    def cat(a, b): return int(f"{a}{b}")
    operations = [add, mul, cat]
    for answer in equations:
        if helper(answer[0], answer[1:], operations):
            ending += answer[0]
            
    print(ending)
    

equations = []
for line in open('day7.txt'):
    equations.append(list(map(int, line.replace(':', '').split())))
    
part_one()
part_two()