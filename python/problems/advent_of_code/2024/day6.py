#               up    right   down   left
directions = [(-1,0), (0,1), (1,0), (0,-1)]

def find_carrot(floorplan):
    for height, row in enumerate(floorplan):
        for width, cell in enumerate(row):
            if cell == "^":
                return (height, width)

class Node:
    def __init__(self, height, width, direction):
        self.height = height
        self.width = width
        self.direction = direction
        
        self.prev = None
        self.next = None

class LinkedList:
    def __init__(self):
        self.head = None
        self.tail = None
        self.xCount = 0

    def append(self, height, width, direction):
        new_node = Node(height, width, direction)
        if not self.find(height, width):
            self.xCount += 1
            
        if not self.head:
            self.head = self.tail = new_node
        else:
            new_node.prev = self.tail
            self.tail.next = new_node
            self.tail = new_node
            
    def find(self, height, width, direction = None):
        current = self.tail
        while current:
            if (current.height == height and 
                current.width == width and 
                (direction is None or current.direction == direction)):
                return True
            current = current.prev
        return None
         
    def go(self, floorplan, height, width, choose_dir):
        changeH, changeW = directions[choose_dir % len(directions)]
        
        while 0 <= height + changeH < len(floorplan) and 0 <= width + changeW < len(floorplan[0]):
            next_height = height + changeH
            next_width = width + changeW

            # if the guard hits an object
            if floorplan[next_height][next_width] == "#":
                return height, width, False

            self.append(height, width, choose_dir)
            height, width = next_height, next_width

        self.append(height, width, choose_dir)
        return height, width, True
        
def part_one():
    floorplan = open("day6.txt").read().strip().split("\n")
    guardPath = LinkedList()
    carrotHeight, carrotWidth = find_carrot(floorplan)
  
    choose_dir = 0
    done = False
    while not done:
        carrotHeight, carrotWidth, done = guardPath.go(floorplan, carrotHeight, carrotWidth, choose_dir)
        choose_dir = (choose_dir + 1) % len(directions)
    
    print(guardPath.xCount)
    return guardPath
            
# working version
def part_two():
    ending = 0
    floorplan = open("day6.txt").read().strip().split("\n")
    startHeight, startWidth = find_carrot(floorplan)
    
    # guardLoc = part_one().head
    # while guardLoc.next:
    
    for row in range(len(floorplan)):
        for col in range(len(floorplan[0])):
            height, width = startHeight, startWidth
            direction = 0
            
            seen = set()
            while True:
                # if it is somewhere that it has been before going in the same direction
                if (height, width, direction) in seen:
                    ending += 1
                    break
                    
                seen.add((height, width, direction))
                nextHeight, nextWidth = height + directions[direction][0], width + directions[direction][1]
                
                # if it leaves the map
                if not (0 <= nextHeight < len(floorplan) and 0 <= nextWidth < len(floorplan[0])):
                    break
                
                # if it hits and object
                # first for real one second for hypothetical one
                if (floorplan[nextHeight][nextWidth] == "#" or 
                # (nextHeight == guardLoc.next.height and nextWidth == guardLoc.next.width)):
                (nextHeight == row and nextWidth == col)):
                        direction = (direction + 1) % 4
                else:
                    height, width = nextHeight, nextWidth
            # guardLoc = guardLoc.next
                
    print(ending)

part_two()