'sub doesn't return anything
'function does need to return


Imports System

Module Program
    Sub Main(args As String())
        Dim result As String = GetUserDetails("Sam", 25)
        Console.WriteLine(result)
        GetDetails()
    End Sub

    Public Sub GetDetails()
        Console.WriteLine("Press Enter Key to Exit..")
    End Sub

    Public Function GetUserDetails(ByVal name As String, ByVal age As Integer) As String
        Dim info As String = String.Format("Name: {0}, Age: {1}", name, age)
        Return info
    End Function
End Module
