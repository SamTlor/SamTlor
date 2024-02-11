lbs = input("What are the weights of the items?")
val = input("What are the values of the items?")

lbs = lbs.split(",")
val = val.split(",")

for x in range(0, len(lbs)):
    lbs[x] = int(lbs[x])
for y in range(0, len(val)):
    val[y] = int(val[y])

def thief(lbs,val):

    weight = lbs
    value = val

    limit = 10
    n = len(weight)

    table = []

    for i in range(n + 1):
        table.append([])
        for _ in range(limit + 1):
            table[i].append([])

    for x in range(len(table[0])):
        table[0][x] = 0
    for y in range(len(table)):
        table[y][0] = 0

    for a in range(1,limit+1):
        for b in range(len(weight)):
            without = table[b][a]
            most_with = 0

            if a >= weight[b]:
                most_with = value[b]

                space_left = a - weight[b]
                most_with += table[b][space_left]

            table[b+1][a] = max(without, most_with)

    return table[len(weight)][limit]

print(thief(lbs,val))