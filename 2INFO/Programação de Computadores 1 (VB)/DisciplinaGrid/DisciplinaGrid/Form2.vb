Public Class Form2
    Dim mDisciplina As New Disciplina
    Dim mnovo As Boolean
    Dim bd As New BdDisciplina
    Private Sub disciplinatotela()
        txtcodigo.Text = mDisciplina.codigo
        txtnome.Text = mDisciplina.nome
        txtch.Text = mDisciplina.ch
        txtprofessor.Text = mDisciplina.professor
    End Sub
    Private Sub telatodisciplina()
        mDisciplina.codigo = txtcodigo.Text
        mDisciplina.nome = txtnome.Text
        mDisciplina.ch = txtch.Text
        mDisciplina.professor = txtprofessor.Text
    End Sub
    Public Property disciplina()
        Get
            Return mDisciplina
        End Get
        Set(ByVal value)
            mDisciplina = value
            disciplinatotela()
        End Set
    End Property
    Public Property novo()
        Get
            Return mnovo
        End Get
        Set(ByVal value)
            mnovo = value
        End Set
    End Property

End Class