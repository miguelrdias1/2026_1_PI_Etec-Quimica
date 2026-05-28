package br.com.pi_2026_1_etec.view.telas;

import br.com.pi_2026_1_etec.repository.UsuarioRepository;
import br.com.pi_2026_1_etec.model.Usuario;
import br.com.pi_2026_1_etec.model.Sessao;

public class TelaLogin extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(TelaLogin.class.getName());
        
    public TelaLogin() {
        initComponents();
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        jPanelFundoBranco = new javax.swing.JPanel();
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
        jLabel2 = new javax.swing.JLabel();
        jPanelFundoAzul = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLayeredPane1.setPreferredSize(new java.awt.Dimension(775, 460));
        jLayeredPane1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelFundoBranco.setBackground(new java.awt.Color(255, 255, 255));
        jPanelFundoBranco.setPreferredSize(new java.awt.Dimension(775, 460));

        jPanelFundoLogin.setBackground(new java.awt.Color(255, 255, 255));
        jPanelFundoLogin.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanelFundoLogin.setForeground(new java.awt.Color(255, 255, 255));
        jPanelFundoLogin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelLogin.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        jLabelLogin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelLogin.setText("Faça seu login");
        jLabelLogin.setAlignmentX(170.0F);
        jLabelLogin.setAlignmentY(160.0F);
        jPanelFundoLogin.add(jLabelLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, -1, -1));

        jLabelEmail.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelEmail.setText("E-mail");
        jPanelFundoLogin.add(jLabelEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, -1, -1));
        jPanelFundoLogin.add(jTextFieldEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 259, -1));

        jLabelSenha.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelSenha.setText("Senha");
        jPanelFundoLogin.add(jLabelSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, -1, -1));
        jPanelFundoLogin.add(txtSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 259, -1));

        mostrarSenha.addActionListener(this::mostrarSenhaActionPerformed);
        jPanelFundoLogin.add(mostrarSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 13, 13));

        jLabelMostrarSenha.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabelMostrarSenha.setText("Mostrar senha");
        jPanelFundoLogin.add(jLabelMostrarSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 220, -1, -1));

        entrar.setBackground(new java.awt.Color(7, 92, 110));
        entrar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        entrar.setForeground(new java.awt.Color(255, 255, 255));
        entrar.setText("Entrar");
        entrar.addActionListener(this::entrarActionPerformed);
        jPanelFundoLogin.add(entrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, 259, -1));

        jButtonRedirecionamentoCadastro.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jButtonRedirecionamentoCadastro.setText("Ainda não possui login? Faça o cadastro aqui");
        jButtonRedirecionamentoCadastro.setBorder(null);
        jButtonRedirecionamentoCadastro.addActionListener(this::jButtonRedirecionamentoCadastroActionPerformed);
        jPanelFundoLogin.add(jButtonRedirecionamentoCadastro, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 310, -1, -1));

        jLabel2.setForeground(new java.awt.Color(153, 153, 153));
        jLabel2.setText("Use suas credenciais para continuar");
        jPanelFundoLogin.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 60, -1, -1));

        jPanelFundoAzul.setBackground(new java.awt.Color(7, 92, 110));
        jPanelFundoAzul.setPreferredSize(new java.awt.Dimension(132, 79));
        jPanelFundoAzul.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 180, 220));
        jLabel3.setText("O GRANDE");
        jPanelFundoAzul.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("DESAFIO");
        jPanelFundoAzul.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 180, 220));
        jLabel5.setText("DA QUÍMICA");
        jPanelFundoAzul.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Bem-vindo(a)!");
        jPanelFundoAzul.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, -1, -1));

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Entre para acessar a experiência que transforma");
        jPanelFundoAzul.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, -1, -1));

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("conhecimento em desafio.");
        jPanelFundoAzul.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, -1, -1));
        jPanelFundoAzul.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, -1, -1));

        javax.swing.GroupLayout jPanelFundoBrancoLayout = new javax.swing.GroupLayout(jPanelFundoBranco);
        jPanelFundoBranco.setLayout(jPanelFundoBrancoLayout);
        jPanelFundoBrancoLayout.setHorizontalGroup(
            jPanelFundoBrancoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelFundoBrancoLayout.createSequentialGroup()
                .addComponent(jPanelFundoAzul, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                .addComponent(jPanelFundoLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63))
        );
        jPanelFundoBrancoLayout.setVerticalGroup(
            jPanelFundoBrancoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFundoBrancoLayout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jPanelFundoLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanelFundoBrancoLayout.createSequentialGroup()
                .addComponent(jPanelFundoAzul, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jLayeredPane1.add(jPanelFundoBranco, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 460));

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
    String email = jTextFieldEmail.getText(); // Pega o e-mail preenchido no campo
    String senha = new String(txtSenha.getPassword()); // Pega a senha preenchida no campo

    if (email.isBlank() || senha.isBlank()) { // Verifica se os campos de e-mail e senha estão vazios
        javax.swing.JOptionPane.showMessageDialog(this, "Preencha todos os campos!", "Aviso", javax.swing.JOptionPane.WARNING_MESSAGE);
        return;
    }
    
    try { 
        UsuarioRepository repository = new UsuarioRepository();

        Usuario aluno = repository.buscarAlunoPorEmail(email); // Busca o aluno pelo e-mail através do método buscarAlunoPorEmail criado na classe UsuarioRepository
        if (aluno != null && aluno.getSenha().equals(senha)) { // Compara a senha e decide o que fazer
        Sessao.login(aluno); 
        new TelaMenuAlunos().setVisible(true);
        this.dispose();
        return;
        }

        Usuario professor = repository.buscarProfessorPorEmail(email);
        if (professor != null && professor.getSenha().equals(senha)) {
        Sessao.login(professor); // 🔑 salva o usuário logado
        new TelaMenuProfessores().setVisible(true);
        this.dispose();
        return;
        }

        javax.swing.JOptionPane.showMessageDialog(this, "E-mail ou senha incorretos.", "Erro", javax.swing.JOptionPane.ERROR_MESSAGE);

    } catch (Exception e) {
        javax.swing.JOptionPane.showMessageDialog(this, "Erro ao conectar: " + e.getMessage(), "Erro", javax.swing.JOptionPane.ERROR_MESSAGE);
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabelEmail;
    private javax.swing.JLabel jLabelLogin;
    private javax.swing.JLabel jLabelMostrarSenha;
    private javax.swing.JLabel jLabelSenha;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanelFundoAzul;
    private javax.swing.JPanel jPanelFundoBranco;
    private javax.swing.JPanel jPanelFundoLogin;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JToggleButton mostrarSenha;
    private javax.swing.JPasswordField txtSenha;
    // End of variables declaration//GEN-END:variables
}
