import json, difflib
from difflib import SequenceMatcher, get_close_matches

data = json.load(open("c:/Users/samtl/Documents/school/2020/udemy/top ten records/data.json"))

def define(var):
    test = var.lower(), var.upper(), var.title()
    for h in test:
        if h in data:
            return data[h]
        
    close = get_close_matches(var, data.keys())
    if len(close) > 0:
        for i in close:
            if input(f"Did you mean to type '{i}'?").upper() == "Y":
                return data[i]
    return "That word doesn't exist in this dictionary. Please double check if that is a real word."

foo = define(input("What word do you want to define?"))

if type(foo) == list:
    for j in foo:
        print(j)
else:
    print(foo)