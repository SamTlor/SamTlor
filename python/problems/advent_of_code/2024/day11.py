thing = 123956
print(thing // 1000)
print(thing % 1000)


def helper(nums, iteration):
    new_nums = []
    
    for num in nums:
        if num == 0:
            new_nums.append(1)
        
        num_len = len(str(num))
        if num_len % 2 == 0:
            new_nums.append(num // (10 ** (num_len // 2)))
            new_nums.append(num % (10**(num_len // 2) ))


def part_one():
    