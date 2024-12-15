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
        for dx, dy in [(-1, 0), (1, 0), (0, -1), (0, 1)]:
            nx, ny = height + dx, width + dy
            if (0 <= nx < len(grid) and 0 <= ny < len(grid[0]) and 
                grid[nx][ny] == grid[height][width] + 1):
                
                if one:
                    if (nx, ny) not in visited:
                        dfs(grid, nx, ny, visited, allPaths, thisPath, one=True)
                else:
                    dfs(grid, nx, ny, visited, allPaths, thisPath, one=False)
                    
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