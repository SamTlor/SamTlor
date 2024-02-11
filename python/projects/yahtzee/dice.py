import random

class Die:
    def __init__(self, sides):
        if sides < 2:
            raise ValueError("Can't have fewer than two sides")
        self.sides = sides

    def throw(self):
        return random.randint(1, self.sides)
    
class D6(Die):
    def __init__(self):
        super().__init__(sides = 6)
