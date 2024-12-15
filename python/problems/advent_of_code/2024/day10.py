def dfs(grid, height, width, visited, allPaths, thisPath, one = True):
    # # Bounds check and visit check
    if not (0 <= height < len(grid) and 0 <= width < len(grid[0])):
        return
    if one and (height,width) in visited:
        return 
    
    
    
    # Add to the visited set
    visited.add((height, width))
    thisPath.append((height, width))

    # If we reach a '9', save the path and return
    if grid[height][width] == 9:
        allPaths.append(list(thisPath))
    else:
        # Explore neighbors: up, down, left, right
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
with open("day10.txt") as f:
    lines = f.read().strip().split("\n")

grid = []
for line in lines:
    grid.append([int(char) if char.isdigit() else '.' for char in line])
starting_points = [(i, j) for i in range(len(grid)) for j in range(len(grid[0])) if grid[i][j] == 0]



def part_one():
    # Store all paths
    all_paths = []
    for x, y in starting_points:
        dfs(grid, x, y, set(), all_paths, [], one=True)
        
    print(len(all_paths))

def part_two():
    # Store all paths
    all_paths = []
    for x, y in starting_points:
        dfs(grid, x, y, set(), all_paths, [], one=False)
        
    print(len(all_paths))


part_one()
part_two()