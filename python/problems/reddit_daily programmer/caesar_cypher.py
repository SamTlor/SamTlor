alphabet = 'abcdefghijklmnopqrstuvwxyz'

def caesar(message, offset):
    output = ""

    for i in message:
        letter = alphabet.index(i)
        num = letter + offset

        if num >= len(alphabet):
            num -= 26

        output += alphabet[num]

    return output


print(caesar("abcz", 1))