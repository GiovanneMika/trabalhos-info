<Global.Microsoft.VisualBasic.CompilerServices.DesignerGenerated()> _
Partial Class Form1
    Inherits System.Windows.Forms.Form

    'Form overrides dispose to clean up the component list.
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

    'Required by the Windows Form Designer
    Private components As System.ComponentModel.IContainer

    'NOTE: The following procedure is required by the Windows Form Designer
    'It can be modified using the Windows Form Designer.  
    'Do not modify it using the code editor.
    <System.Diagnostics.DebuggerStepThrough()> _
    Private Sub InitializeComponent()
        Me.Label1 = New System.Windows.Forms.Label()
        Me.Label2 = New System.Windows.Forms.Label()
        Me.txtValor1 = New System.Windows.Forms.TextBox()
        Me.txtValor2 = New System.Windows.Forms.TextBox()
        Me.btnSoma = New System.Windows.Forms.Button()
        Me.btnSubtrai = New System.Windows.Forms.Button()
        Me.btnMultiplica = New System.Windows.Forms.Button()
        Me.btnDivide = New System.Windows.Forms.Button()
        Me.lblResultado = New System.Windows.Forms.Label()
        Me.SuspendLayout()
        '
        'Label1
        '
        Me.Label1.AutoSize = True
        Me.Label1.Location = New System.Drawing.Point(12, 29)
        Me.Label1.Name = "Label1"
        Me.Label1.Size = New System.Drawing.Size(125, 15)
        Me.Label1.TabIndex = 0
        Me.Label1.Text = "Digite o primeiro valor"
        '
        'Label2
        '
        Me.Label2.AutoSize = True
        Me.Label2.Location = New System.Drawing.Point(12, 57)
        Me.Label2.Name = "Label2"
        Me.Label2.Size = New System.Drawing.Size(126, 15)
        Me.Label2.TabIndex = 1
        Me.Label2.Text = "Digite o segundo valor"
        '
        'txtValor1
        '
        Me.txtValor1.Location = New System.Drawing.Point(143, 26)
        Me.txtValor1.Name = "txtValor1"
        Me.txtValor1.Size = New System.Drawing.Size(100, 23)
        Me.txtValor1.TabIndex = 2
        '
        'txtValor2
        '
        Me.txtValor2.Location = New System.Drawing.Point(143, 55)
        Me.txtValor2.Name = "txtValor2"
        Me.txtValor2.Size = New System.Drawing.Size(100, 23)
        Me.txtValor2.TabIndex = 3
        '
        'btnSoma
        '
        Me.btnSoma.Location = New System.Drawing.Point(13, 104)
        Me.btnSoma.Name = "btnSoma"
        Me.btnSoma.Size = New System.Drawing.Size(75, 23)
        Me.btnSoma.TabIndex = 4
        Me.btnSoma.Text = "Soma"
        Me.btnSoma.UseVisualStyleBackColor = True
        '
        'btnSubtrai
        '
        Me.btnSubtrai.Location = New System.Drawing.Point(94, 104)
        Me.btnSubtrai.Name = "btnSubtrai"
        Me.btnSubtrai.Size = New System.Drawing.Size(75, 24)
        Me.btnSubtrai.TabIndex = 5
        Me.btnSubtrai.Text = "Subtrai"
        Me.btnSubtrai.UseVisualStyleBackColor = True
        '
        'btnMultiplica
        '
        Me.btnMultiplica.Location = New System.Drawing.Point(175, 104)
        Me.btnMultiplica.Name = "btnMultiplica"
        Me.btnMultiplica.Size = New System.Drawing.Size(75, 23)
        Me.btnMultiplica.TabIndex = 6
        Me.btnMultiplica.Text = "Multiplica"
        Me.btnMultiplica.UseVisualStyleBackColor = True
        '
        'btnDivide
        '
        Me.btnDivide.Location = New System.Drawing.Point(256, 104)
        Me.btnDivide.Name = "btnDivide"
        Me.btnDivide.Size = New System.Drawing.Size(75, 23)
        Me.btnDivide.TabIndex = 7
        Me.btnDivide.Text = "Divide"
        Me.btnDivide.UseVisualStyleBackColor = True
        '
        'lblResultado
        '
        Me.lblResultado.AutoSize = True
        Me.lblResultado.Location = New System.Drawing.Point(46, 185)
        Me.lblResultado.Name = "lblResultado"
        Me.lblResultado.Size = New System.Drawing.Size(0, 15)
        Me.lblResultado.TabIndex = 8
        '
        'Form1
        '
        Me.AutoScaleDimensions = New System.Drawing.SizeF(7.0!, 15.0!)
        Me.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font
        Me.ClientSize = New System.Drawing.Size(382, 450)
        Me.Controls.Add(Me.lblResultado)
        Me.Controls.Add(Me.btnDivide)
        Me.Controls.Add(Me.btnMultiplica)
        Me.Controls.Add(Me.btnSubtrai)
        Me.Controls.Add(Me.btnSoma)
        Me.Controls.Add(Me.txtValor2)
        Me.Controls.Add(Me.txtValor1)
        Me.Controls.Add(Me.Label2)
        Me.Controls.Add(Me.Label1)
        Me.Name = "Form1"
        Me.Text = "Form1"
        Me.ResumeLayout(False)
        Me.PerformLayout()

    End Sub

    Friend WithEvents Label1 As Label
    Friend WithEvents Label2 As Label
    Friend WithEvents txtValor1 As TextBox
    Friend WithEvents txtValor2 As TextBox
    Friend WithEvents btnSoma As Button
    Friend WithEvents btnSubtrai As Button
    Friend WithEvents btnMultiplica As Button
    Friend WithEvents btnDivide As Button
    Friend WithEvents lblResultado As Label
End Class
