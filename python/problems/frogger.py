#counts the differences in DNA
#idk why i called it frogger.py i'm a terrible programmer lol

first = "GAGCCTACTAACGGGAT"
second = "CATCGTAATGACGGCCT"

count = 0 


if len(first) == len(second):
    for i,j in zip(first, second):
        if i != j:
            count += 1

print(count)