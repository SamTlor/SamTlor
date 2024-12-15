num_lookup = {0: 1}

def helper(nums, iteration):
    if iteration < 25:
        new_nums = []
        
        for num in nums:
            num_len = len(str(num))
            
            if num == 0:
                new_nums.append(1)
            elif num_len % 2 == 0:
                new_nums.append(num // (10 ** (num_len // 2)))
                new_nums.append(num % (10 ** (num_len // 2)))
            else:
                new_nums.append(num * 2024)
        return helper(new_nums, iteration + 1)
        
        
        
    else:
        return len(nums)

def part_one():
    nums = [int(num) for line in open("day11.txt") for num in line.split()]
    print(helper(nums, 0))


def helper_two(nums, iteration):
    if iteration < 50:
        new_nums = []
        
        for num in nums:
            if num in num_lookup:
                new_nums += num_lookup[num]
                
            else:
                num_lookup[num] = 
        return helper_two(new_nums, iteration + 1)
    
def part_two():
    nums = [int(num) for line in open("day11.txt") for num in line.split()]
    print(helper_two(nums, 0))

part_one()
part_two()