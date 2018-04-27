/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifpb.view;

import br.com.ifpb.model.CalculaImc;

/**
 *
 * @author claudio
 */
public class JanelaCalculaImc extends javax.swing.JFrame {

    /**
     * Creates new form JanelaPrincipal
     */
    public JanelaCalculaImc() {
        initComponents();
        setLocationRelativeTo(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BotaoVoltar = new javax.swing.JButton();
        BotaoSair = new javax.swing.JButton();
        ImagemLogo = new javax.swing.JLabel();
        TextoCalculandoIMC = new javax.swing.JLabel();
        CalculandoPeso = new javax.swing.JLabel();
        CalculandoAltura = new javax.swing.JLabel();
        Resultado = new javax.swing.JLabel();
        txtAltura = new javax.swing.JTextField();
        txtPeso = new javax.swing.JTextField();
        txtResultado = new javax.swing.JTextField();
        BotaoCalcularIMC = new javax.swing.JButton();
        BotaoLimpar = new javax.swing.JButton();
        ImagemFundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(850, 556));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BotaoVoltar.setBackground(new java.awt.Color(0, 0, 204));
        BotaoVoltar.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        BotaoVoltar.setForeground(new java.awt.Color(255, 255, 255));
        BotaoVoltar.setText("VOLTAR");
        BotaoVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoVoltarActionPerformed(evt);
            }
        });
        getContentPane().add(BotaoVoltar, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 462, 110, 30));

        BotaoSair.setBackground(new java.awt.Color(255, 0, 0));
        BotaoSair.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        BotaoSair.setForeground(new java.awt.Color(255, 255, 255));
        BotaoSair.setText("SAIR");
        BotaoSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoSairActionPerformed(evt);
            }
        });
        getContentPane().add(BotaoSair, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 510, 110, -1));

        ImagemLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fotos-logo-academiaOK.png"))); // NOI18N
        getContentPane().add(ImagemLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 60, -1, -1));

        TextoCalculandoIMC.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        TextoCalculandoIMC.setForeground(new java.awt.Color(255, 255, 255));
        TextoCalculandoIMC.setText("Calculando IMC");
        getContentPane().add(TextoCalculandoIMC, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 300, 310, 40));

        CalculandoPeso.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        CalculandoPeso.setForeground(new java.awt.Color(255, 255, 255));
        CalculandoPeso.setText("Digite Seu Peso");
        getContentPane().add(CalculandoPeso, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, 230, 40));

        CalculandoAltura.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        CalculandoAltura.setForeground(new java.awt.Color(255, 255, 255));
        CalculandoAltura.setText("Resultado");
        getContentPane().add(CalculandoAltura, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 490, 130, 40));

        Resultado.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        Resultado.setForeground(new java.awt.Color(255, 255, 255));
        Resultado.setText("Digite Sua Altura");
        getContentPane().add(Resultado, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 370, 210, 40));
        getContentPane().add(txtAltura, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 380, 90, 30));
        getContentPane().add(txtPeso, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 380, 90, 30));
        getContentPane().add(txtResultado, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 490, 90, 40));

        BotaoCalcularIMC.setBackground(new java.awt.Color(0, 153, 0));
        BotaoCalcularIMC.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        BotaoCalcularIMC.setText("CALCULAR");
        BotaoCalcularIMC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoCalcularIMCActionPerformed(evt);
            }
        });
        getContentPane().add(BotaoCalcularIMC, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 490, 110, 40));

        BotaoLimpar.setBackground(new java.awt.Color(255, 255, 0));
        BotaoLimpar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        BotaoLimpar.setForeground(new java.awt.Color(0, 0, 0));
        BotaoLimpar.setText("LIMPAR");
        BotaoLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoLimparActionPerformed(evt);
            }
        });
        getContentPane().add(BotaoLimpar, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 500, 130, 30));

        ImagemFundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Academia02.jpg"))); // NOI18N
        getContentPane().add(ImagemFundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void calculaImc() {

        CalculaImc calcula = new CalculaImc();

        float imc = 0;
        float peso = 0;
        float altura = 0;

        peso = Float.parseFloat(txtPeso.getText());
        altura = Float.parseFloat(txtAltura.getText());

        imc = calcula.calculaImc(peso, altura);

        String resultado = String.valueOf(imc);

        txtResultado.setText(resultado);

    }

    public void limparCampos() {
        txtAltura.setText("");
        txtPeso.setText("");
        txtResultado.setText("");
    }

    private void BotaoVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoVoltarActionPerformed

        dispose();
        new JanelaSistema().setVisible(true);

    }//GEN-LAST:event_BotaoVoltarActionPerformed

    private void BotaoSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoSairActionPerformed
        System.exit(0);

    }//GEN-LAST:event_BotaoSairActionPerformed

    private void BotaoCalcularIMCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoCalcularIMCActionPerformed
        calculaImc();

    }//GEN-LAST:event_BotaoCalcularIMCActionPerformed

    private void BotaoLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoLimparActionPerformed

        limparCampos();

    }//GEN-LAST:event_BotaoLimparActionPerformed

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
            java.util.logging.Logger.getLogger(JanelaCalculaImc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JanelaCalculaImc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JanelaCalculaImc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JanelaCalculaImc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JanelaCalculaImc().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotaoCalcularIMC;
    private javax.swing.JButton BotaoLimpar;
    private javax.swing.JButton BotaoSair;
    private javax.swing.JButton BotaoVoltar;
    private javax.swing.JLabel CalculandoAltura;
    private javax.swing.JLabel CalculandoPeso;
    private javax.swing.JLabel ImagemFundo;
    private javax.swing.JLabel ImagemLogo;
    private javax.swing.JLabel Resultado;
    private javax.swing.JLabel TextoCalculandoIMC;
    private javax.swing.JTextField txtAltura;
    private javax.swing.JTextField txtPeso;
    private javax.swing.JTextField txtResultado;
    // End of variables declaration//GEN-END:variables
}
