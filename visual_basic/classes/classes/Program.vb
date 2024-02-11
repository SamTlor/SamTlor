'the "Me" keyword is like "this" from python
'lets you use the same variable name for parameter variables and variables

Imports System

Module Program

    'global variable to keep track of total number of users
    Public global_id As Integer = 0

    'class
    Public Class User

        Public name, location As String
        Public id, age As Integer

        'default constructor
        Public Sub New()
            id = global_id
            global_id += 1
            'others are set to empty by default
            'by default Integers like age = 0
        End Sub

        'parameterized constructor
        Public Sub New(ByVal name As String, ByVal location As String,
                       ByVal age As Integer)
            id = global_id + 1
            global_id += 1
            Me.name = name
            Me.location = location
            Me.age = age
        End Sub

        'destructor
        Protected Overrides Sub Finalize()
            Console.WriteLine("An instance of user class was destroyed")
        End Sub
        'runs only when an instance of this class exists within a function
        'and the function ends so the garbage collector deletes the instance

        'Getter and setter methods done here
        'ReadOnly makes it just have the getter
        'WriteOnly would make it just have the setter
        Public ReadOnly Property Pname As String
            Get
                Return name
            End Get



        End Property
    End Class

    Sub Main(args As String())
        Dim one As User = New User()
        Console.WriteLine(one.id)
        Console.WriteLine(one.name)
        Console.WriteLine(one.location)
        Console.WriteLine(one.age)



        Console.WriteLine()
        Console.WriteLine()



        Dim two As User = New User("sam", "DC", 25)
        Console.WriteLine(two.id)
        Console.WriteLine(two.Pname)        'demonstrating properties
        Console.WriteLine(two.location)
        Console.WriteLine(two.age)

    End Sub
End Module
