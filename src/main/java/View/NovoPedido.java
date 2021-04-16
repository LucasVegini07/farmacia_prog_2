/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.event.ActionListener;
import Dao.RemedioDAO;
import View.TabelaRemedio;
import javax.swing.JOptionPane;
import Model.Pedido;

public class NovoPedido extends javax.swing.JFrame {

    public NovoPedido() {
        initComponents();
        RemedioDAO r = new RemedioDAO();
        tableRemedios.setModel(new TabelaRemedio(r.buscarTodos()));

    }

    public String getCpfCliente() {
        return tfcpfCliente.getText();
    }

    public String getCpfFuncionario() {
        return tfcpfVendedor.getText();
    }

    public float getValorGasto() {
        return Float.parseFloat(tfValor.getText());
    }

    public boolean validateCPFCliente() {
        if (tfcpfCliente.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "CPF do cliente inserido inv�lido");
            return false;
        }
        return true;

    }

    public boolean validateDados() {

        if (tfNomeCliente.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Nome do cliente inserido inv�lido");
            return false;
        }
        if (tfcpfCliente.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "CPF do cliente inserido inv�lido");
            return false;
        }
        if (tfValor.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Valor inserido inv�lido");
            return false;
        }

        try {
            Float.parseFloat(tfValor.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Valor precisa ser um n�mero");
            return false;
        }
        if (tfcpfVendedor.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "CPF do vendedor inv�lido");
            return false;
        }

        return true;
    }

    public Pedido getDados() {

        Pedido p = new Pedido(Float.parseFloat(tfValor.getText()), tfNomeCliente.getText(), tfcpfCliente.getText(), tfcpfVendedor.getText());
        return p;
    }

    public void setNomeCliente(String nome) {
        tfNomeCliente.setText(nome);
    }

    public String getNomeCliente() {
        return tfNomeCliente.getText();
    }

    public void addAcaoFinalizar(ActionListener acao) {
        btCompra.addActionListener(acao);
    }

    public void addAcaoVoltar(ActionListener acao) {
        btVoltar.addActionListener(acao);
    }

    public void addAcaoPesquisar(ActionListener acao) {
        btPesquisa.addActionListener(acao);
    }

    public void limparDados() {
        tfNomeCliente.setText("");
        tfValor.setText("");
        tfcpfCliente.setText("");
        tfcpfVendedor.setText("");

    }

    public void exibirMensagem(String mensagem) {
        JOptionPane.showMessageDialog(null, mensagem);
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
        jLabel5 = new javax.swing.JLabel();
        tfValor = new javax.swing.JTextField();
        tfcpfCliente = new javax.swing.JTextField();
        tfNomeCliente = new javax.swing.JTextField();
        tfcpfVendedor = new javax.swing.JTextField();
        btPesquisa = new javax.swing.JButton();
        btCompra = new javax.swing.JButton();
        btVoltar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableRemedios = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel1.setText("Novo Pedido");

        jLabel2.setText("Valor da compra");

        jLabel3.setText("CPF do Cliente");

        jLabel4.setText("Nome do Cliente");

        jLabel5.setText("CPF Vendedor");

        tfcpfCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfcpfClienteActionPerformed(evt);
            }
        });

        btPesquisa.setText("Pesquisar");
        btPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPesquisaActionPerformed(evt);
            }
        });

        btCompra.setText("Finalizar Compra");
        btCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCompraActionPerformed(evt);
            }
        });

        btVoltar.setText("Voltar");

        tableRemedios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tableRemedios);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(178, 178, 178)
                        .addComponent(btCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(56, 56, 56)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tfValor)
                                    .addComponent(tfcpfCliente)
                                    .addComponent(tfNomeCliente)
                                    .addComponent(tfcpfVendedor, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfcpfCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(btPesquisa))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfcpfVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btCompra)
                            .addComponent(btVoltar))))
                .addGap(14, 14, 14))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfcpfClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfcpfClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfcpfClienteActionPerformed

    private void btPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPesquisaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btPesquisaActionPerformed

    private void btCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCompraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btCompraActionPerformed

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
            java.util.logging.Logger.getLogger(NovoPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NovoPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NovoPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NovoPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NovoPedido().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCompra;
    private javax.swing.JButton btPesquisa;
    private javax.swing.JButton btVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableRemedios;
    private javax.swing.JTextField tfNomeCliente;
    private javax.swing.JTextField tfValor;
    private javax.swing.JTextField tfcpfCliente;
    private javax.swing.JTextField tfcpfVendedor;
    // End of variables declaration//GEN-END:variables
}