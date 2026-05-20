package br.com.pi_2026_1_etec.view.telas;

import java.awt.Image;
import javax.swing.ImageIcon;
import com.formdev.flatlaf.extras.FlatSVGIcon;


public class TelaMenuAlunos extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(TelaMenuAlunos.class.getName());

    
    public TelaMenuAlunos() {
        initComponents();
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        pnlTelaMenu = new javax.swing.JPanel();
        pnlconfig = new javax.swing.JPanel();
        btnLogout = new javax.swing.JButton();
        btnfechar = new javax.swing.JButton();
        btnVolume = new javax.swing.JSlider();
        jLabel9 = new javax.swing.JLabel();
        btnFacil = new javax.swing.JButton();
        btnMedio = new javax.swing.JButton();
        btnDificil = new javax.swing.JButton();
        btnRandom = new javax.swing.JButton();
        btnconfig = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        menu = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLayeredPane1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlTelaMenu.setBackground(new java.awt.Color(255, 255, 255));
        pnlTelaMenu.setPreferredSize(new java.awt.Dimension(775, 460));
        pnlTelaMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlconfig.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnLogout.setBackground(new java.awt.Color(195, 16, 12));
        btnLogout.setForeground(new java.awt.Color(255, 255, 255));
        btnLogout.setText("Logout");
        btnLogout.addActionListener(this::btnLogoutActionPerformed);
        pnlconfig.add(btnLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 100, 30));

        btnfechar.setText("Fechar");
        btnfechar.addActionListener(this::btnfecharActionPerformed);
        pnlconfig.add(btnfechar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, 100, 30));

        btnVolume.addChangeListener(this::btnVolumeStateChanged);
        pnlconfig.add(btnVolume, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 160, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("Volume");
        pnlconfig.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 80, 30));

        pnlTelaMenu.add(pnlconfig, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 30, 180, 210));

        btnFacil.setBackground(new java.awt.Color(7, 92, 110));
        btnFacil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagensEtec/nivelFacil.png"))); // NOI18N
        btnFacil.addActionListener(this::btnFacilActionPerformed);
        pnlTelaMenu.add(btnFacil, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, 116, 180));

        btnMedio.setBackground(new java.awt.Color(56, 69, 79));
        btnMedio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagensEtec/nivelMedio.png"))); // NOI18N
        btnMedio.addActionListener(this::btnMedioActionPerformed);
        pnlTelaMenu.add(btnMedio, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 90, 116, 180));

        btnDificil.setBackground(new java.awt.Color(107, 44, 45));
        btnDificil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagensEtec/nivelDificil.png"))); // NOI18N
        pnlTelaMenu.add(btnDificil, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 90, 116, 180));

        btnRandom.setBackground(new java.awt.Color(146, 25, 19));
        btnRandom.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagensEtec/nivelRandom.png"))); // NOI18N
        pnlTelaMenu.add(btnRandom, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 90, 116, 180));

        btnconfig.setBackground(new java.awt.Color(195, 16, 12));
        btnconfig.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagensEtec/Config.png"))); // NOI18N
        btnconfig.addActionListener(this::btnconfigActionPerformed);
        pnlTelaMenu.add(btnconfig, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 350, 41, 42));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagensEtec/menu.png"))); // NOI18N
        pnlTelaMenu.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 350, -1, -1));

        jLabel2.setBackground(new java.awt.Color(10, 141, 168));
        jLabel2.setOpaque(true);
        pnlTelaMenu.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 320, 80, 101));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Como funciona o jogo?");
        pnlTelaMenu.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 330, -1, -1));

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("possui mais dificuldade!");
        jLabel5.setToolTipText("");
        jLabel5.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        pnlTelaMenu.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 394, 280, -1));

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("Selecione uma das dificuldades acima e pratique");
        jLabel6.setToolTipText("");
        jLabel6.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        pnlTelaMenu.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 356, 270, -1));

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("o quanto quiser! Seu resultado será guardado");
        jLabel7.setToolTipText("");
        jLabel7.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        pnlTelaMenu.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 370, 280, -1));

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setText("para que você possa analisar questões que você");
        jLabel8.setToolTipText("");
        jLabel8.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        pnlTelaMenu.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 380, 280, 20));

        menu.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        menu.setText("Menu");
        pnlTelaMenu.add(menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 10, 150, 70));

        jLayeredPane1.add(pnlTelaMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(jLayeredPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMedioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMedioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnMedioActionPerformed

    private void btnconfigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnconfigActionPerformed
        
        pnlconfig.setVisible(true);

    }//GEN-LAST:event_btnconfigActionPerformed

    private void btnFacilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFacilActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnFacilActionPerformed

    private void btnfecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnfecharActionPerformed
        pnlconfig.setVisible(false);
    }//GEN-LAST:event_btnfecharActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void btnVolumeStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_btnVolumeStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_btnVolumeStateChanged

    
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
        java.awt.EventQueue.invokeLater(() -> new TelaMenuAlunos().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDificil;
    private javax.swing.JButton btnFacil;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnMedio;
    private javax.swing.JButton btnRandom;
    private javax.swing.JSlider btnVolume;
    private javax.swing.JButton btnconfig;
    private javax.swing.JButton btnfechar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLabel menu;
    private javax.swing.JPanel pnlTelaMenu;
    private javax.swing.JPanel pnlconfig;
    // End of variables declaration//GEN-END:variables
}
