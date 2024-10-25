"""
def solution(nums, target):
    for i in nums:
        index = nums.index(i)    
        nums.remove(i)


        for j in nums:
            if j + i == target:
                return f"[{index},{nums.index(j) + 1}] \n{i} + {j} = {target}"
        nums.insert(index, i)
    
    return "There is no solution"

print(solution(nums, target))
"""



nums = [2,7,11,15]
target = 13

def new_solution(nums, target):
    for i in nums:
        index = nums.index(i) + 1
        for j in nums[index:]:
            if i + j == target:
                return f"[{nums.index(i)},{nums.index(j)}] \n{i} + {j} = {target}"
    return "There is no solution"

print(new_solution(nums, target))