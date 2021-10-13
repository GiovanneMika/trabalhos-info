Public Class Form1
    Dim novo As Boolean = True
    Dim usuario As New Usuario
    Dim bd As New BdUsuario
    Private Sub telaToUsuario()
        usuario.Nome = txtNome.Text
        usuario.Senha = txtSenha.Text
        usuario.User = txtUser.Text
    End Sub
    Private Sub usuarioToTela()
        txtNome.Text = usuario.Nome
        txtSenha.Text = usuario.Senha
        txtUser.Text = usuario.User
    End Sub
    Private Sub limpaTela()
        txtNome.Text = ""
        txtSenha.Text = ""
        txtUser.Text = ""
    End Sub

    Private Sub btnNovo_Click(sender As Object, e As EventArgs) Handles btnNovo.Click
        novo = True
        limpaTela()
    End Sub

    Private Sub btnSalvar_Click(sender As Object, e As EventArgs) Handles btnSalvar.Click
        telaToUsuario()
        If novo Then
            bd.inserir(usuario)
        Else
            bd.atualizar(usuario)
        End If
        novo = False
    End Sub

    Private Sub btnExcluir_Click(sender As Object, e As EventArgs) Handles btnExcluir.Click
        telaToUsuario()
        bd.excluir(usuario.User)
        limpaTela()
    End Sub

    Private Sub btnLocalizar_Click(sender As Object, e As EventArgs) Handles btnLocalizar.Click
        Dim busca As String = InputBox("Digite o usuário a localizar")
        usuario = bd.localizar(busca)
        If Not usuario.Nome.Equals("") Then
            usuarioToTela()
            novo = False
        Else
            MsgBox("Usuário não Existente", vbExclamation + vbOKOnly, "Atenção")
            limpaTela()
            novo = True
        End If
    End Sub
End Class
