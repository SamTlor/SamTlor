'nested if works how you think

Imports System

Module Program
    Sub Main(args As String())

        Dim var As Boolean = True
        Dim x As Integer = 5

        'classic if
        If var Then
            Console.WriteLine("var is True")
        End If

        'if with a conditional
        If x < 10 Then
            Console.WriteLine("x < 10")
        End If

        'if else
        If x < 1 Then
            Console.WriteLine("x < 1")
        Else
            Console.WriteLine("x > 1")
        End If

        'if else-if 
        If x < 1 Then
            Console.WriteLine("x < 1")
        ElseIf x > 1 And x < 10 Then
            Console.WriteLine("x > 1 and x < 10")
        Else
            Console.WriteLine("x > 10")
        End If

        'ternary operation
        Dim result As String = If((x < 1), "x < 1", "x > 1")
        Console.WriteLine(result)

        'switch statement
        Select Case x
            Case 4
                Console.WriteLine("value is 4")
            Case 5
                Console.WriteLine("value is 5")
            Case 6
                Console.WriteLine("value is 6")
            Case Else
                Console.WriteLine("value is unknown")
        End Select

    End Sub
End Module