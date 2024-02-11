'Dim [Variable Name] As [Data Type] = [Value]


Imports System
Imports System.Drawing


Module Program

    'how to define a class
    Public Class Player
        Public number As Integer
    End Class



    Sub Main(args As String())

        'char is defined with the ""
        'date is defined in that format but there are others too
        'decimal is defined to be a decimal because of the D at the end
        Dim TorF As Boolean = True                      'size depends on platform
        Dim letter As Char = "S"                        '2 bytes
        Dim birth As Date = #05/18/1998 6:43:00 PM#     '8 bytes
        Dim age As Integer = 5                          '4 bytes
        Dim weight As Double = 65.22                    '8 bytes
        Dim heaviness As Decimal = 66.223432341D        '16 bytes
        Dim name As String = "Sam"                      'size depends on platform


        'for printing a var you can do {0}", [var] for inline arguments
        'or you can just do & var to put the var after the string
        Console.WriteLine("Boolean: {0} :that was the boolean", TorF)
        Console.WriteLine("Char: " & letter)
        Console.WriteLine("Date: {0}", birth)
        Console.WriteLine("Integer: " & age)
        Console.WriteLine("Double: {0}", weight)

        'can have multiple inline arguments on one line by numbering them
        Console.WriteLine("Decimal: {0}String: {1}", heaviness & vbCrLf, name)

        'printing values of class stuff
        Dim stephCurry As Player = New Player()
        stephCurry.number = 35
        Console.WriteLine("Player number is: " & stephCurry.number)

    End Sub
End Module
