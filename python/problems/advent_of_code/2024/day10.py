def dfs(grid, height, width, visited, allPaths, thisPath, one = True):
    if one and (height,width) in visited:
        return 
    
    # Add to the visited set
    visited.add((height, width))
    thisPath.append((height, width))

    # If we reach a '9', save the path and return
    if grid[height][width] == 9:
        allPaths.append(list(thisPath))
    else:
        for changeH, changeW in [(-1, 0), (1, 0), (0, -1), (0, 1)]:
            newH, newW = height + changeH, width + changeW
            if (0 <= newH < len(grid) and 0 <= newW < len(grid[0]) and 
                grid[newH][newW] == grid[height][width] + 1):
                
                if one:
                    if (newH, newW) not in visited:
                        dfs(grid, newH, newW, visited, allPaths, thisPath, one=True)
                else:
                    dfs(grid, newH, newW, visited, allPaths, thisPath, one=False)
                    
        visited.remove((height, width))

    # Backtrack
    thisPath.pop()



# Reading inputs
grid = [[int(char) if char.isdigit() else '.' for char in line] 
         for line in open("day10.txt").read().strip().split("\n")]
starting_points = [(i, j) for i in range(len(grid)) 
                   for j in range(len(grid[0])) if grid[i][j] == 0]

all_paths_one, all_paths_two = [], []
for x, y in starting_points:
    dfs(grid, x, y, set(), all_paths_one, [], one=True)
    dfs(grid, x, y, set(), all_paths_two, [], one=False)
    
print(len(all_paths_one))
print(len(all_paths_two))