package br.com.pi_2026_1_etec.view.telas;

public class TelaQuestão2 extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(TelaQuestão2.class.getName());

    public TelaQuestão2() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jPanel1 = new javax.swing.JPanel();
        jButtonImagemAlternativaC = new javax.swing.JButton();
        jButtonImagemAlternativaA = new javax.swing.JButton();
        jButtonImagemAlternativaB = new javax.swing.JButton();
        jLabelPergunta = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jProgressBar1 = new javax.swing.JProgressBar();
        jButtonDica = new javax.swing.JButton();

        jLabel4.setText("Alternativa A");
        jLabel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(7, 92, 110)));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLayeredPane1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonImagemAlternativaC.setBackground(new java.awt.Color(7, 92, 110));
        jButtonImagemAlternativaC.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButtonImagemAlternativaC.setForeground(new java.awt.Color(255, 255, 255));
        jButtonImagemAlternativaC.setText("Alternativa C");
        jButtonImagemAlternativaC.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(7, 92, 110)));
        jPanel1.add(jButtonImagemAlternativaC, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 210, 240, 240));

        jButtonImagemAlternativaA.setBackground(new java.awt.Color(7, 92, 110));
        jButtonImagemAlternativaA.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButtonImagemAlternativaA.setForeground(new java.awt.Color(255, 255, 255));
        jButtonImagemAlternativaA.setText("Alternativa A");
        jButtonImagemAlternativaA.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(7, 92, 110)));
        jButtonImagemAlternativaA.addActionListener(this::jButtonImagemAlternativaAActionPerformed);
        jPanel1.add(jButtonImagemAlternativaA, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 240, 240));

        jButtonImagemAlternativaB.setBackground(new java.awt.Color(7, 92, 110));
        jButtonImagemAlternativaB.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButtonImagemAlternativaB.setForeground(new java.awt.Color(255, 255, 255));
        jButtonImagemAlternativaB.setText("Alternativa B");
        jButtonImagemAlternativaB.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(7, 92, 110)));
        jButtonImagemAlternativaB.addActionListener(this::jButtonImagemAlternativaBActionPerformed);
        jPanel1.add(jButtonImagemAlternativaB, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 210, 240, 240));

        jLabelPergunta.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabelPergunta.setText("Pergunta");
        jPanel1.add(jLabelPergunta, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 10, -1, -1));

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagensEtec/Dica.png"))); // NOI18N
        jButton5.addActionListener(this::jButton5ActionPerformed);
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 20, 36, 36));
        jPanel1.add(jProgressBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 740, 10));

        jButtonDica.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagensEtec/Dica.png"))); // NOI18N
        jPanel1.add(jButtonDica, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 10, 36, 36));

        jLayeredPane1.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 775, 460));

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

    private void jButtonImagemAlternativaAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonImagemAlternativaAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonImagemAlternativaAActionPerformed

    private void jButtonImagemAlternativaBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonImagemAlternativaBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonImagemAlternativaBActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new TelaQuestão2().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButtonDica;
    private javax.swing.JButton jButtonImagemAlternativaA;
    private javax.swing.JButton jButtonImagemAlternativaB;
    private javax.swing.JButton jButtonImagemAlternativaC;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelPergunta;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JProgressBar jProgressBar1;
    // End of variables declaration//GEN-END:variables
}
