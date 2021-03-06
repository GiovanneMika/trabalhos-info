Imports MySql.Data.MySqlClient
Public Class BdEquipamento
    Inherits Bd
    Public Sub New()
        Me.User = "root"
        Me.Servidor = "localhost"
        Me.Senha = "vertrigo"
        Me.bd = "equipamento"
    End Sub
    Public Sub inserir(ByVal equipamento As Equipamento)
        Dim da As MySqlDataAdapter = New MySqlDataAdapter
        Dim cmd As MySqlCommand = New MySqlCommand
        Try
            Abrir()
            cmd.CommandType = CommandType.Text
            cmd.CommandText = "insert into equipamento (id,descricao,fabricante,numserie,numpatrimonio,localizacao) values (@id,@descricao,@fabricante,@numserie,@numpatrimonio,@localizacao)"
            cmd.Parameters.AddWithValue("@id", equipamento.id)
            cmd.Parameters.AddWithValue("@descricao", equipamento.descricao)
            cmd.Parameters.AddWithValue("@fabricante", equipamento.fabricante)
            cmd.Parameters.AddWithValue("@numserie", equipamento.numserie)
            cmd.Parameters.AddWithValue("@numpatrimonio", equipamento.numpatrimonio)
            cmd.Parameters.AddWithValue("@localizacao", equipamento.localizacao)
            cmd.Connection = Conexao
            da.UpdateCommand = cmd
            da.UpdateCommand.ExecuteNonQuery()
            fechar()
        Catch ex As Exception
            MsgBox(ex.Message)
        End Try
    End Sub
    Public Sub atualizar(ByVal equipamento As Equipamento)
        Dim da As MySqlDataAdapter = New MySqlDataAdapter
        Dim cmd As MySqlCommand = New MySqlCommand
        Try
            Abrir()
            cmd.CommandType = CommandType.Text
            cmd.CommandText = "update equipamento set descricao=@descricao, fabricante=@fabricante, numserie=@numserie, numpatrimonio=@numpatrimonio, localizacao=@localizacao where id=@id"
            cmd.Parameters.AddWithValue("@id", equipamento.id)
            cmd.Parameters.AddWithValue("@descricao", equipamento.descricao)
            cmd.Parameters.AddWithValue("@fabricante", equipamento.fabricante)
            cmd.Parameters.AddWithValue("@numserie", equipamento.numserie)
            cmd.Parameters.AddWithValue("@numpatrimonio", equipamento.numpatrimonio)
            cmd.Parameters.AddWithValue("@localizacao", equipamento.localizacao)
            cmd.Connection = Conexao
            da.UpdateCommand = cmd
            da.UpdateCommand.ExecuteNonQuery()
            fechar()
        Catch ex As Exception
            MsgBox(ex.Message)
        End Try
    End Sub
    Public Sub excluir(ByVal id As Integer)
        Dim da As MySqlDataAdapter = New MySqlDataAdapter
        Dim cmd As MySqlCommand = New MySqlCommand
        Try
            Abrir()
            cmd.CommandType = CommandType.Text
            cmd.CommandText = "delete from equipamento where id=@id"
            cmd.Parameters.AddWithValue("@id", id)
            cmd.Connection = Conexao
            da.UpdateCommand = cmd
            da.UpdateCommand.ExecuteNonQuery()
            fechar()
        Catch ex As Exception
            MsgBox(ex.Message)
        End Try
    End Sub
    Public Function localizar(ByVal id As Integer) As Equipamento
        Dim dr As MySqlDataReader = Nothing
        Dim cmd As MySqlCommand = New MySqlCommand
        Dim equipamento As New Equipamento
        Try
            Abrir()
            cmd.CommandType = CommandType.Text
            cmd.CommandText = "select * from equipamento where id=@id"
            cmd.Parameters.AddWithValue("@id", id)
            cmd.Connection = Conexao
            dr = cmd.ExecuteReader
            If dr.Read Then
                equipamento.id = dr.GetInt32("id")
                equipamento.descricao = dr.GetString("descricao")
                equipamento.fabricante = dr.GetString("fabricante")
                equipamento.numserie = dr.GetString("numserie")
                equipamento.numpatrimonio = dr.GetInt32("numpatrimonio")
                equipamento.localizacao = dr.GetString("localizacao")
            End If
            cmd.Dispose()
            fechar()
        Catch ex As Exception
            MsgBox(ex.Message)
        End Try
        Return equipamento
    End Function
    Public Function pesquisa(ByVal descricao As String) As DataSet
        Dim ds As New DataSet
        Dim da As MySqlDataAdapter = New MySqlDataAdapter
        Dim cmd As MySqlCommand = New MySqlCommand
        Try
            Abrir()
            cmd.CommandType = CommandType.Text
            cmd.CommandText = "select * from equipamento where descricao like @descricao"
            cmd.Parameters.AddWithValue("@descricao", "%" & descricao & "%")

            cmd.Connection = Conexao
            da.SelectCommand = cmd
            da.Fill(ds)
            da.Dispose()
            Return ds
        Catch ex As Exception
            MsgBox(ex.Message)
        End Try
        Return ds
    End Function
End Class

