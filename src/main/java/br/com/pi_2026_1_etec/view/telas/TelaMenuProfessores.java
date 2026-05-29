package br.com.pi_2026_1_etec.view.telas;

import br.com.pi_2026_1_etec.model.Sessao;
import br.com.pi_2026_1_etec.dao.AlunoDAO;
import javax.swing.JOptionPane;

public class TelaMenuProfessores extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(TelaMenuProfessores.class.getName());
    private AlunoDAO alunoDAO = new AlunoDAO();

   public TelaMenuProfessores() {
        initComponents();
        atualizarAlunosAtivos();
        
        if (!Sessao.estaLogado()) {
            JOptionPane.showMessageDialog(this, "Faça login para acessar.");
            new TelaLogin().setVisible(true);
            this.dispose();
        }
        
        jPanelTitulo3.setBackground(new java.awt.Color(7, 92, 110, 15));
        jPanelTitulo3.setOpaque(true);
        
        jPanelTitulo3_2.setBackground(new java.awt.Color(146, 25, 19, 15));
        jPanelTitulo3_2.setOpaque(true);
    }
    private void atualizarAlunosAtivos() {
        int total = alunoDAO.contarAlunosAtivos();
        jLabelSubtitulo2.setText("Alunos ativos: " + total);
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        jPanel1 = new javax.swing.JPanel();
        jLabelTitulo = new javax.swing.JLabel();
        jLabelSubtitulo = new javax.swing.JLabel();
        jLabelTitulo2 = new javax.swing.JLabel();
        jLabelTitulo3 = new javax.swing.JLabel();
        jPanelTitulo2 = new javax.swing.JPanel();
        jLabelSubtitulo2 = new javax.swing.JLabel();
        jLabelDescricao2 = new javax.swing.JLabel();
        jPanelTitulo3 = new javax.swing.JPanel();
        jLabelSubtitulo3 = new javax.swing.JLabel();
        jLabelDescricao3 = new javax.swing.JLabel();
        jLabelDescricao3Parte2 = new javax.swing.JLabel();
        jButtonGerenciarAlunos = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanelTitulo3_2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButtonGerenciamentoDePerguntas = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButtonLogout = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLayeredPane1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(248, 249, 252));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelTitulo.setBackground(new java.awt.Color(248, 249, 252));
        jLabelTitulo.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        jLabelTitulo.setText("Olá, Professor(a)!");
        jPanel1.add(jLabelTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        jLabelSubtitulo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelSubtitulo.setText("Bem-vindo ao painel de O Grande Desafio da Química.");
        jPanel1.add(jLabelSubtitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        jLabelTitulo2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabelTitulo2.setText("Resumo rápido");
        jPanel1.add(jLabelTitulo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 92, -1, -1));

        jLabelTitulo3.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabelTitulo3.setText("O que você deseja gerenciar?");
        jPanel1.add(jLabelTitulo3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, -1, -1));

        jPanelTitulo2.setBackground(new java.awt.Color(255, 255, 255));
        jPanelTitulo2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jLabelSubtitulo2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelSubtitulo2.setText("Alunos ativos");

        jLabelDescricao2.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabelDescricao2.setText("Alunos que jogaram nos últimos 7 dias");

        javax.swing.GroupLayout jPanelTitulo2Layout = new javax.swing.GroupLayout(jPanelTitulo2);
        jPanelTitulo2.setLayout(jPanelTitulo2Layout);
        jPanelTitulo2Layout.setHorizontalGroup(
            jPanelTitulo2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTitulo2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanelTitulo2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelDescricao2)
                    .addComponent(jLabelSubtitulo2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelTitulo2Layout.setVerticalGroup(
            jPanelTitulo2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTitulo2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabelSubtitulo2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addComponent(jLabelDescricao2)
                .addContainerGap())
        );

        jPanel1.add(jPanelTitulo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 120, 365, 110));

        jPanelTitulo3.setBackground(new java.awt.Color(255, 255, 255));
        jPanelTitulo3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(7, 92, 110)));

        jLabelSubtitulo3.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabelSubtitulo3.setForeground(new java.awt.Color(7, 92, 110));
        jLabelSubtitulo3.setText("Alunos");

        jLabelDescricao3.setText("Gerencie seus alunos, visualize desempenhos e acompanhe o");

        jLabelDescricao3Parte2.setText("progresso no jogo.");

        jButtonGerenciarAlunos.setBackground(new java.awt.Color(7, 92, 110));
        jButtonGerenciarAlunos.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButtonGerenciarAlunos.setForeground(new java.awt.Color(255, 255, 255));
        jButtonGerenciarAlunos.setText("Gerenciar alunos");
        jButtonGerenciarAlunos.addActionListener(this::jButtonGerenciarAlunosActionPerformed);

        javax.swing.GroupLayout jPanelTitulo3Layout = new javax.swing.GroupLayout(jPanelTitulo3);
        jPanelTitulo3.setLayout(jPanelTitulo3Layout);
        jPanelTitulo3Layout.setHorizontalGroup(
            jPanelTitulo3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTitulo3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanelTitulo3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelDescricao3Parte2)
                    .addComponent(jLabelSubtitulo3)
                    .addComponent(jLabelDescricao3, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonGerenciarAlunos, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanelTitulo3Layout.setVerticalGroup(
            jPanelTitulo3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTitulo3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabelSubtitulo3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelDescricao3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelDescricao3Parte2)
                .addGap(18, 18, 18)
                .addComponent(jButtonGerenciarAlunos, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanelTitulo3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, -1, 160));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("Perguntas ativas");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel10.setText("Perguntas disponíveis no sistema");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jLabel8))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addContainerGap())
        );

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 120, 351, 110));

        jPanelTitulo3_2.setBackground(new java.awt.Color(255, 255, 255));
        jPanelTitulo3_2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(146, 25, 19)));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(126, 25, 19));
        jLabel1.setText("Perguntas");

        jLabel4.setText("Crie, edite e gerencie perguntas do jogo.");

        jLabel6.setText("Organize por temas e níveis de dificuldade.");

        jButtonGerenciamentoDePerguntas.setBackground(new java.awt.Color(146, 25, 19));
        jButtonGerenciamentoDePerguntas.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButtonGerenciamentoDePerguntas.setForeground(new java.awt.Color(255, 255, 255));
        jButtonGerenciamentoDePerguntas.setText("Gerenciar perguntas");
        jButtonGerenciamentoDePerguntas.addActionListener(this::jButtonGerenciamentoDePerguntasActionPerformed);

        javax.swing.GroupLayout jPanelTitulo3_2Layout = new javax.swing.GroupLayout(jPanelTitulo3_2);
        jPanelTitulo3_2.setLayout(jPanelTitulo3_2Layout);
        jPanelTitulo3_2Layout.setHorizontalGroup(
            jPanelTitulo3_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTitulo3_2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanelTitulo3_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonGerenciamentoDePerguntas, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanelTitulo3_2Layout.setVerticalGroup(
            jPanelTitulo3_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTitulo3_2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(jButtonGerenciamentoDePerguntas, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jPanel1.add(jPanelTitulo3_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 280, -1, -1));
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 54, -1, -1));

        jButtonLogout.setBackground(new java.awt.Color(195, 16, 12));
        jButtonLogout.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButtonLogout.setForeground(new java.awt.Color(255, 255, 255));
        jButtonLogout.setText("Logout");
        jButtonLogout.addActionListener(this::jButtonLogoutActionPerformed);
        jPanel1.add(jButtonLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 10, -1, 30));

        jLayeredPane1.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 775, 460));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 775, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonGerenciarAlunosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGerenciarAlunosActionPerformed
        new TelaGerenciarAlunos().setVisible(true); // Exibe o que foi criado. Nesse caso, o objeto TelaGerenciarAlunos
        this.dispose(); // Método dispose encerra e destrói a janela de forma segura
    }//GEN-LAST:event_jButtonGerenciarAlunosActionPerformed

    private void jButtonGerenciamentoDePerguntasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGerenciamentoDePerguntasActionPerformed
        new TelaGerenciamentoDePergunta().setVisible(true); //Exibe o que foi criado. Nesse caso, o objeto TelaGerenciamentoDePerguntas
        this.dispose(); // Método dispose encerra e destrói a janela de forma segura
    }//GEN-LAST:event_jButtonGerenciamentoDePerguntasActionPerformed

    private void jButtonLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLogoutActionPerformed
        Sessao.logout();               
        new TelaLogin().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonLogoutActionPerformed

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
        java.awt.EventQueue.invokeLater(() -> new TelaMenuProfessores().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonGerenciamentoDePerguntas;
    private javax.swing.JButton jButtonGerenciarAlunos;
    private javax.swing.JButton jButtonLogout;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabelDescricao2;
    private javax.swing.JLabel jLabelDescricao3;
    private javax.swing.JLabel jLabelDescricao3Parte2;
    private javax.swing.JLabel jLabelSubtitulo;
    private javax.swing.JLabel jLabelSubtitulo2;
    private javax.swing.JLabel jLabelSubtitulo3;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JLabel jLabelTitulo2;
    private javax.swing.JLabel jLabelTitulo3;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanelTitulo2;
    private javax.swing.JPanel jPanelTitulo3;
    private javax.swing.JPanel jPanelTitulo3_2;
    // End of variables declaration//GEN-END:variables
}
