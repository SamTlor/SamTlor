from collections import deque

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
    perimeter = 0
    
    while queue:
        thisH, thisW = queue.popleft()
        
        for changeH, changeW in []
    
    
def part_one():
    for i in range(maxHeight):
        for j in range(maxWidth):
            if (i, j) not in visited:
                value = grid[i][j]
                perimeters[value] = perimeters.get(value, 0) + bfs(i, j, value)
                print(perimeters[value])