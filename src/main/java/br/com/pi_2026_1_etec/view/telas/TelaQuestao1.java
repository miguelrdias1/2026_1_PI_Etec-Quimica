package br.com.pi_2026_1_etec.view.telas;

import br.com.pi_2026_1_etec.dao.PerguntaDAO;
import br.com.pi_2026_1_etec.model.Alternativa;
import br.com.pi_2026_1_etec.model.Questao;

public class TelaQuestao1 extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger =
            java.util.logging.Logger.getLogger(TelaQuestao1.class.getName());

    public TelaQuestao1() {
        initComponents();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        jPanel1 = new javax.swing.JPanel();
        jButtonDica = new javax.swing.JButton();
        jLabelPergunta = new javax.swing.JLabel();
        jButtonA = new javax.swing.JButton();
        jButtonB = new javax.swing.JButton();
        jButtonC = new javax.swing.JButton();
        jButtonD = new javax.swing.JButton();
        jProgressBar1 = new javax.swing.JProgressBar();
        jLabelImagemPergunta = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLayeredPane1.setBackground(new java.awt.Color(255, 255, 255));
        jLayeredPane1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonDica.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagensEtec/Dica.png"))); // NOI18N
        jButtonDica.addActionListener(this::jButtonDicaActionPerformed);
        jPanel1.add(jButtonDica, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 10, 36, 36));

        jLabelPergunta.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabelPergunta.setText("Pergunta");
        jLabelPergunta.setToolTipText("");
        jPanel1.add(jLabelPergunta, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jButtonA.setBackground(new java.awt.Color(7, 92, 110));
        jButtonA.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButtonA.setForeground(new java.awt.Color(255, 255, 255));
        jButtonA.setText("Alternativa A");
        jPanel1.add(jButtonA, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 280, 250, 80));

        jButtonB.setBackground(new java.awt.Color(7, 92, 110));
        jButtonB.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButtonB.setForeground(new java.awt.Color(255, 255, 255));
        jButtonB.setText("Alternativa B");
        jPanel1.add(jButtonB, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 280, 250, 80));

        jButtonC.setBackground(new java.awt.Color(7, 92, 110));
        jButtonC.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButtonC.setForeground(new java.awt.Color(255, 255, 255));
        jButtonC.setText("Alternativa C");
        jPanel1.add(jButtonC, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 370, 250, 80));

        jButtonD.setBackground(new java.awt.Color(7, 92, 110));
        jButtonD.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButtonD.setForeground(new java.awt.Color(255, 255, 255));
        jButtonD.setText("Alternativa D");
        jPanel1.add(jButtonD, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 370, 250, 80));
        jPanel1.add(jProgressBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 260, 510, 10));

        jLabelImagemPergunta.setText("Imagem");
        jLabelImagemPergunta.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jPanel1.add(jLabelImagemPergunta, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, 240, 240));

        jLayeredPane1.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 775, 460));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 775, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonDicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDicaActionPerformed
       
    }//GEN-LAST:event_jButtonDicaActionPerformed

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
        java.awt.EventQueue.invokeLater(() -> new TelaQuestao1().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonA;
    private javax.swing.JButton jButtonB;
    private javax.swing.JButton jButtonC;
    private javax.swing.JButton jButtonD;
    private javax.swing.JButton jButtonDica;
    private javax.swing.JLabel jLabelImagemPergunta;
    private javax.swing.JLabel jLabelPergunta;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JProgressBar jProgressBar1;
    // End of variables declaration//GEN-END:variables
}
