tests = ["leetcode", "abbcccddddeeeeedcba", "triplepillooooow", "hooraaaaaaaaaaay", "tourist", "ccbccbb"]

for word in tests:

    most = 1

    for i in range(len(word) - 1):
        count = 1
        var = word[i]
        if var == word[i + 1]:
            while i != len(word)-1 and word[i+1] == var:
                count += 1
                i += 1
                if count > most:
                    most = count

    print(most)