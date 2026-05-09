package br.com.pi_2026_1_etec.view.telas;


public class TelaLogin extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(TelaLogin.class.getName());
        
    public TelaLogin() {
        initComponents();
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        jPanelFundoAzul = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanelFundoVermelho = new javax.swing.JPanel();
        jPanelFundoLogin = new javax.swing.JPanel();
        jLabelLogin = new javax.swing.JLabel();
        jLabelEmail = new javax.swing.JLabel();
        jTextFieldEmail = new javax.swing.JTextField();
        jLabelSenha = new javax.swing.JLabel();
        txtSenha = new javax.swing.JPasswordField();
        mostrarSenha = new javax.swing.JToggleButton();
        jLabelMostrarSenha = new javax.swing.JLabel();
        entrar = new javax.swing.JButton();
        jButtonRedirecionamentoCadastro = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLayeredPane1.setPreferredSize(new java.awt.Dimension(775, 460));
        jLayeredPane1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelFundoAzul.setBackground(new java.awt.Color(7, 92, 110));
        jPanelFundoAzul.setPreferredSize(new java.awt.Dimension(132, 79));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagensEtec/LogoCPS.png"))); // NOI18N

        javax.swing.GroupLayout jPanelFundoAzulLayout = new javax.swing.GroupLayout(jPanelFundoAzul);
        jPanelFundoAzul.setLayout(jPanelFundoAzulLayout);
        jPanelFundoAzulLayout.setHorizontalGroup(
            jPanelFundoAzulLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFundoAzulLayout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 258, Short.MAX_VALUE))
        );
        jPanelFundoAzulLayout.setVerticalGroup(
            jPanelFundoAzulLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelFundoAzulLayout.createSequentialGroup()
                .addGap(0, 271, Short.MAX_VALUE)
                .addComponent(jLabel1))
        );

        jLayeredPane1.add(jPanelFundoAzul, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 390, 350));

        jPanelFundoVermelho.setBackground(new java.awt.Color(146, 25, 19));
        jPanelFundoVermelho.setPreferredSize(new java.awt.Dimension(775, 460));

        javax.swing.GroupLayout jPanelFundoVermelhoLayout = new javax.swing.GroupLayout(jPanelFundoVermelho);
        jPanelFundoVermelho.setLayout(jPanelFundoVermelhoLayout);
        jPanelFundoVermelhoLayout.setHorizontalGroup(
            jPanelFundoVermelhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 775, Short.MAX_VALUE)
        );
        jPanelFundoVermelhoLayout.setVerticalGroup(
            jPanelFundoVermelhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 460, Short.MAX_VALUE)
        );

        jLayeredPane1.add(jPanelFundoVermelho, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 460));

        jPanelFundoLogin.setBackground(new java.awt.Color(255, 255, 255));
        jPanelFundoLogin.setForeground(new java.awt.Color(255, 255, 255));
        jPanelFundoLogin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelLogin.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        jLabelLogin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelLogin.setText("Login");
        jLabelLogin.setAlignmentX(170.0F);
        jLabelLogin.setAlignmentY(160.0F);
        jPanelFundoLogin.add(jLabelLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 30, -1, -1));

        jLabelEmail.setText("E-mail");
        jPanelFundoLogin.add(jLabelEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, -1, -1));
        jPanelFundoLogin.add(jTextFieldEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 259, -1));

        jLabelSenha.setText("Senha");
        jPanelFundoLogin.add(jLabelSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, -1, -1));
        jPanelFundoLogin.add(txtSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 259, -1));

        mostrarSenha.addActionListener(this::mostrarSenhaActionPerformed);
        jPanelFundoLogin.add(mostrarSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 13, 13));

        jLabelMostrarSenha.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabelMostrarSenha.setText("Mostrar senha");
        jPanelFundoLogin.add(jLabelMostrarSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, -1, -1));

        entrar.setBackground(new java.awt.Color(0, 0, 0));
        entrar.setForeground(new java.awt.Color(255, 255, 255));
        entrar.setText("Entrar");
        entrar.addActionListener(this::entrarActionPerformed);
        jPanelFundoLogin.add(entrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 225, 259, -1));

        jButtonRedirecionamentoCadastro.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jButtonRedirecionamentoCadastro.setForeground(new java.awt.Color(0, 51, 255));
        jButtonRedirecionamentoCadastro.setText("Ainda não possui login? Faça o cadastro aqui");
        jButtonRedirecionamentoCadastro.setBorder(null);
        jButtonRedirecionamentoCadastro.addActionListener(this::jButtonRedirecionamentoCadastroActionPerformed);
        jPanelFundoLogin.add(jButtonRedirecionamentoCadastro, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 250, -1, -1));

        jLayeredPane1.setLayer(jPanelFundoLogin, javax.swing.JLayeredPane.MODAL_LAYER);
        jLayeredPane1.add(jPanelFundoLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(217, 70, 340, 320));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void entrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_entrarActionPerformed
                                                  
    String email = entrar.getText();
    String senha = new String(txtSenha.getPassword());

    // Apenas simulacao de banco de dados enquanto isso
    if (email.equals("exemplo@email.com") && senha.equals("1234")) {
        javax.swing.JOptionPane.showMessageDialog(this, "Login realizado com sucesso.");
 } else {
        javax.swing.JOptionPane.showMessageDialog(this, "E-mail ou senha incorretos.", "Erro", javax.swing.JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_entrarActionPerformed

    private void mostrarSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mostrarSenhaActionPerformed
        if (mostrarSenha.isSelected()) {
        txtSenha.setEchoChar((char) 0); 
    } else {
        txtSenha.setEchoChar('•'); 
    }
    }//GEN-LAST:event_mostrarSenhaActionPerformed

    private void jButtonRedirecionamentoCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRedirecionamentoCadastroActionPerformed
        new TelaCadastro().setVisible(true); // Exibe o que foi criado. Nesse caso, o objeto TelaCadastro
        this.dispose(); // Método dispose encerra e destrói a janela de forma segura 
    }//GEN-LAST:event_jButtonRedirecionamentoCadastroActionPerformed

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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new TelaLogin().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton entrar;
    private javax.swing.JButton jButtonRedirecionamentoCadastro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelEmail;
    private javax.swing.JLabel jLabelLogin;
    private javax.swing.JLabel jLabelMostrarSenha;
    private javax.swing.JLabel jLabelSenha;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanelFundoAzul;
    private javax.swing.JPanel jPanelFundoLogin;
    private javax.swing.JPanel jPanelFundoVermelho;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JToggleButton mostrarSenha;
    private javax.swing.JPasswordField txtSenha;
    // End of variables declaration//GEN-END:variables
}
