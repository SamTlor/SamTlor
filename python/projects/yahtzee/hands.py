import dice

class Hand(list):
    def __init__(self, size, die_class):
        self.size = size
        self.die_class = die_class()

    def roll(self):
        for _ in range(self.size):
            value = self.die_class.throw()
            self.append(value)                              #extends list so the object itself is a list that can be appended to


class Yahtzee(Hand):
    def __init__(self, keep=[], size=5):
        super().__init__(size = size, die_class=dice.D6)
        self.keep = keep
        self.hand = self.roll()

    #python doesn't have switch case statements
    #this returns the NAME of the COMBO the player wants to use and the SCORE that they earned, as a dictionary
    def method(self, combo):
        if combo == "ones" : return self.keep.count(1)
        if combo == "twos" : return self.keep.count(2) * 2
        if combo == "threes" : return self.keep.count(3) * 3
        if combo == "fours" : return self.keep.count(4) * 4
        if combo == "fives" : return self.keep.count(5) * 5
        if combo == "sixes" : return self.keep.count(6) * 6
        if combo == "three of a kind":
            for n in self.keep:
                if self.keep.count(n) >= 3:
                    return sum(self.keep)
            print(f"not {combo}")
            raise Exception()
        if combo == "four of a kind":
            for n in self.keep:
                if self.keep.count(n) >= 4:
                    return sum(self.keep)
            print(f"not {combo}")
            raise Exception()
        if combo == "full house":
            for n in range(1,7):
                if (self.keep.count(n) == 3 and self.keep[3] == self.keep[4]) or (self.keep[0] == self.keep[1] and self.keep.count(n) == 3):
                    return 25
            print(f"{combo} doesn't fit")
            raise Exception()
        if combo == "small straight":
            for a in range(len(self.keep)-1):
                double = self.keep[a]
                if self.keep.count(double) == 2:
                    self.keep.remove(double)
                    self.keep.append(double)
            for g in range(2):
                for h in range(3):
                    var = [(i + h) for i in range(1,len(self.keep))]
                    if self.keep[g:4+g] == var:
                        return 30
            print(f"{combo} doesn't fit")
            raise Exception()
        if combo == "large straight":
            for g in range(2):
                for h in range(3):
                    var = [(i + h) for i in range(1,len(self.keep))]
                    if self.keep[g:5+g] == var:
                        return 40
            print(f"{combo} doesn't fit")
            raise Exception()
        if combo == "chance":
            return sum(self.keep)
        if combo == "yahtzee":
            for n in self.keep:
                if self.keep.count(n) == 5:
                    return 50
            print(f"not {combo}")
            raise Exception()