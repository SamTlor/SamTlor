for i in range(1, 100):
    final = ""

    if i % 3 == 0: final += "Pling"
    if i % 5 == 0: final += "Plang"
    if i % 7 == 0: final += "Plong"

    print(f"{i} {final}")