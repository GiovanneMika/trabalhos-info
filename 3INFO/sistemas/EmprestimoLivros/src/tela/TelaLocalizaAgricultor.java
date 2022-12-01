/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tela;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import persistencia.AgricultorDAO;
import persistencia.EmprestimoDAO;
import vo.Agricultor;

/**
 *
 * @author 2info2021
 */
public class TelaLocalizaAgricultor extends javax.swing.JFrame {

    AgricultorDAO ad = new AgricultorDAO();
    EmprestimoDAO ed = new EmprestimoDAO();

    /**
     * Creates new form TelaLocalizaAgronomo
     */
    public TelaLocalizaAgricultor() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tLocalizaAgricultor = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        tFiltro = new javax.swing.JTextField();
        bFiltro = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        bNovo = new javax.swing.JMenuItem();
        bEdita = new javax.swing.JMenuItem();
        bExclui = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Agricultores");
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });

        tLocalizaAgricultor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Id", "Nome", "Endereço", "Telefone", "Email"
            }
        ));
        jScrollPane1.setViewportView(tLocalizaAgricultor);

        jLabel1.setText("Filtro:");

        bFiltro.setText("Ok");
        bFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bFiltroActionPerformed(evt);
            }
        });

        jMenu1.setText("Ações");

        bNovo.setText("Novo Agricultor");
        bNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bNovoActionPerformed(evt);
            }
        });
        jMenu1.add(bNovo);

        bEdita.setText("Editar Agricultor");
        bEdita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bEditaActionPerformed(evt);
            }
        });
        jMenu1.add(bEdita);

        bExclui.setText("Exclui Agricultor");
        bExclui.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bExcluiActionPerformed(evt);
            }
        });
        jMenu1.add(bExclui);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bFiltro)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bFiltro))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        preencheTabelaAgricultor();
    }//GEN-LAST:event_formWindowGainedFocus

    private void bNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bNovoActionPerformed
        TelaAgricultor ta = new TelaAgricultor();
        ta.setVisible(true);
    }//GEN-LAST:event_bNovoActionPerformed

    private void bEditaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEditaActionPerformed
        DefaultTableModel modelo = (DefaultTableModel) tLocalizaAgricultor.getModel();
        if (tLocalizaAgricultor.getSelectedRow() != -1) {
            int id = (Integer) modelo.getValueAt(tLocalizaAgricultor.getSelectedRow(), 0);
            TelaAgricultor ta = new TelaAgricultor();
            ta.setAgricultor(ad.localiza(id));
            ta.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Não há nada selecionado!");
        }
    }//GEN-LAST:event_bEditaActionPerformed

    private void bExcluiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bExcluiActionPerformed
        //tem que fazer um if vendo se o agricultor tem algo emprestado ainda
        DefaultTableModel modelo = (DefaultTableModel) tLocalizaAgricultor.getModel();
        if (tLocalizaAgricultor.getSelectedRow() != -1) {
            int id = (Integer) modelo.getValueAt(tLocalizaAgricultor.getSelectedRow(), 0);
            if (ed.pesquisaIdagri(id).isEmpty()) {
                Agricultor a = ad.localiza(id);
                if (JOptionPane.showConfirmDialog(this, "Confirma exclusão de " + a.getNome() + "?") == JOptionPane.YES_OPTION) {
                    ad.exclui(a);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Esse agricultor possui registro de emprestimos!");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Não há nada selecionado!");
        }
    }//GEN-LAST:event_bExcluiActionPerformed

    private void bFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bFiltroActionPerformed
        preencheTabelaAgricultor();
    }//GEN-LAST:event_bFiltroActionPerformed
    private void preencheTabelaAgricultor() {
        DefaultTableModel modelo = (DefaultTableModel) tLocalizaAgricultor.getModel();
        int i = modelo.getRowCount();
        while (i-- > 0) {
            modelo.removeRow(i);
        }
        List<Agricultor> lista;
        if (tFiltro.getText().equals("")) {
            lista = ad.pesquisa();
        } else {
            lista = ad.pesquisa(tFiltro.getText());
        }
        for (Agricultor a : lista) {
            modelo.addRow(new Object[]{a.getId(), a.getNome(), a.getEndereco(), a.getTelefone(), a.getEmail()});
        }
    }

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
            java.util.logging.Logger.getLogger(TelaLocalizaAgricultor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaLocalizaAgricultor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaLocalizaAgricultor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaLocalizaAgricultor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaLocalizaAgricultor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem bEdita;
    private javax.swing.JMenuItem bExclui;
    private javax.swing.JButton bFiltro;
    private javax.swing.JMenuItem bNovo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField tFiltro;
    private javax.swing.JTable tLocalizaAgricultor;
    // End of variables declaration//GEN-END:variables
}