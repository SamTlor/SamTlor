num_count = {}

def add_count(val, count):
    if val in num_count:
        num_count[val] += count
    else:
        num_count[val] = count

def recursive_helper(num_count, iteration = 75):
    # Base case: stop recursion
    if iteration == 0:
        return sum(num_count.values())

    # Temporary dictionary to store changes
    temp_count = {}

    for stone, count in num_count.items():
        if count == 0:
            continue

        num_len = len(str(stone))

        # 0 -> 1
        if stone == 0:
            temp_count[1] = temp_count.get(1, 0) + count

        # Even number -> split number
        elif num_len % 2 == 0:
            left = stone // (10 ** (num_len // 2))
            right = stone % (10 ** (num_len // 2))
            
            temp_count[left] = temp_count.get(left, 0) + count
            temp_count[right] = temp_count.get(right, 0) + count

        # Else -> multiply by 2024
        else:
            multiplied = stone * 2024
            temp_count[multiplied] = temp_count.get(multiplied, 0) + count

    # Recursive call with updated counts and decremented iteration
    return recursive_helper(temp_count, iteration - 1)

# Initialize num_count
nums = [int(num) for line in open("day11.txt") for num in line.split()]
for i in nums:
    add_count(i, 1)

# Call the recursive helper
print(recursive_helper(num_count))