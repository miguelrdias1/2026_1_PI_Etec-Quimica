package br.com.pi_2026_1_etec.view.telas;

public class TelaGerenciamentoDePergunta extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = 
            java.util.logging.Logger.getLogger(TelaGerenciamentoDePergunta.class.getName());
    
    public TelaGerenciamentoDePergunta() {
        initComponents();

        setSize(775, 470);
        setLocationRelativeTo(null);
    }        
   
    private void carregarFiltros() {
        jComboBoxTema.addItem("Todos");
        jComboBoxTema.addItem("Sistema");
        jComboBoxTema.addItem("Material");

        jComboBoxDificuldade.addItem("Todas");
        jComboBoxDificuldade.addItem("Fácil");
        jComboBoxDificuldade.addItem("Médio");
        jComboBoxDificuldade.addItem("Difícil");
} 

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        jPanel2 = new javax.swing.JPanel();
        jPanelPesquisar = new javax.swing.JPanel();
        jTextFieldPesquisarPergunta = new javax.swing.JTextField();
        jButtonFiltrar = new javax.swing.JButton();
        jComboBoxTema = new javax.swing.JComboBox<>();
        jComboBoxDificuldade = new javax.swing.JComboBox<>();
        jPanel6 = new javax.swing.JPanel();
        jPanelListaPerguntas = new javax.swing.JPanel();
        jLabelPergunta = new javax.swing.JLabel();
        jLabelDificuldade = new javax.swing.JLabel();
        jLabelCriadoEm = new javax.swing.JLabel();
        jLabelAcoes = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButtonEdit = new javax.swing.JButton();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        jSeparator8 = new javax.swing.JSeparator();
        jScrollBar1 = new javax.swing.JScrollBar();
        jButtonVoltar = new javax.swing.JButton();
        jButtonAdicionarPergunta = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(775, 460));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelPesquisar.setBackground(new java.awt.Color(146, 25, 19));

        jTextFieldPesquisarPergunta.setText("Pesquisar pergunta...");
        jTextFieldPesquisarPergunta.addActionListener(this::jTextFieldPesquisarPerguntaActionPerformed);

        jButtonFiltrar.setBackground(new java.awt.Color(146, 25, 19));
        jButtonFiltrar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButtonFiltrar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonFiltrar.setText("Filtrar");
        jButtonFiltrar.addActionListener(this::jButtonFiltrarActionPerformed);

        jComboBoxTema.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tema", "Materiais", "Sistemas" }));
        jComboBoxTema.addActionListener(this::jComboBoxTemaActionPerformed);

        jComboBoxDificuldade.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dificuldade", "Fácil", "Médio", "Difícil" }));
        jComboBoxDificuldade.addActionListener(this::jComboBoxDificuldadeActionPerformed);

        javax.swing.GroupLayout jPanelPesquisarLayout = new javax.swing.GroupLayout(jPanelPesquisar);
        jPanelPesquisar.setLayout(jPanelPesquisarLayout);
        jPanelPesquisarLayout.setHorizontalGroup(
            jPanelPesquisarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPesquisarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelPesquisarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldPesquisarPergunta, javax.swing.GroupLayout.DEFAULT_SIZE, 351, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelPesquisarLayout.createSequentialGroup()
                        .addComponent(jComboBoxTema, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxDificuldade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 101, Short.MAX_VALUE)
                        .addComponent(jButtonFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanelPesquisarLayout.setVerticalGroup(
            jPanelPesquisarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPesquisarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextFieldPesquisarPergunta, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelPesquisarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxTema, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxDificuldade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jPanel2.add(jPanelPesquisar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 365, 80));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(146, 25, 19)));
        jPanel6.setForeground(new java.awt.Color(146, 25, 19));

        jPanelListaPerguntas.setBackground(new java.awt.Color(146, 25, 19));

        jLabelPergunta.setForeground(new java.awt.Color(255, 255, 255));
        jLabelPergunta.setText("Pergunta");

        jLabelDificuldade.setForeground(new java.awt.Color(255, 255, 255));
        jLabelDificuldade.setText("Dificuldade");

        jLabelCriadoEm.setForeground(new java.awt.Color(255, 255, 255));
        jLabelCriadoEm.setText("Criado em");

        jLabelAcoes.setForeground(new java.awt.Color(255, 255, 255));
        jLabelAcoes.setText("Ações");

        javax.swing.GroupLayout jPanelListaPerguntasLayout = new javax.swing.GroupLayout(jPanelListaPerguntas);
        jPanelListaPerguntas.setLayout(jPanelListaPerguntasLayout);
        jPanelListaPerguntasLayout.setHorizontalGroup(
            jPanelListaPerguntasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelListaPerguntasLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabelPergunta)
                .addGap(169, 169, 169)
                .addComponent(jLabelDificuldade)
                .addGap(104, 104, 104)
                .addComponent(jLabelCriadoEm, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelAcoes)
                .addGap(44, 44, 44))
        );
        jPanelListaPerguntasLayout.setVerticalGroup(
            jPanelListaPerguntasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelListaPerguntasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelListaPerguntasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPergunta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelDificuldade, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelCriadoEm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelAcoes, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE))
                .addContainerGap())
        );

        jLabel5.setText("Qual é a função do materia mostrado na imagem?");

        jLabel6.setBackground(new java.awt.Color(255, 102, 102));
        jLabel6.setForeground(new java.awt.Color(255, 51, 51));
        jLabel6.setText("Difícil");
        jLabel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel7.setText("26/05/2026");

        jLabel8.setText("14:30");

        jButtonEdit.setText("edit");
        jButtonEdit.addActionListener(this::jButtonEditActionPerformed);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelListaPerguntas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSeparator1)
            .addComponent(jSeparator5)
            .addComponent(jSeparator6)
            .addComponent(jSeparator7)
            .addComponent(jSeparator8)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(64, 64, 64)
                        .addComponent(jLabel6)
                        .addGap(115, 115, 115)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 162, Short.MAX_VALUE)
                .addComponent(jButtonEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jPanelListaPerguntas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jButtonEdit))
                        .addGap(28, 28, 28))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(174, 174, 174)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 720, 320));
        jPanel2.add(jScrollBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 120, -1, 320));

        jButtonVoltar.setText("Voltar");
        jButtonVoltar.addActionListener(this::jButtonVoltarActionPerformed);
        jPanel2.add(jButtonVoltar, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 10, -1, -1));

        jButtonAdicionarPergunta.setBackground(new java.awt.Color(146, 25, 19));
        jButtonAdicionarPergunta.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButtonAdicionarPergunta.setForeground(new java.awt.Color(255, 255, 255));
        jButtonAdicionarPergunta.setText("Adicionar nova pergunta");
        jButtonAdicionarPergunta.addActionListener(this::jButtonAdicionarPerguntaActionPerformed);
        jPanel2.add(jButtonAdicionarPergunta, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 80, -1, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 769, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 5, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 5, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldPesquisarPerguntaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldPesquisarPerguntaActionPerformed
        
    }//GEN-LAST:event_jTextFieldPesquisarPerguntaActionPerformed

    private void jButtonFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFiltrarActionPerformed
        String texto = jTextFieldPesquisarPergunta.getText();
        String tema = jComboBoxTema.getSelectedItem().toString();
        String dificuldade = jComboBoxDificuldade.getSelectedItem().toString();
        aplicarFiltro(texto, tema, dificuldade);
    }//GEN-LAST:event_jButtonFiltrarActionPerformed

    private void jButtonEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditActionPerformed
        new TelaAlterarPergunta(1).setVisible(true); // Exibe o que foi criado. Nesse caso, o objeto TelaAlterarPergunta
        this.dispose(); // Método dispose encerra e destrói a janela de forma segura
    }//GEN-LAST:event_jButtonEditActionPerformed

    private void jButtonVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVoltarActionPerformed
        new TelaMenuProfessores().setVisible(true); // Exibe o que foi criado. Nesse caso, o objeto TelaMenuProfessores
        this.dispose(); // Método dispose encerra e destrói a janela de forma segura
    }//GEN-LAST:event_jButtonVoltarActionPerformed

    private void jButtonAdicionarPerguntaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAdicionarPerguntaActionPerformed
        new TelaAlterarPergunta(0).setVisible(true); // 0 = modo criação (sem ID)
        this.dispose();
    }//GEN-LAST:event_jButtonAdicionarPerguntaActionPerformed

    private void jComboBoxTemaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxTemaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxTemaActionPerformed

    private void jComboBoxDificuldadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxDificuldadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxDificuldadeActionPerformed

    private void aplicarFiltro(String texto, String tema, String dificuldade) {
        // TODO: implementar filtro real. Por enquanto apenas registra os valores.
        // System.out.println pode ser útil para debug local.
        System.out.println("Filtro: " + texto + ", " + tema + ", " + dificuldade);
    }

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
        java.awt.EventQueue.invokeLater(() -> new TelaGerenciamentoDePergunta().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdicionarPergunta;
    private javax.swing.JButton jButtonEdit;
    private javax.swing.JButton jButtonFiltrar;
    private javax.swing.JButton jButtonVoltar;
    private javax.swing.JComboBox<String> jComboBoxDificuldade;
    private javax.swing.JComboBox<String> jComboBoxTema;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabelAcoes;
    private javax.swing.JLabel jLabelCriadoEm;
    private javax.swing.JLabel jLabelDificuldade;
    private javax.swing.JLabel jLabelPergunta;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanelListaPerguntas;
    private javax.swing.JPanel jPanelPesquisar;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JTextField jTextFieldPesquisarPergunta;
    // End of variables declaration//GEN-END:variables
}
