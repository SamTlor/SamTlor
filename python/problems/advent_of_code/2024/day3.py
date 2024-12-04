import re

def part_one():
    ending = 0
    with open("day3.txt") as f:
        while line := f.readline().strip():

            # Regular expression pattern
            pattern = r"mul\((\d{1,3}),(\d{1,3})\)"

            # Find all matches
            matches = re.findall(pattern, line)

            
            for match in matches:
                x, y = match
                ending += int(x) * int(y)
                
        print(ending)
            
            
def part_two():
    ending = 0
    with open("day3.txt") as f:
        while line := f.readline().strip():
            search_active = True
            
            # Regular expression patterns
            muls_pattern = r"mul\((\d{1,3}),(\d{1,3})\)"
            dont_pattern = r"don't\(\)"
            strt_pattern = r"do\(\)"
            
            splits = re.split(r"(don't\(\)|do\(\))", line)
            
            for split in splits:
                if re.match(dont_pattern, split):  # Check for "don't()"
                    search_active = False
                elif re.match(strt_pattern, split):  # Check for "do()"
                    search_active = True
                    
                    
                    
                elif search_active:  # Only look for mul() if search is active
                    matches = re.findall(muls_pattern, split)
                    for match in matches:
                        x, y = match
                        ending += int(x) * int(y)
                        
        print(ending)

part_one()
part_two()