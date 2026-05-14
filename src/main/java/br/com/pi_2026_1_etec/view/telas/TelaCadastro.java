package br.com.pi_2026_1_etec.view.telas;

import javax.swing.JOptionPane;

import br.com.pi_2026_1_etec.controller.UsuarioController;
import br.com.pi_2026_1_etec.model.Usuario;
import br.com.pi_2026_1_etec.service.UsuarioService;

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
        jLabel1 = new javax.swing.JLabel();
        jPanelAzul = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLayeredPane1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelVermelho.setBackground(new java.awt.Color(255, 255, 255));

        jPanelLogin.setBackground(new java.awt.Color(255, 255, 255));
        jPanelLogin.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanelLogin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelCadastro.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        jLabelCadastro.setText("Faça seu cadastro");
        jPanelLogin.add(jLabelCadastro, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, -1, -1));

        jLabelNome.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelNome.setText("Nome");
        jPanelLogin.add(jLabelNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, -1, -1));

        txtNome.setToolTipText("");
        jPanelLogin.add(txtNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 259, -1));

        jLabelEmail.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelEmail.setText("E-mail");
        jPanelLogin.add(jLabelEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, -1, -1));

        txtEmail.addActionListener(this::txtEmailActionPerformed);
        jPanelLogin.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 259, -1));

        jLabelSenha.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelSenha.setText("Senha");
        jPanelLogin.add(jLabelSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, -1, -1));
        jPanelLogin.add(txtSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, 259, -1));

        jToggleButtonMostrarSenha.addActionListener(this::jToggleButtonMostrarSenhaActionPerformed);
        jPanelLogin.add(jToggleButtonMostrarSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, 13, 13));

        jLabelMostrarSenha.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabelMostrarSenha.setText("Mostrar senha");
        jPanelLogin.add(jLabelMostrarSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 280, -1, -1));

        jButtonCriarConta.setBackground(new java.awt.Color(146, 25, 19));
        jButtonCriarConta.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButtonCriarConta.setForeground(new java.awt.Color(255, 255, 255));
        jButtonCriarConta.setText("Criar conta");
        jButtonCriarConta.addActionListener(this::jButtonCriarContaActionPerformed);
        jPanelLogin.add(jButtonCriarConta, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 330, 259, -1));

        jLabel1.setForeground(new java.awt.Color(153, 153, 153));
        jLabel1.setText("Informe as suas credenciais para continuar");
        jPanelLogin.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, 250, -1));

        javax.swing.GroupLayout jPanelVermelhoLayout = new javax.swing.GroupLayout(jPanelVermelho);
        jPanelVermelho.setLayout(jPanelVermelhoLayout);
        jPanelVermelhoLayout.setHorizontalGroup(
            jPanelVermelhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelVermelhoLayout.createSequentialGroup()
                .addContainerGap(373, Short.MAX_VALUE)
                .addComponent(jPanelLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62))
        );
        jPanelVermelhoLayout.setVerticalGroup(
            jPanelVermelhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelVermelhoLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jPanelLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        jLayeredPane1.add(jPanelVermelho, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 775, 460));

        jPanelAzul.setBackground(new java.awt.Color(146, 25, 19));
        jPanelAzul.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(230, 65, 55));
        jLabel3.setText("O GRANDE");
        jPanelAzul.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("DESAFIO");
        jPanelAzul.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(230, 65, 55));
        jLabel4.setText("DA QUÍMICA");
        jPanelAzul.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Bem-vindo(a)!");
        jPanelAzul.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, -1, -1));

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Cadastre-se para acessar a experiência que");
        jPanelAzul.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, -1, -1));

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("transforma conhecimento em desafio.");
        jPanelAzul.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, -1, -1));

        jLayeredPane1.setLayer(jPanelAzul, javax.swing.JLayeredPane.PALETTE_LAYER);
        jLayeredPane1.add(jPanelAzul, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 310, 460));

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

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailActionPerformed

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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
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
