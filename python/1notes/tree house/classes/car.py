class Car:
    def __init__(self, make, model, year):
        self.make = make
        self.model = model
        self.year = year
        self.odometer_reading = 0
    def get_descriptive_name(self):
        return f"{self.year} {self.make} {self.model}"
    def read_odometer(self):
        return f"This car has {self.odometer_reading} miles on it."
    def update_odometer(self, mileage):
        if mileage >= self.odometer_reading:
            self.odometer_reading = mileage
        else:
            print("You can't roll back an odometer!")
    def increment_odometer(self, miles):
        self.odometer_reading += miles                                      #increment variable from a function

class ElectricCar(Car):                                                     #child class of Car
    def __init__(self, make, model, year):
        super().__init__(make, model, year)
        self.battery = Battery(1)                                           #variable is an object

class Battery:
    def __init__(self, battery_size = 75):                                  #default is 75 but is changed from the ElectricCar class
        self.battery_size = battery_size
    def describe_battery(self):
        return f"This car has a {self.battery_size}-kWh battery."




my_tesla = ElectricCar("tesla", "model s", 2019)

print(my_tesla.get_descriptive_name())
print(my_tesla.read_odometer())
my_tesla.increment_odometer(4)
print(my_tesla.read_odometer())


print(my_tesla.battery.describe_battery())                                  #needs to call the battery object of the my_tesla 
                                                                            #in order to call the function