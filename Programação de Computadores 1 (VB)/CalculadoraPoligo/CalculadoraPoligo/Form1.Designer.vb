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
        Me.lblHipotenusa = New System.Windows.Forms.Label()
        Me.txtBase = New System.Windows.Forms.TextBox()
        Me.txtAltura = New System.Windows.Forms.TextBox()
        Me.Label3 = New System.Windows.Forms.Label()
        Me.bPqua = New System.Windows.Forms.Button()
        Me.bAqua = New System.Windows.Forms.Button()
        Me.bAtri = New System.Windows.Forms.Button()
        Me.bPtri = New System.Windows.Forms.Button()
        Me.lblResultado = New System.Windows.Forms.Label()
        Me.Label4 = New System.Windows.Forms.Label()
        Me.lblHipotenusis = New System.Windows.Forms.Label()
        Me.SuspendLayout()
        '
        'Label1
        '
        Me.Label1.AutoSize = True
        Me.Label1.Location = New System.Drawing.Point(43, 65)
        Me.Label1.Name = "Label1"
        Me.Label1.Size = New System.Drawing.Size(120, 15)
        Me.Label1.TabIndex = 0
        Me.Label1.Text = "Insira o valor da base:"
        '
        'lblHipotenusa
        '
        Me.lblHipotenusa.AutoSize = True
        Me.lblHipotenusa.Location = New System.Drawing.Point(43, 102)
        Me.lblHipotenusa.Name = "lblHipotenusa"
        Me.lblHipotenusa.Size = New System.Drawing.Size(126, 15)
        Me.lblHipotenusa.TabIndex = 1
        Me.lblHipotenusa.Text = "Insira o valor da altura:"
        '
        'txtBase
        '
        Me.txtBase.Location = New System.Drawing.Point(170, 56)
        Me.txtBase.Name = "txtBase"
        Me.txtBase.Size = New System.Drawing.Size(100, 23)
        Me.txtBase.TabIndex = 2
        '
        'txtAltura
        '
        Me.txtAltura.Location = New System.Drawing.Point(176, 102)
        Me.txtAltura.Name = "txtAltura"
        Me.txtAltura.Size = New System.Drawing.Size(100, 23)
        Me.txtAltura.TabIndex = 3
        '
        'Label3
        '
        Me.Label3.AutoSize = True
        Me.Label3.Font = New System.Drawing.Font("Segoe UI", 14.0!, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point)
        Me.Label3.ForeColor = System.Drawing.SystemColors.Desktop
        Me.Label3.Location = New System.Drawing.Point(221, 166)
        Me.Label3.Name = "Label3"
        Me.Label3.Size = New System.Drawing.Size(276, 25)
        Me.Label3.TabIndex = 4
        Me.Label3.Text = "Selecione a operação desejada:"
        '
        'bPqua
        '
        Me.bPqua.Location = New System.Drawing.Point(93, 242)
        Me.bPqua.Name = "bPqua"
        Me.bPqua.Size = New System.Drawing.Size(143, 21)
        Me.bPqua.TabIndex = 5
        Me.bPqua.Text = "Perímetro do Quadrado"
        Me.bPqua.UseVisualStyleBackColor = True
        '
        'bAqua
        '
        Me.bAqua.Location = New System.Drawing.Point(242, 242)
        Me.bAqua.Name = "bAqua"
        Me.bAqua.Size = New System.Drawing.Size(118, 21)
        Me.bAqua.TabIndex = 6
        Me.bAqua.Text = "Área do Quadrado"
        Me.bAqua.UseVisualStyleBackColor = True
        '
        'bAtri
        '
        Me.bAtri.Location = New System.Drawing.Point(366, 242)
        Me.bAtri.Name = "bAtri"
        Me.bAtri.Size = New System.Drawing.Size(112, 21)
        Me.bAtri.TabIndex = 7
        Me.bAtri.Text = "Área do Triângulo"
        Me.bAtri.UseVisualStyleBackColor = True
        '
        'bPtri
        '
        Me.bPtri.Location = New System.Drawing.Point(484, 242)
        Me.bPtri.Name = "bPtri"
        Me.bPtri.Size = New System.Drawing.Size(196, 21)
        Me.bPtri.TabIndex = 8
        Me.bPtri.Text = "Perímetro do Triângulo Retângulo"
        Me.bPtri.UseVisualStyleBackColor = True
        '
        'lblResultado
        '
        Me.lblResultado.AutoSize = True
        Me.lblResultado.Font = New System.Drawing.Font("Segoe UI", 13.0!, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point)
        Me.lblResultado.Location = New System.Drawing.Point(345, 340)
        Me.lblResultado.Name = "lblResultado"
        Me.lblResultado.Size = New System.Drawing.Size(0, 25)
        Me.lblResultado.TabIndex = 9
        '
        'Label4
        '
        Me.Label4.AutoSize = True
        Me.Label4.Location = New System.Drawing.Point(484, 287)
        Me.Label4.Name = "Label4"
        Me.Label4.Size = New System.Drawing.Size(76, 15)
        Me.Label4.TabIndex = 10
        Me.Label4.Text = "Hipotenusa="
        '
        'lblHipotenusis
        '
        Me.lblHipotenusis.AutoSize = True
        Me.lblHipotenusis.Location = New System.Drawing.Point(561, 287)
        Me.lblHipotenusis.Name = "lblHipotenusis"
        Me.lblHipotenusis.Size = New System.Drawing.Size(0, 15)
        Me.lblHipotenusis.TabIndex = 11
        '
        'Form1
        '
        Me.AutoScaleDimensions = New System.Drawing.SizeF(7.0!, 15.0!)
        Me.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font
        Me.ClientSize = New System.Drawing.Size(802, 450)
        Me.Controls.Add(Me.lblHipotenusis)
        Me.Controls.Add(Me.Label4)
        Me.Controls.Add(Me.lblResultado)
        Me.Controls.Add(Me.bPtri)
        Me.Controls.Add(Me.bAtri)
        Me.Controls.Add(Me.bAqua)
        Me.Controls.Add(Me.bPqua)
        Me.Controls.Add(Me.Label3)
        Me.Controls.Add(Me.txtAltura)
        Me.Controls.Add(Me.txtBase)
        Me.Controls.Add(Me.lblHipotenusa)
        Me.Controls.Add(Me.Label1)
        Me.Name = "Form1"
        Me.Text = "Form1"
        Me.ResumeLayout(False)
        Me.PerformLayout()

    End Sub

    Friend WithEvents Label1 As Label
    Friend WithEvents lblHipotenusa As Label
    Friend WithEvents txtBase As TextBox
    Friend WithEvents txtAltura As TextBox
    Friend WithEvents Label3 As Label
    Friend WithEvents bPqua As Button
    Friend WithEvents bAqua As Button
    Friend WithEvents bAtri As Button
    Friend WithEvents bPtri As Button
    Friend WithEvents lblResultado As Label
    Friend WithEvents Label4 As Label
    Friend WithEvents lblHipotenusis As Label
End Class
