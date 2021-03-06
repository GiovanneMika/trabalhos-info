/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tela;

import java.awt.TextField;
import java.text.DecimalFormat;
import java.text.ParseException;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import persistencia.FuncionarioDAO;
import vo.Funcionario;
import vo.Tabela;

/**
 *
 * @author 2info2021
 */
public class TelaINSS extends javax.swing.JFrame {

    Tabela t = new Tabela();
    FuncionarioDAO fd = new FuncionarioDAO();

    /**
     * Creates new form TelaINSS
     */
    public TelaINSS() {
        initComponents();
    }

    private void INSSToTela() {
        tTinss1.setValue(t.getTinss1());
        tTinss2.setValue(t.getTinss2());
        tTinss3.setValue(t.getTinss3());
        tTinss4.setValue(t.getTinss4());
        tAinss1.setValue(t.getAinss1());
        tAinss2.setValue(t.getAinss2());
        tAinss3.setValue(t.getAinss3());
        tAinss4.setValue(t.getAinss4());

        //formatador
        DecimalFormat numberFormat = new DecimalFormat("#.00");

        //salarios da esquerda
        //tem que somar 0,10 pq o tiago falou que tem
        tTeto1.setText(numberFormat.format(Double.sum(t.getTinss1(), 0.01)));
        tTeto2.setText(numberFormat.format(Double.sum(t.getTinss2(), 0.01)));
        tTeto3.setText(numberFormat.format(Double.sum(t.getTinss3(), 0.01)));
    }

    private boolean telaToINSS() {
        t.setTinss1(Double.parseDouble(tTinss1.getValue().toString()));
        t.setTinss2(Double.parseDouble(tTinss2.getValue().toString()));
        t.setTinss3(Double.parseDouble(tTinss3.getValue().toString()));
        t.setTinss4(Double.parseDouble(tTinss4.getValue().toString()));
        t.setAinss1(Double.parseDouble(tAinss1.getValue().toString()));
        t.setAinss2(Double.parseDouble(tAinss2.getValue().toString()));
        t.setAinss3(Double.parseDouble(tAinss3.getValue().toString()));
        t.setAinss4(Double.parseDouble(tAinss4.getValue().toString()));
        return true;
    }

    public void setTabela(Tabela t) {
        this.t = t;
        INSSToTela();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jSpinner3 = new javax.swing.JSpinner();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        bCancela = new javax.swing.JButton();
        bSalva = new javax.swing.JButton();
        jLabel24 = new javax.swing.JLabel();
        tTinss1 = new javax.swing.JSpinner();
        tAinss2 = new javax.swing.JSpinner();
        tTinss2 = new javax.swing.JSpinner();
        tAinss1 = new javax.swing.JSpinner();
        tTinss3 = new javax.swing.JSpinner();
        tTinss4 = new javax.swing.JSpinner();
        tAinss3 = new javax.swing.JSpinner();
        tAinss4 = new javax.swing.JSpinner();
        tTeto1 = new javax.swing.JTextField();
        tTeto2 = new javax.swing.JTextField();
        tTeto3 = new javax.swing.JTextField();

        jLabel6.setText("De");

        jTextField6.setText("jTextField3");

        jLabel7.setText("at??");

        jTextField7.setText("jTextField4");

        jLabel8.setText("al??quota de");

        jTextField8.setText("jTextField2");

        jLabel19.setText("%");

        jLabel22.setText("jLabel22");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Tabela do INSS");
        setBackground(new java.awt.Color(187, 165, 165));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        jLabel1.setText("At??");

        jLabel2.setText("al??quota de");

        jLabel3.setText("De");

        jLabel4.setText("at??");

        jLabel5.setText("al??quota de");

        jLabel9.setText("al??quota de");

        jLabel10.setText("at??");

        jLabel11.setText("De");

        jLabel12.setText("al??quota de");

        jLabel13.setText("at??");

        jLabel14.setText("De");

        jLabel15.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel15.setText("Sal??rios");

        jLabel16.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel16.setText("Al??quotas");

        jLabel17.setText("%");

        jLabel18.setText("%");

        jLabel20.setText("%");

        jLabel21.setText("%");

        bCancela.setText("Cancelar");
        bCancela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCancelaActionPerformed(evt);
            }
        });

        bSalva.setText("Salvar");
        bSalva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSalvaActionPerformed(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Arial", 1, 48)); // NOI18N
        jLabel24.setForeground(java.awt.Color.gray);
        jLabel24.setText("INSS");

        tTinss1.setModel(new javax.swing.SpinnerNumberModel(0.0d, 0.0d, null, 100.0d));

        tAinss2.setModel(new javax.swing.SpinnerNumberModel(0.0d, 0.0d, null, 0.5d));

        tTinss2.setModel(new javax.swing.SpinnerNumberModel(0.0d, 0.0d, null, 100.0d));

        tAinss1.setModel(new javax.swing.SpinnerNumberModel(0.0d, 0.0d, null, 0.5d));

        tTinss3.setModel(new javax.swing.SpinnerNumberModel(0.0d, 0.0d, null, 100.0d));

        tTinss4.setModel(new javax.swing.SpinnerNumberModel(0.0d, 0.0d, null, 100.0d));

        tAinss3.setModel(new javax.swing.SpinnerNumberModel(0.0d, 0.0d, null, 0.5d));

        tAinss4.setModel(new javax.swing.SpinnerNumberModel(0.0d, 0.0d, null, 0.5d));

        tTeto1.setEditable(false);
        tTeto1.setBackground(java.awt.Color.lightGray);

        tTeto2.setEditable(false);
        tTeto2.setBackground(java.awt.Color.lightGray);

        tTeto3.setEditable(false);
        tTeto3.setBackground(java.awt.Color.lightGray);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel15)
                                        .addGap(22, 22, 22))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(111, 111, 111)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tTinss2, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tTinss1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel2)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel14)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(tTeto3))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(tTeto2, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(tTinss3, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel9))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel13)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(tTinss4, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel12)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tAinss2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tAinss4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tAinss3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18)
                            .addComponent(jLabel20)
                            .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(tAinss1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel17))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel24)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(bSalva)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(bCancela))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(tTeto1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {tTeto1, tTeto2, tTeto3});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel17)
                    .addComponent(jLabel15)
                    .addComponent(tTinss1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tAinss1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel18)
                    .addComponent(tAinss2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tTinss2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tTeto1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel10)
                    .addComponent(jLabel9)
                    .addComponent(jLabel20)
                    .addComponent(tTinss3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tAinss3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tTeto2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jLabel13)
                    .addComponent(jLabel12)
                    .addComponent(jLabel21)
                    .addComponent(tTinss4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tAinss4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tTeto3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bCancela)
                            .addComponent(bSalva))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel24))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bSalvaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSalvaActionPerformed
        if (verificadora()) {
            if (telaToINSS()) {
                fd.salvaTabela(t);
                this.dispose();
            };
        } else {
            JOptionPane.showMessageDialog(this, "O valor de um teto n??o pode ser maior que seu pr??ximo ou menor que o anterior!");
        }
    }//GEN-LAST:event_bSalvaActionPerformed

    private void bCancelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCancelaActionPerformed
        this.dispose();
    }//GEN-LAST:event_bCancelaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaINSS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaINSS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaINSS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaINSS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaINSS().setVisible(true);
            }
        });
    }

    public boolean verificadora() {
        if ((Double.parseDouble(tTinss1.getValue().toString())) > (Double.parseDouble(tTinss2.getValue().toString())) || (Double.parseDouble(tTinss1.getValue().toString())) > (Double.parseDouble(tTinss3.getValue().toString())) || (Double.parseDouble(tTinss1.getValue().toString())) > (Double.parseDouble(tTinss4.getValue().toString())) || (Double.parseDouble(tTinss2.getValue().toString())) > (Double.parseDouble(tTinss3.getValue().toString())) || (Double.parseDouble(tTinss2.getValue().toString())) > (Double.parseDouble(tTinss4.getValue().toString())) || (Double.parseDouble(tTinss3.getValue().toString())) > (Double.parseDouble(tTinss4.getValue().toString())) || (Double.parseDouble(tAinss1.getValue().toString())) > (Double.parseDouble(tAinss2.getValue().toString())) || (Double.parseDouble(tAinss1.getValue().toString())) > (Double.parseDouble(tAinss3.getValue().toString())) || (Double.parseDouble(tAinss1.getValue().toString())) > (Double.parseDouble(tAinss4.getValue().toString())) || (Double.parseDouble(tAinss2.getValue().toString())) > (Double.parseDouble(tAinss3.getValue().toString())) || (Double.parseDouble(tAinss2.getValue().toString())) > (Double.parseDouble(tAinss4.getValue().toString())) || (Double.parseDouble(tAinss3.getValue().toString())) > (Double.parseDouble(tAinss4.getValue().toString()))) {

            return false;
        } else {
            return true;
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bCancela;
    private javax.swing.JButton bSalva;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSpinner jSpinner3;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JSpinner tAinss1;
    private javax.swing.JSpinner tAinss2;
    private javax.swing.JSpinner tAinss3;
    private javax.swing.JSpinner tAinss4;
    private javax.swing.JTextField tTeto1;
    private javax.swing.JTextField tTeto2;
    private javax.swing.JTextField tTeto3;
    private javax.swing.JSpinner tTinss1;
    private javax.swing.JSpinner tTinss2;
    private javax.swing.JSpinner tTinss3;
    private javax.swing.JSpinner tTinss4;
    // End of variables declaration//GEN-END:variables
}
