package br.com.pi_2026_1_etec.view.telas;

import java.util.List;

import br.com.pi_2026_1_etec.model.Alternativa;
import br.com.pi_2026_1_etec.model.Pergunta;

public class TelaQuestao1 extends javax.swing.JFrame {

    private List<Pergunta> listaPerguntas;
    private int indiceAtual = 0;
    private List<Alternativa> alternativasAtuais;
    

    private static final java.util.logging.Logger logger
            = java.util.logging.Logger.getLogger(TelaQuestao1.class.getName());

    public TelaQuestao1(List<Pergunta> perguntas) {
        initComponents();
        this.listaPerguntas = perguntas;
        this.indiceAtual = 0;

        exibirPerguntaAtual();
    }

    private void exibirPerguntaAtual() {
        if (listaPerguntas != null && indiceAtual < listaPerguntas.size()) {
            Pergunta p = listaPerguntas.get(indiceAtual);
            jLabelPergunta.setText(p.getTexto());// troca o texto da label pelo texto da pergunta na lista

            try {//try por causa da conexao com bd
                br.com.pi_2026_1_etec.dao.AlternativaDAO altDAO = new br.com.pi_2026_1_etec.dao.AlternativaDAO(); //puxa alternativa do banco
                this.alternativasAtuais = altDAO.listarPorPergunta(p.getIdPergunta());//coloca as alternativas em uma lista seguindo o ID da pergunta
                
                java.util.Collections.shuffle(this.alternativasAtuais);//Embaralha as alternativas da lista para nunca repetir a ordem das perguntas
                    jButtonA.setText(alternativasAtuais.get(0).getTexto());
                    jButtonB.setText(alternativasAtuais.get(1).getTexto());
                    jButtonC.setText(alternativasAtuais.get(2).getTexto());
                    jButtonD.setText(alternativasAtuais.get(3).getTexto());
                

            } catch (java.sql.SQLException e) {
                javax.swing.JOptionPane.showMessageDialog(this, "Erro ao carregar alternativas: " + e.getMessage());
            }
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "Fim do jogo");//nao sei oq fazer dps disso, voltaria pra tela menu alunos?
        }
    }

    private void verificarResposta(Alternativa alternativaClicada) {
        if (alternativaClicada.isCorreta()) {
            javax.swing.JOptionPane.showMessageDialog(this, "Acertou");
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "Resposta incorreta");
        }
    
    }
    
    private void avancarPergunta() {
    indiceAtual++;
    exibirPerguntaAtual();
    }
    
private void jButtonAActionPerformed(java.awt.event.ActionEvent evt) {                                         
    if (alternativasAtuais != null && alternativasAtuais.size() >= 1) {
        verificarResposta(alternativasAtuais.get(0));//botao A->indice da lista 0 (ta organizado na lista pra ficar igual ja)
    }
}
private void jButtonBActionPerformed(java.awt.event.ActionEvent evt) {                                         
    if (alternativasAtuais != null && alternativasAtuais.size() >= 2) {
        verificarResposta(alternativasAtuais.get(1)); //botao A->indice da lista 1 (ta organizado na lista pra ficar igual ja)
    }
}                                        

private void jButtonCActionPerformed(java.awt.event.ActionEvent evt) {                                         
    if (alternativasAtuais != null && alternativasAtuais.size() >= 3) {
        verificarResposta(alternativasAtuais.get(2)); ////botao C->indice da lista 2 (ta organizado na lista pra ficar igual ja)
    }
}                                        

private void jButtonDActionPerformed(java.awt.event.ActionEvent evt) {                                         
    if (alternativasAtuais != null && alternativasAtuais.size() >= 4) {
        verificarResposta(alternativasAtuais.get(3)); //botao D->indice da lista 3 (ta organizado na lista pra ficar igual ja) 
    }
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
