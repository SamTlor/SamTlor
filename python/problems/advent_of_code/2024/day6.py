def find_carrot(floorplan):
    for height, row in enumerate(floorplan):
        for width, cell in enumerate(row):
            if cell == "^":
                return (height, width)
    return None
        
def part_one():
    
    with open("day6.txt") as f:
        floorplan = [list(line.strip()) for line in f if line.strip()]
    height, width = find_carrot(floorplan)
    
    
    
    def go(floorplan, height, width, changeHeight, changeWidth):
        while 0 <= height + changeHeight < len(floorplan) and 0 <= width + changeWidth < len(floorplan[0]):
            next_height = height + changeHeight
            next_width = width + changeWidth

            if floorplan[next_height][next_width] == "#":
                return floorplan, height, width, False

            floorplan[height][width] = "X"
            height, width = next_height, next_width

        floorplan[height][width] = "X"
        return floorplan, height, width, True

    
    
    direction = [(-1,0), (0,1), (1,0), (0,-1)]
    choose_dir = 0
    done = False
    while not done:
        dh, dw = direction[choose_dir % len(direction)]
        floorplan, height, width, done = go(floorplan, height, width, dh, dw)
        choose_dir += 1
    
    print(sum(row.count("X") for row in floorplan))

def part_two():
    with open("day6.txt") as f:
        floorplan = [list(line.strip()) for line in f if line.strip()]

    height, width = find_carrot(floorplan)
    
    
    # TODO: something about the path from two #'s ago 
    # like if it's the same row or column as the one from two #'s ago put an O there idk
    # new if statement new return
    direction = [(-1,0), (0,1), (1,0), (0,-1)]
    def go_two(floorplan, height, width, choose_dir, path):
        changeHeight, changeWidth = direction[choose_dir % len(direction)]
        
        while 0 <= height + changeHeight < len(floorplan) and 0 <= width + changeWidth < len(floorplan[0]):
            next_height = height + changeHeight
            next_width = width + changeWidth

            if floorplan[next_height][next_width] == "#":
                path.append((next_height, next_width))
                if len(path) > 3:
                    path.pop(0)
                return floorplan, height, width, False, path, False

            testChangeHeight, testChangeWidth = direction[(choose_dir + 1) % len(direction)]
            
            testHeight, testWidth = height + testChangeHeight, width + testChangeWidth
            if floorplan[testHeight][testWidth] == path[0]:
                return floorplan, height, width, False, path, True
            floorplan[height][width] = "X"
            height, width = next_height, next_width

        floorplan[height][width] = "X"
        return floorplan, height, width, True, path, False

    
    
    choose_dir = 0
    done = False
    path = []
    ending = 0
    while not done:
        floorplan, height, width, done, path, loop = go_two(floorplan, height, width, choose_dir, path)
        if loop:
            ending += 1
        choose_dir += 1
        loop = False
    



part_one()
part_two()