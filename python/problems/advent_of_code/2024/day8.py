import itertools


def part_one():
    ending = 0
                    
    # reading inputs
    grid = [list(row) for row in open("day8.txt").read().strip().split("\n")]
    char_locs = {}
    for i, row in enumerate(grid):
        for j, col in enumerate(row):
            if col == '.':
                continue

            if col not in char_locs:
                char_locs[col] = [(i, j)]
            else:
                char_locs[col].append((i, j))
                
                
    for char in char_locs:
        combos = [list(combo) for combo in list(itertools.combinations(char_locs[char], 2))]
        
        for combo in combos:
            diff = tuple(a - b for a, b in zip(combo[1], combo[0]))
            topLeft = tuple(a - b for a, b in zip(combo[0], diff))
            botRigt = tuple(a + b for a, b in zip(combo[1], diff))
            
            if 0 <= topLeft[0] < len(grid) and 0 <= topLeft[1] < len(grid[0]) \
                and grid[topLeft[0]][topLeft[1]] != "#":
                grid[topLeft[0]][topLeft[1]] = "#"
                ending += 1
                
            if 0 <= botRigt[0] < len(grid) and 0 <= botRigt[1] < len(grid[0]) \
                and grid[botRigt[0]][botRigt[1]] != "#":
                grid[botRigt[0]][botRigt[1]] = "#"
                ending += 1
        
    print(ending)
       
def part_two():
    ending = 0
    
        
    # reading inputs
    grid = [list(row) for row in open("day8.txt").read().strip().split("\n")]
    char_locs = {}
    for i, row in enumerate(grid):
        for j, col in enumerate(row):
            if col == '.':
                continue

            if col not in char_locs:
                char_locs[col] = [(i, j)]
            else:
                char_locs[col].append((i, j))
                
                
                
    for char in char_locs:
        combos = [list(combo) for combo in list(itertools.combinations(char_locs[char], 2))]
        
        
        for combo in combos:
            diff = tuple(a - b for a, b in zip(combo[1], combo[0]))
            topLeft = tuple(a - b for a, b in zip(combo[0], diff))
            botRigt = tuple(a + b for a, b in zip(combo[1], diff))
            
            while (0 <= topLeft[0] < len(grid) and 0 <= topLeft[1] < len(grid[0])) or \
                    (0 <= botRigt[0] < len(grid) and 0 <= botRigt[1] < len(grid[0])):
                
                if 0 <= topLeft[0] < len(grid) and 0 <= topLeft[1] < len(grid[0]) \
                    and grid[topLeft[0]][topLeft[1]] != "#":
                    grid[topLeft[0]][topLeft[1]] = "#"
                    ending += 1
                    
                if 0 <= botRigt[0] < len(grid) and 0 <= botRigt[1] < len(grid[0]) \
                    and grid[botRigt[0]][botRigt[1]] != "#":
                    grid[botRigt[0]][botRigt[1]] = "#"
                    ending += 1
                    
                    
                topLeft = tuple(a - b for a, b in zip(topLeft, diff))
                botRigt = tuple(a + b for a, b in zip(botRigt, diff))
                
            
    for i in grid:
        for j in i:
            if j != "." and j != "#":
                ending += 1
        
        
    print(ending)
     
part_one()
part_two()