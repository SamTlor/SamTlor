def change(start):
    final = 0

    dividends = [500, 100, 25, 10, 5, 1]

    for i in dividends:
        final += int(start / i)
        start %= i
    
    return final

print(change(501))