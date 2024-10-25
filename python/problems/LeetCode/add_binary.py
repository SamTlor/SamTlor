class Solution:
    def addBinary(self, a, b):
        ending = ""

        carry = 0

        for i, j in range(len(a) - 1, 0, -1), range(len(b) - 1, 0, -1):
            sum = carry

            if i >= 0:
                sum += ord(a[i]) - ord('0')
            if j >= 0:
                sum += ord(b[j]) - ord('0')

            carry = 1 if sum > 1 else 0

            ending += str(sum % 2)

        if carry != 0:
            ending += str(carry)

        return ending[::-1]