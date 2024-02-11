"""

class:          normal class
subclass:       has parent class in the () next to the name of the class
                super().__init__ inside its constructor
                
a class can inherit from more than one superclass
each one should be subclass is a ____ of the superclass
"circle is a shape"


### if the subclass doesn't use all or most of the methods and data from the super class then it shouldn't be 
### in an inheritence relationship

"""

class Employee:
    def __init__(self, homeAddress):
        self.homeAddress = homeAddress
    def printAddress(self):
        print(self.homeAddress)
        
class HourlyEmployee(Employee):                         #has the parent class
    def __init__(self, homeAddress, rate):
        super().__init__(homeAddress)                   #super().__init__
        self.rate = rate
    def printSalaryPerMonth(self):
        print("$", str(self.rate * 40 * 4))
        
        
        
        
        
class A:
    x = 'a'
    
class B(A):                     #inherits from A
    pass

class C(A):                     #inherits from A and overides the value of x
    x = 'c'
    
class D(B, C):                  #inherits from B and C
    pass

print(D.x)                      #prints 'c' because B just passes and doesn't do anything with A
                                #C however changes the value of x 
                                #so when D.x is called D inherits the value of x from C which is 'c'



"""
DEADLY DIAMOND OF DEATH
when class B and class C both inhert from class A
and class D inherits from both B and C


class A:
    def __init__(self):
        self.x = 'a'
        print("A", self.x)
class B(A):
    def __init__(self):
        super().__init__()
        print("B", self.x)
class C(A):
    def __init__(self):
        super().__init__()
        self.x = 'c'
        print("C", self.x)
class D(B, C):
    def __init__(self):
        super().__init__()
        print("D", self.x)
D()


This is an example
it prints out 
A a
C c
B c
D c

which is weird af if you look at it
cuz you would think it would be B a then Cc but whatever DDD
"""
