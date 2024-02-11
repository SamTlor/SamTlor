' these are just the weird ones. all the others are what you would expect
' +, -, *, ^, +=, -=, ..., ^= all do exactly what you would think
' &= concatonates two strings
' <<= and >>= moves the left operand bit values to the left or right
' And, Or, Not, Xor behave as you'd expect
' AndAlso is only true if both values are True not just defined as values
' OrElse is true if either value is True but not if they're just defined as values
' <> is !=
' + will concatenate two strings

Imports System

Module Program
    Sub Main(args As String())
        Dim a As Integer = 9
        Dim b As Integer = 4

        'division returning floating point value
        Console.WriteLine(a / b)
        'division returning integer value
        Console.WriteLine(a \ b)
        'mod
        Console.WriteLine(a Mod b)
    End Sub
End Module
