"""

polymorphism: what an object does in response to a method call depends on the type or class of the object
              each object performs an action just the way that it should be performed for that object

"""



class Employee:
    def __init__(self, rate):
        self.rate = rate
    def printSalaryPerMonth(self):
        print(str(self.rate))
        
class HourlyEmployee(Employee):
    def __init__(self, rate):
        super().__init__(rate)
    def printSalaryPerMonth(self):
        print(str(self.rate * 40 * 4))
        
class SalariedEmployee(Employee):
    def __init__(self, rate):
        super().__init__(rate)
    def printSalaryPerMonth(self):
        print(str(self.rate / 12))
        
def printWage(emp):
    emp.printSalaryPerMonth()                               #THIS IS THE POLYMORPHISM HERE
    
    
f = HourlyEmployee(10)
g = SalariedEmployee(50000)

#same function but different values
f.printSalaryPerMonth()
g.printSalaryPerMonth()
printWage(f)
printWage(g)


"""
Dynamic binding goes with dynamic typing
method implementation is looked up at runtime

printSalaryPerMonth() from the above code can be applied to both objects
so it works both times

python doesn't care that the objects are different 
but if it wasn't defined in both objects it wouldn't work for both



classes can have variations of other functions
like an override sorta
"""

class Day:
    def __init__(self, visits, contacts):
        self.visits = visits
        self.contacts = contacts
    def __str__(self):
        return "Visits: %i, Contacts: %i" % (self.visits, self.contacts)
    def __add__(self, other):
        total_visits = self.visits + other.visits
        total_contacts = self.contacts + other.contacts
        return Day(total_visits, total_contacts)
day1 = Day(10,1)
day2 = Day(20, 2)
day3 = day1 + day2
print(day3)