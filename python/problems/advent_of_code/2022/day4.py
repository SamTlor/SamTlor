count = 0
        
with open("C:/Users/samtl/OneDrive/Documents/zome_files/rust/advent_of_code/2022/day4/src/text.txt") as f:
    while line := f.readline().strip():
        elf1, elf2 = line.split(",")
        
        elf1_min, elf1_max = map(int, elf1.split("-"))
        elf2_min, elf2_max = map(int, elf2.split("-"))
        
        
        
        minmin = min(elf1_min, elf2_min)
        maxmax = max(elf1_max, elf2_max)
        
        
        comparor = (minmin, maxmax)
        if comparor == (elf1_min, elf1_max) or comparor == (elf2_min, elf2_max):
            print(elf1_min, elf2_min)
            print(elf1_max, elf2_max)

            print(comparor, (elf1_min, elf1_max), (elf2_min, elf2_max))
            print()
            count += 1
            
            
print(count)












count = 0
        
with open("C:/Users/samtl/OneDrive/Documents/zome_files/rust/advent_of_code/2022/day4/src/text.txt") as f:
    while line := f.readline().strip():
        elf1, elf2 = line.split(",")
        
        elf1_min, elf1_max = map(int, elf1.split("-"))
        elf2_min, elf2_max = map(int, elf2.split("-"))
        
        
        
        if elf1_min <= elf2_min <= elf1_max or elf2_min <= elf1_min <= elf2_max:
            
            print(elf1_max, elf2_min)
            print(elf2_max, elf1_min)
            print()
            count += 1
        
            
print(count)