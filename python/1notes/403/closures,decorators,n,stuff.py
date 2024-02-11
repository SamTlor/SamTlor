"""
CLOSURES
putting a a value in a nested function
to avoid the use of global functions
   provide some form of data hiding
   provide an object oriented solution to a problem

when the number of attributes and methods get larger 
it's better to use a class instead
"""


def print_msg(msg):
    def printer():
        print(msg)
    return printer

another = print_msg("Hello")




"""
DECORATORS
takes a function adds some functionality and returns it likea closure
"""

def make_pretty(func):
    def inner():
        print("I got decorated")
        func()
    return inner

def ordinary():
    print("I am ordinary")
    
ordinary()                                  # Prints “I am ordinary”    normal function call
pretty = make_pretty(ordinary)              # Prints “I got decorated”  changed function call
pretty()                                    # Prints “I am ordinary”    normal function call again if you still want it

"""
use the @ symbol to make it do both
"""

def make_pretty_different(func):
    def inner():
        print("I got decorated")
        func()
    return inner
@make_pretty_different
def ordinary_different():
   print("I am ordinary")
ordinary_different()                        #now runs both functions. make_pretty goes first tho




"""
LIST COMPREHENSIONS
result, transformation, collection, conditional

"""
def transformation(n):
    return n * 2
result = [transformation(n) for n in [1,2,3,4,5,6,7,8,9] if n % 2 == 1]
# ^ result  ^ transformation  ^ collection                ^ conditional
print(result)





"""
four ways software components can be modified for reuse
    1. extension of the data or operations
            get a var from another class or whatever
    2. redefinition of one or more of the operations
            redef a function
    3. Abstraction
            call another function from within one of your functions
    4. polymorphism
            use a function from another class or whatever for your class or whatever
            
            
coupling: how related or dependent two classes are toward each other
cohesion: what the class can do

Three principles of Object Oriented Programming and be able to describe them
    encapsulation: public, _protected, __private
    inheritence: subClass(parent_Class)
    polymorphism: same function different does
"""