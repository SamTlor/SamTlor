def part_one():
    def one_helper(answer, nums):
        if len(nums) == 1:
            return int(answer) == nums[0]
        
        if one_helper(answer - nums[-1], nums[:-1]):
            return True
        if answer % nums[-1] == 0 and one_helper(answer / nums[-1], nums[:-1]):
            return True
        return False



    equations = {}
    with open("day7.txt") as f:
        while line := f.readline().strip():
            key, values = line.split(":")
            equations[int(key)] = list(map(int, values.split()))
            
            
            
    ending = 0
    totals = []
    for answer in equations:
        if one_helper(answer, equations[answer]):
            totals.append(answer)
            ending += answer
            
    print(sum(totals))
    
    
            
            

            

def part_two():
    ending = 0
    with open("day3.txt") as f:
        while line := f.readline().strip():  
            
            return
            
part_one()
part_two()






