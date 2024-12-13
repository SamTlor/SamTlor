#               up    right   down   left
directions = [(-1,0), (0,1), (1,0), (0,-1)]

def find_carrot(floorplan):
    for height, row in enumerate(floorplan):
        for width, cell in enumerate(row):
            if cell == "^":
                return (height, width)
   
def part_one():
    floorplan = open("day6.txt").read().strip().split("\n")
    height, width = find_carrot(floorplan)
  
    guardPath = set()
    choose_dir = 0
    changeH, changeW = directions[choose_dir]
    while 0 <= height + changeH < len(floorplan) and 0 <= width + changeW < len(floorplan[0]):
        guardPath.add((height, width))
        
        next_height, next_width = height + changeH, width + changeW

        # if the guard hits an object
        if floorplan[next_height][next_width] == "#":
            choose_dir = (choose_dir + 1) % len(directions)
            changeH, changeW = directions[choose_dir]
            continue

        height, width = next_height, next_width

    guardPath.add((height, width))
    print(len(guardPath))
    return guardPath
            
# working version
def part_two():
    ending = 0
    floorplan = open("day6.txt").read().strip().split("\n")
    carrotHeight, carrotWidth = find_carrot(floorplan)
    
    guardPath = part_one()
    for row, col in guardPath:
        
        # reset guard starting position for every run
        height, width = carrotHeight, carrotWidth
        
        # the height, width, and direction of the path the guard will take if an object is placed at row, col
        thisPath = set()
        choose_dir = 0
        
        while True:
            space = (height, width, choose_dir)
            if space in thisPath:
                ending += 1
                break
            thisPath.add(space)
            
            changeH, changeW = directions[choose_dir]
            next_height, next_width = height + changeH, width + changeW
            
            if not (0 <= next_height < len(floorplan) and 0 <= next_width < len(floorplan[0])):
                break
            
            if (floorplan[next_height][next_width] == "#" or (next_height == row and next_width == col)):
                choose_dir = (choose_dir + 1) % len(directions)
            else:
                height, width = next_height, next_width
        
    print(ending)

part_two()