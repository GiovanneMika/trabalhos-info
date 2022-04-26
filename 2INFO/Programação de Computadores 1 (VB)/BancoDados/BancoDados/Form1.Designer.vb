<Global.Microsoft.VisualBasic.CompilerServices.DesignerGenerated()> _
Partial Class Form1
    Inherits System.Windows.Forms.Form

    'Descartar substituições de formulário para limpar a lista de componentes.
    <System.Diagnostics.DebuggerNonUserCode()> _
    Protected Overrides Sub Dispose(ByVal disposing As Boolean)
        Try
            If disposing AndAlso components IsNot Nothing Then
                components.Dispose()
            End If
        Finally
            MyBase.Dispose(disposing)
        End Try
    End Sub

    'Exigido pelo Windows Form Designer
    Private components As System.ComponentModel.IContainer

    'OBSERVAÇÃO: o procedimento a seguir é exigido pelo Windows Form Designer
    'Pode ser modificado usando o Windows Form Designer.  
    'Não o modifique usando o editor de códigos.
    <System.Diagnostics.DebuggerStepThrough()> _
    Private Sub InitializeComponent()
        Me.Label1 = New System.Windows.Forms.Label()
        Me.Label2 = New System.Windows.Forms.Label()
        Me.Label3 = New System.Windows.Forms.Label()
        Me.txtUser = New System.Windows.Forms.TextBox()
        Me.txtNome = New System.Windows.Forms.TextBox()
        Me.txtSenha = New System.Windows.Forms.TextBox()
        Me.btnNovo = New System.Windows.Forms.Button()
        Me.btnSalvar = New System.Windows.Forms.Button()
        Me.btnExcluir = New System.Windows.Forms.Button()
        Me.btnLocalizar = New System.Windows.Forms.Button()
        Me.SuspendLayout()
        '
        'Label1
        '
        Me.Label1.AutoSize = True
        Me.Label1.Location = New System.Drawing.Point(16, 9)
        Me.Label1.Name = "Label1"
        Me.Label1.Size = New System.Drawing.Size(29, 13)
        Me.Label1.TabIndex = 0
        Me.Label1.Text = "User"
        '
        'Label2
        '
        Me.Label2.AutoSize = True
        Me.Label2.Location = New System.Drawing.Point(16, 36)
        Me.Label2.Name = "Label2"
        Me.Label2.Size = New System.Drawing.Size(35, 13)
        Me.Label2.TabIndex = 1
        Me.Label2.Text = "Nome"
        '
        'Label3
        '
        Me.Label3.AutoSize = True
        Me.Label3.Location = New System.Drawing.Point(16, 67)
        Me.Label3.Name = "Label3"
        Me.Label3.Size = New System.Drawing.Size(38, 13)
        Me.Label3.TabIndex = 2
        Me.Label3.Text = "Senha"
        '
        'txtUser
        '
        Me.txtUser.Location = New System.Drawing.Point(52, 9)
        Me.txtUser.Name = "txtUser"
        Me.txtUser.Size = New System.Drawing.Size(100, 20)
        Me.txtUser.TabIndex = 3
        '
        'txtNome
        '
        Me.txtNome.Location = New System.Drawing.Point(58, 36)
        Me.txtNome.Name = "txtNome"
        Me.txtNome.Size = New System.Drawing.Size(100, 20)
        Me.txtNome.TabIndex = 4
        '
        'txtSenha
        '
        Me.txtSenha.Location = New System.Drawing.Point(61, 67)
        Me.txtSenha.Name = "txtSenha"
        Me.txtSenha.Size = New System.Drawing.Size(100, 20)
        Me.txtSenha.TabIndex = 5
        '
        'btnNovo
        '
        Me.btnNovo.Location = New System.Drawing.Point(13, 114)
        Me.btnNovo.Name = "btnNovo"
        Me.btnNovo.Size = New System.Drawing.Size(75, 23)
        Me.btnNovo.TabIndex = 6
        Me.btnNovo.Text = "Novo"
        Me.btnNovo.UseVisualStyleBackColor = True
        '
        'btnSalvar
        '
        Me.btnSalvar.Location = New System.Drawing.Point(121, 113)
        Me.btnSalvar.Name = "btnSalvar"
        Me.btnSalvar.Size = New System.Drawing.Size(75, 23)
        Me.btnSalvar.TabIndex = 7
        Me.btnSalvar.Text = "Salvar"
        Me.btnSalvar.UseVisualStyleBackColor = True
        '
        'btnExcluir
        '
        Me.btnExcluir.Location = New System.Drawing.Point(231, 112)
        Me.btnExcluir.Name = "btnExcluir"
        Me.btnExcluir.Size = New System.Drawing.Size(75, 23)
        Me.btnExcluir.TabIndex = 8
        Me.btnExcluir.Text = "Excluir"
        Me.btnExcluir.UseVisualStyleBackColor = True
        '
        'btnLocalizar
        '
        Me.btnLocalizar.Location = New System.Drawing.Point(231, 32)
        Me.btnLocalizar.Name = "btnLocalizar"
        Me.btnLocalizar.Size = New System.Drawing.Size(75, 23)
        Me.btnLocalizar.TabIndex = 9
        Me.btnLocalizar.Text = "Localizar"
        Me.btnLocalizar.UseVisualStyleBackColor = True
        '
        'Form1
        '
        Me.AutoScaleDimensions = New System.Drawing.SizeF(6.0!, 13.0!)
        Me.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font
        Me.ClientSize = New System.Drawing.Size(485, 283)
        Me.Controls.Add(Me.btnLocalizar)
        Me.Controls.Add(Me.btnExcluir)
        Me.Controls.Add(Me.btnSalvar)
        Me.Controls.Add(Me.btnNovo)
        Me.Controls.Add(Me.txtSenha)
        Me.Controls.Add(Me.txtNome)
        Me.Controls.Add(Me.txtUser)
        Me.Controls.Add(Me.Label3)
        Me.Controls.Add(Me.Label2)
        Me.Controls.Add(Me.Label1)
        Me.Name = "Form1"
        Me.Text = "Form1"
        Me.ResumeLayout(False)
        Me.PerformLayout()

    End Sub

    Friend WithEvents Label1 As Label
    Friend WithEvents Label2 As Label
    Friend WithEvents Label3 As Label
    Friend WithEvents txtUser As TextBox
    Friend WithEvents txtNome As TextBox
    Friend WithEvents txtSenha As TextBox
    Friend WithEvents btnNovo As Button
    Friend WithEvents btnSalvar As Button
    Friend WithEvents btnExcluir As Button
    Friend WithEvents btnLocalizar As Button
End Class
