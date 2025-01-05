from collections import deque

#               up    right   down   left
directions = [(-1,0), (0,1), (1,0), (0,-1)]

# Reading inputs
grid = [[char for char in line] 
         for line in open("day12.txt").read().strip().split("\n")]

maxHeight, maxWidth = len(grid), len(grid[0])
visited = set()
perimeters = {}

def isValid(height, width):
    return 0 <= height < maxHeight and 0 <= width < maxWidth

def bfs(height, width, value):
    queue = deque([(height, width)])
    visited.add((height, width))
    perimeter, area = 0, 0
    
    while queue:
        thisH, thisW = queue.popleft()
        area += 1
        
        for changeH, changeW in directions:
            newH, newW = thisH + changeH, thisW + changeW
            
            if not isValid(newH, newW) or grid[newH][newW] != value:
                perimeter += 1
            elif (newH, newW) not in visited:
                visited.add((newH, newW))
                queue.append((newH, newW))
                
    return perimeter, area
    
def part_one():
    for i in range(maxHeight):
        for j in range(maxWidth):
            if (i, j) not in visited:
                value = grid[i][j]
                group_perim, group_area = bfs(i, j, value)
                perimeters[value] = perimeters.get(value, 0) + group_perim * group_area
                
                
                
    ending = 0
    for i in perimeters:
        ending += perimeters[i]
        
    print(ending)



sides = {}
sides_visited = set()
def bfs_two(height, width, value):
    queue = deque([(height, width)])
    sides_visited.add((height, width))
    side_count, area = 0, 0
    
    while queue:
        thisH, thisW = queue.popleft()
        area += 1
        
        for changeH, changeW in directions:
            newH, newW = thisH + changeH, thisW + changeW
            
            if not isValid(newH, newW) or grid[newH][newW] != value:
                side_count += 1
            elif (newH, newW) not in sides_visited:
                sides_visited.add((newH, newW))
                queue.append((newH, newW))
    return side_count, area

    
    
    
    
    
    
    
    
          
part_one()