package br.com.pi_2026_1_etec.view.telas;

import br.com.pi_2026_1_etec.controller.UsuarioService;
import br.com.pi_2026_1_etec.model.Usuario;

public class TelaCadastro extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(TelaCadastro.class.getName());

    public TelaCadastro() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        jPanelVermelho = new javax.swing.JPanel();
        jPanelAzul = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanelLogin = new javax.swing.JPanel();
        jLabelCadastro = new javax.swing.JLabel();
        jLabelNome = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jLabelEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabelSenha = new javax.swing.JLabel();
        txtSenha = new javax.swing.JPasswordField();
        jToggleButtonMostrarSenha = new javax.swing.JToggleButton();
        jLabelMostrarSenha = new javax.swing.JLabel();
        jButtonCriarConta = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLayeredPane1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelVermelho.setBackground(new java.awt.Color(146, 25, 19));

        javax.swing.GroupLayout jPanelVermelhoLayout = new javax.swing.GroupLayout(jPanelVermelho);
        jPanelVermelho.setLayout(jPanelVermelhoLayout);
        jPanelVermelhoLayout.setHorizontalGroup(
            jPanelVermelhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 775, Short.MAX_VALUE)
        );
        jPanelVermelhoLayout.setVerticalGroup(
            jPanelVermelhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 460, Short.MAX_VALUE)
        );

        jLayeredPane1.add(jPanelVermelho, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 775, 460));

        jPanelAzul.setBackground(new java.awt.Color(7, 92, 110));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagensEtec/LogoCPS.png"))); // NOI18N

        javax.swing.GroupLayout jPanelAzulLayout = new javax.swing.GroupLayout(jPanelAzul);
        jPanelAzul.setLayout(jPanelAzulLayout);
        jPanelAzulLayout.setHorizontalGroup(
            jPanelAzulLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAzulLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 266, Short.MAX_VALUE))
        );
        jPanelAzulLayout.setVerticalGroup(
            jPanelAzulLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelAzulLayout.createSequentialGroup()
                .addGap(0, 271, Short.MAX_VALUE)
                .addComponent(jLabel1))
        );

        jLayeredPane1.setLayer(jPanelAzul, javax.swing.JLayeredPane.PALETTE_LAYER);
        jLayeredPane1.add(jPanelAzul, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 390, 350));

        jPanelLogin.setBackground(new java.awt.Color(255, 255, 255));
        jPanelLogin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelCadastro.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        jLabelCadastro.setText("Cadastro");
        jPanelLogin.add(jLabelCadastro, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, -1, -1));

        jLabelNome.setText("Nome");
        jPanelLogin.add(jLabelNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, -1, -1));

        txtNome.setToolTipText("");
        jPanelLogin.add(txtNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 259, -1));

        jLabelEmail.setText("E-mail");
        jPanelLogin.add(jLabelEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, -1, -1));
        jPanelLogin.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 259, -1));

        jLabelSenha.setText("Senha");
        jPanelLogin.add(jLabelSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, -1, -1));
        jPanelLogin.add(txtSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, 259, -1));

        jToggleButtonMostrarSenha.addActionListener(this::jToggleButtonMostrarSenhaActionPerformed);
        jPanelLogin.add(jToggleButtonMostrarSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, 13, 13));

        jLabelMostrarSenha.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabelMostrarSenha.setText("Mostrar senha");
        jPanelLogin.add(jLabelMostrarSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 240, -1, -1));

        jButtonCriarConta.setBackground(new java.awt.Color(0, 0, 0));
        jButtonCriarConta.setForeground(new java.awt.Color(255, 255, 255));
        jButtonCriarConta.setText("Criar conta");
        jButtonCriarConta.addActionListener(this::jButtonCriarContaActionPerformed);
        jPanelLogin.add(jButtonCriarConta, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, 259, -1));

        jLayeredPane1.setLayer(jPanelLogin, javax.swing.JLayeredPane.MODAL_LAYER);
        jLayeredPane1.add(jPanelLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(217, 42, 340, 340));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jToggleButtonMostrarSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButtonMostrarSenhaActionPerformed
        if (jToggleButtonMostrarSenha.isSelected()) {
        txtSenha.setEchoChar((char) 0); 
    } else {
        txtSenha.setEchoChar('•'); 
    }
    }//GEN-LAST:event_jToggleButtonMostrarSenhaActionPerformed

    private void jButtonCriarContaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCriarContaActionPerformed
        TelaCadastro tela2 = new TelaCadastro();
        tela2.setVisible(true);
        
        String nome = txtNome.getText();
        String email = txtEmail.getText();
        String senha = new String(txtSenha.getPassword());
        
        Usuario novoUsuario = new Usuario(); 
        novoUsuario.setNome(nome);
        novoUsuario.setEmail(email);
        novoUsuario.setSenha(senha);
        
        UsuarioService service = new UsuarioService();
        //boolean sucesso = service.cadastrarUsuario(novoUsuario);
        
        if (nome.isEmpty() || email.isEmpty() || senha.isEmpty()) {
        javax.swing.JOptionPane.showMessageDialog(this, "Preencha todos os campos!"); }
        else { javax.swing.JOptionPane.showMessageDialog(this, "Cadastro realizado com sucesso!");}
       
        //if (sucesso) {
        //javax.swing.JOptionPane.showMessageDialog(this, "Cadastro realizado com sucesso!");
   // } else {
       // javax.swing.JOptionPane.showMessageDialog(this, "Erro ao cadastrar.");
   // }
            
    }//GEN-LAST:event_jButtonCriarContaActionPerformed

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
        java.awt.EventQueue.invokeLater(() -> new TelaCadastro().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCriarConta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelCadastro;
    private javax.swing.JLabel jLabelEmail;
    private javax.swing.JLabel jLabelMostrarSenha;
    private javax.swing.JLabel jLabelNome;
    private javax.swing.JLabel jLabelSenha;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanelAzul;
    private javax.swing.JPanel jPanelLogin;
    private javax.swing.JPanel jPanelVermelho;
    private javax.swing.JToggleButton jToggleButtonMostrarSenha;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNome;
    private javax.swing.JPasswordField txtSenha;
    // End of variables declaration//GEN-END:variables
}
