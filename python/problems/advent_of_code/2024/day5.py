with open("day5.txt") as f:
    input_text = f.read()
    
sections = input_text.strip().split("\n\n")
rules = [
    tuple(map(int, line.strip().split("|")))
    for line in sections[0].strip().splitlines()
] 
updat = [
    list(map(int, line.strip().split(",")))
    for line in sections[1].strip().splitlines()  
]  


# checks if each element comes before the following elements
def in_order(nums:list) -> bool:
    combos = []
    for i in range(0, len(nums) - 1):
        for j in range(i + 1, len(nums)):
            if (nums[i], nums[j]) not in rules:
                combos.append(False)
    if len(combos) == 0:
        return True
    
    
    
def custom_quicksort(nums):
    if len(nums) <= 1:
        return nums
    else:
        pivot = nums[len(nums) // 2]
        
        left = [x for x in nums if (x, pivot) in rules]
        right = [x for x in nums if (pivot, x) in rules]
        return custom_quicksort(left) + [pivot] + custom_quicksort(right)
    


part_one = 0
part_two = 0
for nums in updat:
    if in_order(nums):
        part_one += nums[len(nums) // 2]
    else:
        part_two += custom_quicksort(nums)[len(nums) // 2]

                        
print(part_one)
print(part_two)