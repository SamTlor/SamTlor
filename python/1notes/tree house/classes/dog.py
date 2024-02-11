class Dog:    
    def __init__(self, name, age):                  #constructor
        self.name = name                            #instance variables
        self.age = age
        self.voice = "bark"                         #default value. You don't need another constructor

    def sit(self):
        print(f"{self.name} is now sitting.")
    def roll_over(self):
        print(f"{self.name} rolled over.")


my_dog = Dog("willie", 6)                           #creating dog objects
your_dog = Dog("jessie", 2)

your_dog.voice = "Woof"                             #modifying default values. or any type of values


var = [my_dog, your_dog]
for i in var:
    print("name: " + i.name)
    print(i.name + " says " + i.voice)
    i.sit()
    i.roll_over()
    print("\n")