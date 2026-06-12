package br.com.pi_2026_1_etec.view.telas;

import br.com.pi_2026_1_etec.model.Material;

public class TelaAlterarPergunta extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(TelaAlterarPergunta.class.getName());
    private int idPergunta;
    
    public TelaAlterarPergunta(int idPergunta) {
        this.idPergunta = idPergunta;

        initComponents();
        org.jdesktop.swingx.autocomplete.AutoCompleteDecorator.decorate(jComboBox2);
        carregarMateriaisNoCombobox();
        
        jButton1.addActionListener(this::jButton1ActionPerformed);

        if (idPergunta > 0) {
            carregarDadosDaPergunta(idPergunta); // edição
        } else {
            jLabel1.setText("Nova Pergunta");
            jLabel2.setText("Preencha os campos da nova questão abaixo.");
            jButton1.setText("Adicionar pergunta");
        }
    }
    
    private void carregarMateriaisNoCombobox(){
        String sql = "SELECT m.id_material, m.nome, i.caminho_imagem FROM material m JOIN imagem i ON m.id_material = i.id_imagem";
    
    
    java.sql.Connection conn = null;
    java.sql.PreparedStatement ps = null;
    java.sql.ResultSet rs = null;
    
    try {
        //banco
        conn = br.com.pi_2026_1_etec.config.ConexaoBD.obterConexao(); 
        
        ps = conn.prepareStatement(sql);
        rs = ps.executeQuery();
       
        jComboBox2.removeAllItems();
        
  
        while (rs.next()) {
            int id = rs.getInt("id_material");
            String nome = rs.getString("nome");
            String caminho = rs.getString("caminho_imagem");
            
            Material mat = new Material(id, nome, caminho);
      
            jComboBox2.addItem(mat); 
        }
    } catch(Exception e) { 
        
        System.out.println("Erro crítico ao carregar materiais: " + e.getMessage()); 
    } finally {
        
        try {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (conn != null) conn.close();
        } catch (Exception e) {
            System.out.println("Erro ao fechar conexões: " + e.getMessage());
        }
    }
    }
    
    private void carregarDadosDaPergunta(int idPergunta) {

        String sql = """
            SELECT 
                p.enunciado,
                p.dificuldade,
                p.id_material,
                aA.texto AS alternativaA,
                aB.texto AS alternativaB,
                aC.texto AS alternativaC,
                aD.texto AS alternativaD
            FROM pergunta p
            JOIN alternativa aA ON aA.id_pergunta = p.id_pergunta AND aA.letra = 'A'
            JOIN alternativa aB ON aB.id_pergunta = p.id_pergunta AND aB.letra = 'B'
            JOIN alternativa aC ON aC.id_pergunta = p.id_pergunta AND aC.letra = 'C'
            JOIN alternativa aD ON aD.id_pergunta = p.id_pergunta AND aD.letra = 'D'
            WHERE p.id_pergunta = ?
        """;

        try (
            java.sql.Connection conn = br.com.pi_2026_1_etec.config.ConexaoBD.obterConexao();
            java.sql.PreparedStatement ps = conn.prepareStatement(sql)
        ){

            ps.setInt(1, idPergunta);
            java.sql.ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                jTextFieldEditarPergunta.setText(rs.getString("enunciado"));

                jTextField1.setText(rs.getString("alternativaA"));
                jTextField2.setText(rs.getString("alternativaB"));
                jTextField3.setText(rs.getString("alternativaC"));
                jTextField4.setText(rs.getString("alternativaD"));

                jComboBox1.setSelectedItem(rs.getString("dificuldade"));

                int idMaterial = rs.getInt("id_material");
                selecionarMaterialNoCombo(idMaterial);
            }

        } catch (Exception e) {
            System.out.println("Erro ao carregar dados da pergunta: " + e.getMessage());
        }
    }
    
    private void selecionarMaterialNoCombo(int idMaterial) {
        for (int i = 0; i < jComboBox2.getItemCount(); i++) {
            Object item = jComboBox2.getItemAt(i);

            if (item instanceof Material material) {
                if (material.getId() == idMaterial) {
                    jComboBox2.setSelectedIndex(i);
                    break;
                }
            }
        }
    }
    

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jTextFieldEditarPergunta = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jPanelAlternativaA = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jPanelAlternativaB = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jPanelAlternativaC = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jPanelAlternativaD = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jButtonRemoverImagem = new javax.swing.JButton();
        jLabelImagem = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButtonVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        jLabel1.setText("Editar Pergunta");

        jLabel2.setForeground(new java.awt.Color(153, 153, 153));
        jLabel2.setText("Edite os campos da questão abaixo.");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(146, 25, 19)));

        jTextFieldEditarPergunta.setText("Qual a função do material mostrado na imagem?");
        jTextFieldEditarPergunta.setBorder(null);
        jTextFieldEditarPergunta.addActionListener(this::jTextFieldEditarPerguntaActionPerformed);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextFieldEditarPergunta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(77, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextFieldEditarPergunta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel3.setText("Alternativas");

        jPanelAlternativaA.setBackground(new java.awt.Color(146, 25, 19));
        jPanelAlternativaA.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(146, 25, 19)));
        jPanelAlternativaA.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("A");
        jPanelAlternativaA.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 7, -1, -1));

        jTextField1.addActionListener(this::jTextField1ActionPerformed);
        jPanelAlternativaA.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 3, 660, 30));

        jPanelAlternativaB.setBackground(new java.awt.Color(146, 25, 19));
        jPanelAlternativaB.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(146, 25, 19)));
        jPanelAlternativaB.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("B");
        jPanelAlternativaB.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 7, -1, -1));
        jPanelAlternativaB.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 3, 660, 30));

        jPanelAlternativaC.setBackground(new java.awt.Color(146, 25, 19));
        jPanelAlternativaC.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(146, 25, 19)));
        jPanelAlternativaC.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("C");
        jPanelAlternativaC.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 7, -1, -1));
        jPanelAlternativaC.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 3, 660, 30));

        jPanelAlternativaD.setBackground(new java.awt.Color(146, 25, 19));
        jPanelAlternativaD.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(146, 25, 19)));
        jPanelAlternativaD.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("D");
        jPanelAlternativaD.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 7, -1, -1));
        jPanelAlternativaD.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 3, 660, 30));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dificuldade", "Fácil", "Médio", "Difícil" }));
        jComboBox1.addActionListener(this::jComboBox1ActionPerformed);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(146, 25, 19)));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonRemoverImagem.setBackground(new java.awt.Color(146, 25, 19));
        jButtonRemoverImagem.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButtonRemoverImagem.setForeground(new java.awt.Color(255, 255, 255));
        jButtonRemoverImagem.setText("Remover imagem");
        jButtonRemoverImagem.addActionListener(this::jButtonRemoverImagemActionPerformed);
        jPanel3.add(jButtonRemoverImagem, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 50, 130, -1));

        jLabelImagem.setText("Imagem");
        jLabelImagem.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel3.add(jLabelImagem, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 120, 78));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox2.addActionListener(this::jComboBox2ActionPerformed);
        jPanel3.add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, 130, -1));

        jButton1.setBackground(new java.awt.Color(146, 25, 19));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Salvar alterações");

        jButtonVoltar.setText("Voltar");
        jButtonVoltar.addActionListener(this::jButtonVoltarActionPerformed);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(54, 54, 54))
                            .addComponent(jPanelAlternativaA, javax.swing.GroupLayout.DEFAULT_SIZE, 695, Short.MAX_VALUE)
                            .addComponent(jPanelAlternativaB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanelAlternativaC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanelAlternativaD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButtonVoltar)))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButtonVoltar)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(17, 17, 17)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelAlternativaA, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(jPanelAlternativaB, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanelAlternativaC, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanelAlternativaD, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 770, 460));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButtonRemoverImagemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRemoverImagemActionPerformed
        jComboBox2.setSelectedIndex(-1);
        jLabelImagem.setIcon(null);
        jLabelImagem.setText("Imagem");
    }//GEN-LAST:event_jButtonRemoverImagemActionPerformed

    private void jButtonVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVoltarActionPerformed
        new TelaGerenciamentoDePergunta().setVisible(true); // Exibe o que foi criado. Nesse caso, o objeto TelaGerenciamentoPergunta
        this.dispose(); // Método dispose encerra e destrói a janela de forma segura
    }//GEN-LAST:event_jButtonVoltarActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        
    Object itemSelecionado = jComboBox2.getSelectedItem();
    
    
    if (itemSelecionado == null) {
        jLabelImagem.setIcon(null);
        jLabelImagem.setText("Imagem");
        return;
    }
    
    
    if (itemSelecionado instanceof Material) { 
        Material material = (Material) itemSelecionado;
        
        
        String caminhoDaImagem = material.getCaminhoImagem(); 
        
        System.out.println("Caminho que veio do banco: " + caminhoDaImagem);
        
        
        if (caminhoDaImagem != null && !caminhoDaImagem.isEmpty()) {
            try {
                jLabelImagem.setText(""); 
                
                
                javax.swing.ImageIcon icone = new javax.swing.ImageIcon(caminhoDaImagem);
                
                
                java.awt.Image imgRedimensionada = icone.getImage().getScaledInstance(
                    jLabelImagem.getWidth(), jLabelImagem.getHeight(), java.awt.Image.SCALE_SMOOTH
                );
                
                
                jLabelImagem.setIcon(new javax.swing.ImageIcon(imgRedimensionada));
                
            } catch (Exception e) {
                
                jLabelImagem.setIcon(null);
                jLabelImagem.setText("Erro ao carregar foto");
            }
        } else {
            
            jLabelImagem.setIcon(null);
            jLabelImagem.setText("Sem imagem");
        }
    }           
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jTextFieldEditarPerguntaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldEditarPerguntaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldEditarPerguntaActionPerformed
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {

        String enunciado   = jTextFieldEditarPergunta.getText().trim();
        String altA        = jTextField1.getText().trim();
        String altB        = jTextField2.getText().trim();
        String altC        = jTextField3.getText().trim();
        String altD        = jTextField4.getText().trim();
        String dificuldade = jComboBox1.getSelectedItem().toString();

        if (enunciado.isEmpty() || dificuldade.equals("Dificuldade")) {
            javax.swing.JOptionPane.showMessageDialog(
                this,
                "Preencha o enunciado e a dificuldade.",
                "Atenção",
                javax.swing.JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        if (idPergunta == 0) {
            salvarNovaPergunta(enunciado, altA, altB, altC, altD, dificuldade);
        } else {
            atualizarPergunta(enunciado, altA, altB, altC, altD, dificuldade);
        }
    }
    
    private void salvarNovaPergunta(String enunciado, String altA, String altB,
                                String altC, String altD, String dificuldade) {

        String sqlPergunta =
            "INSERT INTO pergunta (enunciado, dificuldade, id_material) VALUES (?, ?, ?)";
        String sqlAlternativa =
            "INSERT INTO alternativa (id_pergunta, letra, texto) VALUES (?, ?, ?)";

        try (java.sql.Connection conn =
                br.com.pi_2026_1_etec.config.ConexaoBD.obterConexao()) {

            conn.setAutoCommit(false);

            int novoId;

            try (java.sql.PreparedStatement ps =
                    conn.prepareStatement(
                        sqlPergunta,
                        java.sql.Statement.RETURN_GENERATED_KEYS)) {

                ps.setString(1, enunciado);
                ps.setString(2, dificuldade);

                Object itemSelecionado = jComboBox2.getSelectedItem();
                if (itemSelecionado instanceof Material material) {
                    ps.setInt(3, material.getId());
                } else {
                    ps.setNull(3, java.sql.Types.INTEGER);
                }

                ps.executeUpdate();

                try (java.sql.ResultSet rs = ps.getGeneratedKeys()) {
                    rs.next();
                    novoId = rs.getInt(1);
                }
            }

            String[][] alternativas = {
                {"A", altA},
                {"B", altB},
                {"C", altC},
                {"D", altD}
            };

            try (java.sql.PreparedStatement ps =
                    conn.prepareStatement(sqlAlternativa)) {

                for (String[] alt : alternativas) {
                    ps.setInt(1, novoId);
                    ps.setString(2, alt[0]);
                    ps.setString(3, alt[1]);
                    ps.addBatch();
                }
                ps.executeBatch();
            }

            conn.commit();

            javax.swing.JOptionPane.showMessageDialog(
                this, "Pergunta adicionada com sucesso!"
            );

            new TelaGerenciamentoDePergunta().setVisible(true);
            this.dispose();

        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(
                this,
                "Erro ao salvar: " + e.getMessage(),
                "Erro",
                javax.swing.JOptionPane.ERROR_MESSAGE
            );
        }
    }
    
    private void atualizarPergunta(String enunciado, String altA, String altB,
                               String altC, String altD, String dificuldade) {

    String sqlPergunta =
        "UPDATE pergunta SET enunciado = ?, dificuldade = ?, id_material = ? WHERE id_pergunta = ?";
    String sqlAlternativa =
        "UPDATE alternativa SET texto = ? WHERE id_pergunta = ? AND letra = ?";

    try (java.sql.Connection conn =
             br.com.pi_2026_1_etec.config.ConexaoBD.obterConexao()) {

        conn.setAutoCommit(false);

        try (java.sql.PreparedStatement ps =
                 conn.prepareStatement(sqlPergunta)) {

            ps.setString(1, enunciado);
            ps.setString(2, dificuldade);

            Object itemSelecionado = jComboBox2.getSelectedItem();
            if (itemSelecionado instanceof Material material) {
                ps.setInt(3, material.getId());
            } else {
                ps.setNull(3, java.sql.Types.INTEGER);
            }

            ps.setInt(4, idPergunta);
            ps.executeUpdate();
        }

        String[][] alternativas = {
            {"A", altA},
            {"B", altB},
            {"C", altC},
            {"D", altD}
        };

        try (java.sql.PreparedStatement ps =
                 conn.prepareStatement(sqlAlternativa)) {

            for (String[] alt : alternativas) {
                ps.setString(1, alt[1]);
                ps.setInt(2, idPergunta);
                ps.setString(3, alt[0]);
                ps.addBatch();
            }
            ps.executeBatch();
        }

        conn.commit();

        javax.swing.JOptionPane.showMessageDialog(
            this, "Pergunta atualizada com sucesso!"
        );

        new TelaGerenciamentoDePergunta().setVisible(true);
        this.dispose();

    } catch (Exception e) {
        javax.swing.JOptionPane.showMessageDialog(
            this,
            "Erro ao atualizar: " + e.getMessage(),
            "Erro",
            javax.swing.JOptionPane.ERROR_MESSAGE
        );
    }
}
    
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

       try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Cria e exibe a tela */
        java.awt.EventQueue.invokeLater(() -> {
            // Criamos a tela passando o número 1 como ID de teste para ela conseguir abrir
            TelaAlterarPergunta tela = new TelaAlterarPergunta(1); 
            tela.setVisible(true); // <-- ESSA LINHA faz a tela aparecer de verdade!
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonRemoverImagem;
    private javax.swing.JButton jButtonVoltar;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<Object> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabelImagem;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanelAlternativaA;
    private javax.swing.JPanel jPanelAlternativaB;
    private javax.swing.JPanel jPanelAlternativaC;
    private javax.swing.JPanel jPanelAlternativaD;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextFieldEditarPergunta;
    // End of variables declaration//GEN-END:variables
}
