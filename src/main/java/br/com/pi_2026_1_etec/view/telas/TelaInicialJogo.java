package br.com.pi_2026_1_etec.view.telas;

public class TelaInicialJogo extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(TelaInicialJogo.class.getName());

    public TelaInicialJogo() {
        initComponents();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButtonJogar = new javax.swing.JButton();
        jLabelTitulo1 = new javax.swing.JLabel();
        jLabelTitulo2 = new javax.swing.JLabel();
        jLabelSubtitulo = new javax.swing.JLabel();
        jLabelLogo = new javax.swing.JLabel();
        jLabelImagemFundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonJogar.setBackground(new java.awt.Color(7, 92, 110));
        jButtonJogar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonJogar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonJogar.setText("JOGAR");
        jButtonJogar.addActionListener(this::jButtonJogarActionPerformed);
        jPanel1.add(jButtonJogar, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 250, 140, 40));

        jLabelTitulo1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabelTitulo1.setForeground(new java.awt.Color(7, 92, 110));
        jLabelTitulo1.setText("O GRANDE DESAFIO");
        jPanel1.add(jLabelTitulo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, -1));

        jLabelTitulo2.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabelTitulo2.setForeground(new java.awt.Color(7, 92, 110));
        jLabelTitulo2.setText("DA QUÍMICA");
        jPanel1.add(jLabelTitulo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 130, -1, -1));

        jLabelSubtitulo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelSubtitulo.setText("Uma forma mais divertida de estudar Química");
        jPanel1.add(jLabelSubtitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, -1, -1));

        jLabelLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagensEtec/LogoCPS.png"))); // NOI18N
        jPanel1.add(jLabelLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 380, -1, -1));

        jLabelImagemFundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagensEtec/telaInicio.png"))); // NOI18N
        jLabelImagemFundo.setVerifyInputWhenFocusTarget(false);
        jPanel1.add(jLabelImagemFundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(-43, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonJogarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonJogarActionPerformed
       new TelaLogin().setVisible(true); // Exibe o que foi criado. Nesse caso, o objeto TelaLogin
       this.dispose(); // Método dispose encerra e destrói a janela de forma segura
    }//GEN-LAST:event_jButtonJogarActionPerformed
   
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
        java.awt.EventQueue.invokeLater(() -> new TelaInicialJogo().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonJogar;
    private javax.swing.JLabel jLabelImagemFundo;
    private javax.swing.JLabel jLabelLogo;
    private javax.swing.JLabel jLabelSubtitulo;
    private javax.swing.JLabel jLabelTitulo1;
    private javax.swing.JLabel jLabelTitulo2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
