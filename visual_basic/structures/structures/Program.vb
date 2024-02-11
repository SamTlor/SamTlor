'just like classes but faster
'cuz they're stored on the stack instead of ..somewhere else idk

Imports System

Module Program
    'normal structure
    Public Structure User
        Public name As String
        Public location As String
        Public age As Integer
    End Structure

    'structure with a default constructor that must be parameterized
    Public Structure User_two
        Public name As String
        Public location As String
        Public age As Integer
        Public Sub New(ByVal name As String, ByVal location As String, ByVal age As Integer)
            Me.name = name
            Me.location = location
            Me.age = age
        End Sub

    End Structure

    Sub Main(args As String())
        Dim u As User = New User()
        u.name = "Sam"
        u.location = "DC"
        u.age = 25

        Dim u2 As New User_two("Dad", "Home", 53)


        Console.WriteLine(u.name)
        Console.WriteLine(u.location)
        Console.WriteLine(u.age)

        Console.WriteLine(u2.name)
        Console.WriteLine(u2.location)
        Console.WriteLine(u2.age)
    End Sub
End Module
