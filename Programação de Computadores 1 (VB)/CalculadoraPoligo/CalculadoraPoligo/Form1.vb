Public Class Form1
    Dim calc As New CalculadoraPoligo
    Private Sub bPqua_Click(sender As Object, e As EventArgs) Handles bPqua.Click
        calc.Base = Double.Parse(txtBase.Text)
        calc.Altura = Double.Parse(txtAltura.Text)
        calc.Pqua()
        lblResultado.Text = calc.Resultado
    End Sub

    Private Sub bAqua_Click(sender As Object, e As EventArgs) Handles bAqua.Click
        calc.Base = Double.Parse(txtBase.Text)
        calc.Altura = Double.Parse(txtAltura.Text)
        calc.Aqua()
        lblResultado.Text = calc.Resultado
    End Sub

    Private Sub bAtri_Click(sender As Object, e As EventArgs) Handles bAtri.Click
        calc.Base = Double.Parse(txtBase.Text)
        calc.Altura = Double.Parse(txtAltura.Text)
        calc.Atri()
        lblResultado.Text = calc.Resultado
    End Sub

    Private Sub bPtri_Click(sender As Object, e As EventArgs) Handles bPtri.Click
        calc.Base = Double.Parse(txtBase.Text)
        calc.Altura = Double.Parse(txtAltura.Text)
        calc.Ptri()
        lblResultado.Text = calc.Resultado
        lblHipotenusis.Text = calc.Hipotenusa
    End Sub

End Class
