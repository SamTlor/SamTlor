shopping = []

def add(item):
    shopping.append(item)
    print("Added! You have {} items on your list.".format(len(shopping)))
def show_help():
    print("What should we add to the list?")
    print("""
        Enter 'done' to stop adding items
        Enter 'help' for this help
        Enter 'show' to show your current list
        Enter 'del' to delete items
        """)
def show_list():
    print("Here's your list: ")
    print(", ".join(shopping))



show_help()
while True:
    new_item = input("> ")

    if new_item.upper() == 'DONE':
        break
    elif new_item.upper() == 'HELP':
        show_help()
        continue
    elif new_item.upper() == 'SHOW':
        show_list()
        continue
    add(new_item)