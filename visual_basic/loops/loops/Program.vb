'can define i anywhere
'for loops can't count backwards but while loops can

'for i = [start] to [end]
'can exit with an if: "if [condition] Then Exit [For / While / Do]

Imports System

Module Program
    Sub Main(args As String())

        'for
        Dim i As Integer = 0
        For i = 1 To 10
            If i = 7 Then Exit For                  'if i == 7 for loop stops
            Console.WriteLine("i = " & i)           'otherwise this runs
        Next
        Console.WriteLine("all done")

        'nested for
        For i = 1 To 10
            For j As Integer = 1 To 10
                Console.Write("{0}", i * j & vbTab)
            Next
            Console.WriteLine()
        Next

        'while
        i = 0
        While i < 10
            Console.WriteLine("i value " & i)
            i += 1
            If i = 7 Then Exit While
        End While


        'do while
        Console.WriteLine()         'for readability. ignore this
        i = 1
        Do
            Console.WriteLine("i value {0}", i)
            i += 1
            If i = 7 Then Exit Do
        Loop While i < 10

        Dim names As String() = New String(2) {"Michael", "Laz", "Dawit"}
        'for each
        For Each name As String In names
            Console.WriteLine(name)
        Next

        'GoTo
        For i = 0 To 5
            If i = 3 Then
                GoTo endloop
            End If
            Console.WriteLine("i value is: " & i)
        Next

endloop:
        Console.WriteLine("It skipped here")

    End Sub
End Module
