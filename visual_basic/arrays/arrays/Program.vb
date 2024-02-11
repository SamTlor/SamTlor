'Dim array_name As [Data_Type]()
'initializing it is done with:
'   New [Data_Type]( [size] ) {}

'size is the (actual size - 1)



Imports System
Imports System.ComponentModel.DataAnnotations

Module Program
    Sub Main(args As String())
        'declaring
        Dim numbers As Integer()
        Dim phrases As String() = New String(3) {"hello", "there", "general", "kenobi"}
        Dim TorFs As Boolean() = New Boolean(3) {}

        'assigning values
        numbers = New Integer(5) {}
        numbers = {1, 4, 2, 5, 3}
        TorFs(0) = True
        TorFs(1) = False
        TorFs(2) = False
        TorFs(3) = True
        'TorFs(4) = False           'this would cause an out of bounds exception

        'printing
        For i As Integer = 0 To numbers.Length - 1
            Console.WriteLine(numbers(i))
        Next

        For Each phrase As String In phrases
            Console.WriteLine(phrase)
        Next

        'array class functions
        Array.Sort(numbers)
        Array.Reverse(numbers)
        For i As Integer = 0 To numbers.Length - 1
            Console.WriteLine(numbers(i))
        Next




        'multidimensional
        Dim two_d_arr As Integer(,) = New Integer(2, 1) {{4, 5}, {5, 0}, {3, 1}}

        'multidimensional array without dimensions
        Dim two_d_arr2 As Integer(,,) = New Integer(,,) {{{1, 2, 3}, {4, 5, 6}}, {{7, 8, 9}, {10, 11, 12}}}

        Console.WriteLine()
        Console.WriteLine(two_d_arr(1, 0))          '5
        Console.WriteLine(two_d_arr2(0, 0, 0))      '1



        'jagged array declaration. Array of arrays
        Dim jarray As Integer()(,) = New Integer(2)(,) {}
        jarray(0) = New Integer(1, 1) {{15, 24}, {43, 54}}
        jarray(1) = New Integer(,) {{11, 12}, {13, 14}, {25, 26}}
        jarray(2) = New Integer(3, 2) {}
    End Sub
End Module
