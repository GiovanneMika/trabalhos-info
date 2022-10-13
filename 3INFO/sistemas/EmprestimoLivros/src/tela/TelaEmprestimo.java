/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tela;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import persistencia.AgricultorDAO;
import persistencia.EmprestimoDAO;
import persistencia.MaquinaDAO;
import vo.Agricultor;
import vo.Emprestimo;
import vo.Maquina;

/**
 *
 * @author 2info2021
 */
public class TelaEmprestimo extends javax.swing.JFrame {

    MaquinaDAO md = new MaquinaDAO();
    AgricultorDAO ad = new AgricultorDAO();
    Maquina m = new Maquina();
    Agricultor a = new Agricultor();
    Emprestimo e = new Emprestimo();
    EmprestimoDAO ed = new EmprestimoDAO();

    SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy");

    public TelaEmprestimo() {
        initComponents();
        preencheComboMaquina();
        preencheComboAgricultor();
    }

    private void preencheComboMaquina() {
        List<Maquina> lista;
        lista = md.pesquisa();
        Vector listamaq = new Vector();
        for (Maquina m : lista) {
            listamaq.add(m.getNome());
        }
        cMaquina.setModel(new JComboBox(listamaq).getModel());
    }

    private void preencheComboAgricultor() {
        List<Agricultor> lista;
        lista = ad.pesquisa();
        Vector listaagr = new Vector();
        for (Agricultor a : lista) {
            listaagr.add(a.getNome());
        }
        cAgricultor.setModel(new JComboBox(listaagr).getModel());
    }

    /*   private void emprestimoToTela() {
        tId.setText(Integer.toString(a.getId()));
        tNome.setText(a.getNome());
        tEndereco.setText(a.getEndereco());
        tTelefone.setText(a.getTelefone());
        tEmail.setText(a.getEmail());
    }*/
    private boolean telaToEmprestimo() {
        e.setId(Integer.parseInt(tId.getText()));
        e.setIdAgricultor(ad.pesquisa(cAgricultor.getSelectedItem().toString()).get(0).getId());
        e.setIdMaquina(md.pesquisa(cMaquina.getSelectedItem().toString()).get(0).getId());
        e.setDataEmprestimo(Calendar.getInstance().getTime());
        try {
            e.setDataPrevista(s.parse(tDataprev.getText()));
        } catch (ParseException ex) {
            Logger.getLogger(TelaEmprestimo.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            e.setDataDevolucao(s.parse("01/01/9999"));
        } catch (ParseException ex) {
            Logger.getLogger(TelaEmprestimo.class.getName()).log(Level.SEVERE, null, ex);
        }
        e.setEmprestado(true);

        return true;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tId = new javax.swing.JTextField();
        cMaquina = new javax.swing.JComboBox<>();
        cAgricultor = new javax.swing.JComboBox<>();
        tDataprev = new javax.swing.JFormattedTextField();
        bSalva = new javax.swing.JButton();
        bCancela = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });

        jLabel1.setText("Id");

        jLabel2.setText("Maquina");

        jLabel3.setText("Agricultor");

        jLabel4.setText("Data de Devolução");

        tId.setEditable(false);
        tId.setText("0");

        cMaquina.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cAgricultor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        try {
            tDataprev.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        tDataprev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tDataprevActionPerformed(evt);
            }
        });

        bSalva.setText("Salvar");
        bSalva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSalvaActionPerformed(evt);
            }
        });

        bCancela.setText("Cancelar");
        bCancela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCancelaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tId, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cMaquina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cAgricultor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(tDataprev, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(33, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(bSalva)
                .addGap(27, 27, 27)
                .addComponent(bCancela)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cMaquina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cAgricultor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tDataprev, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bSalva)
                    .addComponent(bCancela))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tDataprevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tDataprevActionPerformed

    }//GEN-LAST:event_tDataprevActionPerformed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        preencheComboMaquina();
        preencheComboAgricultor();
    }//GEN-LAST:event_formWindowGainedFocus

    private void bSalvaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSalvaActionPerformed
        if (telaToEmprestimo()) {
            if (tDataprev.isEditValid()) {
                System.out.println(ed.pesquisaIdmaq(md.pesquisa(cMaquina.getSelectedItem().toString()).get(0).getId()).get(0).isEmprestado());
                if (ed.pesquisaIdmaq(md.pesquisa(cMaquina.getItemAt(0)).get(0).getId()).isEmpty() | !ed.pesquisaIdmaq(md.pesquisa(cMaquina.getSelectedItem().toString()).get(0).getId()).get(0).isEmprestado()) {
                    ed.salva(e);
                } else {
                    JOptionPane.showMessageDialog(this, "Esta maquina ja esta emprestada!");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Preencha direito!");
            }
            this.dispose();
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
            java.util.logging.Logger.getLogger(TelaEmprestimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaEmprestimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaEmprestimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaEmprestimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaEmprestimo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bCancela;
    private javax.swing.JButton bSalva;
    private javax.swing.JComboBox<String> cAgricultor;
    private javax.swing.JComboBox<String> cMaquina;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JFormattedTextField tDataprev;
    private javax.swing.JTextField tId;
    // End of variables declaration//GEN-END:variables
}
