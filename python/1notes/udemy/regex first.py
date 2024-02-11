import re

phone = re.compile(r"\d\d\d-\d\d\d-\d\d\d\d")
foo = phone.search("My number is 703-969-6032")

print(foo.group())