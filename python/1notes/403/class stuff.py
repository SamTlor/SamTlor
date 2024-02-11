"""

instance variables should always be set in the constructor

"""
class Customer:
    def __init__(self, name):               #the constructor
        self.name = name
        
    def set_balance(self, balance = 0.0):
        self.balance = balance
    
    def get_balance(self):                  #if this is called before set_balance it will crash
        print(self.balance)




"""

__str__ can be used to return a string if the class itself is ever called

"""
class See:
    def __str__(self):
        return "this will be printed out"
    
print(See())



"""

for collections that are mutable a copy is needed so that you can change one copy while keeping the other
do this with the copy module

copy.copy(x)            shallow copy    new object with references to the other lists inside it
copy.deepcopy(x)        deep copy       new object with recursive coppies of the other lists inside it

the difference between ^^ is only relevant for lists that have other lists

"""

import copy
class City:
    def __init__ (self, name):
        self.name = name
class University:
    def __init__(self, name, city):
        self.name = name
        self.city = city
        
rva = City("Richmond")
vcu = University("VCU", rva)

print(id(vcu), id(vcu.name), id(vcu.city), id(vcu.city.name))   #bunch of ids
var = vcu                                                       #if printed would be the SAME bunch of ids^^
var = copy.copy(vcu)                                            #if printed id(var) would be different
var = copy.deepcopy(vcu)#id(var) would be different from id(var) from ^^ but id(var.city) would be id(var) from ^^







listA = ["john", "jane"]
tupleB = (listA, 1, "two")
print(listA)
print(tupleB)


b = copy.copy(tupleB)
c = copy.deepcopy(tupleB)

listA[0] = "james"
print(listA)                #because listA has been modified
print(b)                    #also different now because listA has been modified
print(c)                    #hasn't been changed because it copied the value when it was made





"""

class variables are variables described inside a class

var.animal_type = "whatever" will change the animal_type for var
Shark.animal_type = "whatever" will change the animal_type for all sharks
"""

class Shark:
    animal_type = "fish"
    def __init__(self, name):
        self.name = name
        
d = Shark("bite")
e = Shark("tooth")

Shark.animal_type = "dog"               #affects all previous elements
e.animal_type = "cat"
print(d.name, " is ", d.animal_type)
print(e.name, " is ", e.animal_type)


"""

x = public
_x = protected
__x =   private

if you need private, protected, and public you shouldn't be using python

"""