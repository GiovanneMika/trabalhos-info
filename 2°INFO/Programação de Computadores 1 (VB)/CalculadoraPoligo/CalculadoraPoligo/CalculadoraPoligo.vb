Public Class CalculadoraPoligo
    Dim mBase As Double, mAltura As Double, mResultado As Double
    Public Property Base As Double
    Public Property Altura As Double
    Public Property Hipotenusa As Double
    Public Property Resultado As Double
    Public Sub Aqua()
        Resultado = Base * Altura
    End Sub
    Public Sub Pqua()
        Resultado = (2 * Base) + (2 * Altura)
    End Sub
    Public Sub Atri()
        Resultado = (Base * Altura) / 2
    End Sub
    Public Sub Ptri()
        Hipotenusa = ((Base * Base) + (Altura * Altura)) ^ 0.5
        Resultado = Base + Altura + Hipotenusa
    End Sub

End Class
