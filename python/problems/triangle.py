import math

class Triangle:
    def __init__(self, aIn, bIn, cIn):

        if (aIn <= 0 or bIn <= 0 or cIn <= 0):
            raise Exception("Cannot form this triangle because the sides are negative.")
        if ((aIn >= bIn + cIn) or (bIn >= aIn + cIn) or (cIn >= aIn + bIn)):
            raise Exception("Cannot form this triangle because the sides would not connect")

        self.sideA = aIn
        self.sideB = bIn
        self.sideC = cIn

    def classify(self):
        if self.sideA == self.sideB == self.sideC:
            return "equilateral"
        elif self.sideA == self.sideB or self.sideA == self.sideC or self.sideB == self.sideC:
            return "isosceles"
        else:
            return "scalene"


if __name__ == '__main__':
    eq_test = Triangle(3,3, 3)
    is_test = Triangle(3,3,math.sqrt(18))
    sc_test = Triangle(3,4,5)

    print(eq_test.classify())
    print(is_test.classify())
    print(sc_test.classify())