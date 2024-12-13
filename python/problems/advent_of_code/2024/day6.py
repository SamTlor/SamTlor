#               up    right   down   left
directions = [(-1,0), (0,1), (1,0), (0,-1)]

def find_carrot(floorplan):
    for height, row in enumerate(floorplan):
        for width, cell in enumerate(row):
            if cell == "^":
                return (height, width)

# see where the guard will go. it turns right if it hits a # or the obstacle if detect_loops is turned on
def DoTheLoopTest(floorplan, start_height, start_width, obstacle = None, detect_loops = False):
    path = set()
    height, width = start_height, start_width
    choose_dir = 0 
    
    while True:
        if detect_loops:
            state = (height, width, choose_dir)
            if state in path:
                return path, True
            path.add(state)
        else:
            path.add((height, width))


        changeH, changeW = directions[choose_dir]
        next_height, next_width = height + changeH, width + changeW
        
        # Check if out of bounds
        if not (0 <= next_height < len(floorplan) and 0 <= next_width < len(floorplan[0])):
            break
        
        # Handle obstacles
        if floorplan[next_height][next_width] == "#" or (next_height, next_width) == obstacle:
            choose_dir = (choose_dir + 1) % len(directions)
        else:
            height, width = next_height, next_width
    
    return path, False
    
# reading inputs
floorplan = open("day6.txt").read().strip().split("\n")
carrotHeight, carrotWidth = find_carrot(floorplan)

# part 1
guardPath, _ = DoTheLoopTest(floorplan, carrotHeight, carrotWidth)
print(len(guardPath))

# part 2
print(sum(1 for space in guardPath \
                    if DoTheLoopTest(floorplan, carrotHeight, carrotWidth, space, detect_loops=True)[1]))