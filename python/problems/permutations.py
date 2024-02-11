def permute(string, answer):
    if (len(string) == 0):
        print(answer, end = "\n")
        return
    
    for i in range(len(string)):
        ch = string[i]
        left_substr = string[0:i]
        right_substr = string[i + 1:]
        rest = left_substr + right_substr
        permute(rest, answer + ch)


if __name__ == '__main__':
    string = "1234"

    permute(string, "")