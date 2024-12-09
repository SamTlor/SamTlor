def part_one():    
    ending = 0

    page = []
    with open("day4.txt") as f:
        while line := f.readline().strip():
            page.append(str(line))
            
            
        
    rows, cols = len(page), len(page[0])
    word = "XMAS"
    word_len = len(word)

    # Function to check word in a specific direction
    def search_direction(r, c, dr, dc):
        for i in range(word_len):
            new_row = r + i * dr
            new_col = c + i * dc
            if not (0 <= new_row < rows and 0 <= new_col < cols) or page[new_row][new_col] != word[i]:
                return False
        return True

    # Iterate over each cell in the grid
    for r in range(rows):
        for c in range(cols):
            # Check in all 8 possible directions
            for dr, dc in [(-1, -1), (-1, 0), (-1, 1), (0, -1), (0, 1), (1, -1), (1, 0), (1, 1)]:
                if search_direction(r, c, dr, dc):
                    ending += 1
    print(ending)



def part_two():    
    ending = 0

    page = []
    with open("day4.txt") as f:
        while line := f.readline().strip():
            page.append(str(line))
        
        
    
    rows, cols = len(page), len(page[0])
    word = "MAS"
    word_len = len(word)

    # Function to check word in a specific direction
    def search_direction(r, c):

        if r - 1 < 0 or r + 1 >= rows or c - 1 < 0 or c + 1 >= cols:
            return False
        
        patterns = {"MAS", "SAM"}
        l_diag = ''.join([page[r - 1][c - 1], page[r][c], page[r + 1][c + 1]])
        r_diag = ''.join([page[r - 1][c + 1], page[r][c], page[r + 1][c - 1]])
        
        if l_diag in patterns and r_diag in patterns:
            return True
        return False
            
            
    # Iterate over each cell in the grid
    for r in range(rows):
        for c in range(cols):
            if page[r][c] == "A":
                if search_direction(r, c):
                    ending += 1
                    break
    print(ending)



part_one()
part_two()
