def helper(answer, nums, operations):
    if len(nums) == 1:
        return int(answer) == nums[0]
    
    a, b, *rest = nums
    for op in operations:
        if helper(answer, [op(a, b)] + rest, operations):
            return answer
    return 0
    
equations = [list(map(int, line.replace(':', '').split())) for line in open('day7.txt')]

one_ending, two_ending = 0, 0
operations = [
    lambda a, b: a + b,
    lambda a, b: a * b,
    lambda a, b: int(f"{a}{b}")
]

for answer in equations:
    one_ending += helper(answer[0], answer[1:], operations[:2])
    two_ending += helper(answer[0], answer[1:], operations)

print(one_ending)
print(two_ending)