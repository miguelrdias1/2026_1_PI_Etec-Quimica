package br.com.pi_2026_1_etec.view.telas;

import br.com.pi_2026_1_etec.model.Material;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class TelaAlterarPergunta extends JFrame {

    private static final java.util.logging.Logger logger =
            java.util.logging.Logger.getLogger(TelaAlterarPergunta.class.getName());

    private int idPergunta;

    private final Color corPrincipal = new Color(146, 25, 19);
    private final Color corFundoClaro = new Color(250, 245, 245);

    private JButton jButton1;
    private JButton jButtonRemoverImagem;
    private JButton jButtonVoltar;
    private JButton jButtonDeletar; // NOVO

    private JComboBox<String> jComboBox1;
    private JComboBox<Object> jComboBox2;

    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JLabel jLabelImagem;

    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JPanel jPanelAlternativaA;
    private JPanel jPanelAlternativaB;
    private JPanel jPanelAlternativaC;
    private JPanel jPanelAlternativaD;

    private JTextField jTextField1;
    private JTextField jTextField2;
    private JTextField jTextField3;
    private JTextField jTextField4;
    private JTextField jTextFieldEditarPergunta;

    public TelaAlterarPergunta(int idPergunta) {
        this.idPergunta = idPergunta;

        initComponents();

        try {
            org.jdesktop.swingx.autocomplete.AutoCompleteDecorator.decorate(jComboBox2);
        } catch (Exception e) {
            System.out.println("Autocomplete não carregado: " + e.getMessage());
        }

        carregarMateriaisNoCombobox();

        jButton1.addActionListener(this::jButton1ActionPerformed);

        // NOVO: só exibe o botão deletar quando estiver editando uma pergunta existente
        jButtonDeletar.setVisible(idPergunta > 0);

        if (idPergunta > 0) {
            carregarDadosDaPergunta(idPergunta);
        } else {
            jLabel1.setText("Nova Pergunta");
            jLabel2.setText("Preencha os campos da nova questão abaixo.");
            jButton1.setText("Adicionar pergunta");
        }

        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    private void initComponents() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Alterar Pergunta");
        setMinimumSize(new Dimension(1000, 650));

        jPanel1 = new JPanel(new BorderLayout(20, 20));
        jPanel1.setBackground(Color.WHITE);
        jPanel1.setBorder(new EmptyBorder(15, 25, 25, 25));

        jButtonVoltar = new JButton("Voltar");
        jButtonVoltar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jButtonVoltar.addActionListener(this::jButtonVoltarActionPerformed);

        JPanel painelTopo = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        painelTopo.setOpaque(false);
        painelTopo.add(jButtonVoltar);

        JPanel painelFormulario = criarPainelFormulario();

        JScrollPane scrollPane = new JScrollPane(painelFormulario);
        scrollPane.setBorder(null);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        scrollPane.setBackground(Color.WHITE);

        jPanel1.add(painelTopo, BorderLayout.NORTH);
        jPanel1.add(scrollPane, BorderLayout.CENTER);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(jPanel1, BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }

    private JPanel criarPainelFormulario() {
        JPanel painelFormulario = new JPanel();
        painelFormulario.setOpaque(false);
        painelFormulario.setLayout(new BoxLayout(painelFormulario, BoxLayout.Y_AXIS));
        painelFormulario.setBorder(new EmptyBorder(10, 15, 10, 15));

        JPanel painelSuperior = new JPanel(new BorderLayout(25, 0));
        painelSuperior.setOpaque(false);
        painelSuperior.setMaximumSize(new Dimension(Integer.MAX_VALUE, 180));
        painelSuperior.setAlignmentX(LEFT_ALIGNMENT);

        JPanel painelEnunciado = criarPainelEnunciado();
        JPanel painelImagem = criarPainelImagem();

        painelSuperior.add(painelEnunciado, BorderLayout.CENTER);
        painelSuperior.add(painelImagem, BorderLayout.EAST);

        jLabel3 = new JLabel("Alternativas");
        jLabel3.setFont(new Font("Segoe UI", Font.BOLD, 18));
        jLabel3.setAlignmentX(LEFT_ALIGNMENT);

        jTextField1 = new JTextField();
        jTextField2 = new JTextField();
        jTextField3 = new JTextField();
        jTextField4 = new JTextField();

        jTextField1.addActionListener(this::jTextField1ActionPerformed);

        jPanelAlternativaA = criarPainelAlternativa("A", jTextField1);
        jPanelAlternativaB = criarPainelAlternativa("B", jTextField2);
        jPanelAlternativaC = criarPainelAlternativa("C", jTextField3);
        jPanelAlternativaD = criarPainelAlternativa("D", jTextField4);

        JPanel painelAlternativas = new JPanel();
        painelAlternativas.setOpaque(false);
        painelAlternativas.setLayout(new GridLayout(4, 1, 0, 14));
        painelAlternativas.setMaximumSize(new Dimension(Integer.MAX_VALUE, 220));
        painelAlternativas.setPreferredSize(new Dimension(900, 220));
        painelAlternativas.setAlignmentX(LEFT_ALIGNMENT);

        painelAlternativas.add(jPanelAlternativaA);
        painelAlternativas.add(jPanelAlternativaB);
        painelAlternativas.add(jPanelAlternativaC);
        painelAlternativas.add(jPanelAlternativaD);

        JPanel painelRodape = criarPainelRodape();
        painelRodape.setAlignmentX(LEFT_ALIGNMENT);

        painelFormulario.add(painelSuperior);
        painelFormulario.add(Box.createVerticalStrut(25));
        painelFormulario.add(jLabel3);
        painelFormulario.add(Box.createVerticalStrut(10));
        painelFormulario.add(painelAlternativas);
        painelFormulario.add(Box.createVerticalStrut(22));
        painelFormulario.add(painelRodape);
        painelFormulario.add(Box.createVerticalGlue());

        return painelFormulario;
    }

    private JPanel criarPainelEnunciado() {
        JPanel painelContainer = new JPanel();
        painelContainer.setOpaque(false);
        painelContainer.setLayout(new BoxLayout(painelContainer, BoxLayout.Y_AXIS));

        jLabel1 = new JLabel("Editar Pergunta");
        jLabel1.setFont(new Font("Segoe UI", Font.BOLD, 26));
        jLabel1.setAlignmentX(LEFT_ALIGNMENT);

        jLabel2 = new JLabel("Edite os campos da questão abaixo.");
        jLabel2.setForeground(new Color(153, 153, 153));
        jLabel2.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        jLabel2.setAlignmentX(LEFT_ALIGNMENT);

        jPanel2 = new JPanel(new BorderLayout());
        jPanel2.setBackground(Color.WHITE);
        jPanel2.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(corPrincipal),
                new EmptyBorder(8, 10, 8, 10)
        ));
        jPanel2.setMaximumSize(new Dimension(Integer.MAX_VALUE, 90));
        jPanel2.setPreferredSize(new Dimension(600, 90));
        jPanel2.setAlignmentX(LEFT_ALIGNMENT);

        jTextFieldEditarPergunta = new JTextField();
        jTextFieldEditarPergunta.setText("Editar pergunta...");
        jTextFieldEditarPergunta.setBorder(null);
        jTextFieldEditarPergunta.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        jTextFieldEditarPergunta.addActionListener(this::jTextFieldEditarPerguntaActionPerformed);

        jPanel2.add(jTextFieldEditarPergunta, BorderLayout.CENTER);

        painelContainer.add(jLabel1);
        painelContainer.add(Box.createVerticalStrut(6));
        painelContainer.add(jLabel2);
        painelContainer.add(Box.createVerticalStrut(10));
        painelContainer.add(jPanel2);

        return painelContainer;
    }

    private JPanel criarPainelImagem() {
        jPanel3 = new JPanel(new BorderLayout(12, 0));
        jPanel3.setBackground(Color.WHITE);
        jPanel3.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(corPrincipal),
                new EmptyBorder(12, 12, 12, 12)
        ));
        jPanel3.setPreferredSize(new Dimension(360, 115));
        jPanel3.setMinimumSize(new Dimension(320, 115));

        jLabelImagem = new JLabel("Imagem");
        jLabelImagem.setHorizontalAlignment(SwingConstants.CENTER);
        jLabelImagem.setVerticalAlignment(SwingConstants.CENTER);
        jLabelImagem.setBorder(BorderFactory.createLineBorder(new Color(204, 204, 204)));
        jLabelImagem.setPreferredSize(new Dimension(125, 85));

        jComboBox2 = new JComboBox<>();
        jComboBox2.setPreferredSize(new Dimension(170, 28));
        jComboBox2.addActionListener(this::jComboBox2ActionPerformed);

        jButtonRemoverImagem = new JButton("Remover imagem");
        jButtonRemoverImagem.setBackground(corPrincipal);
        jButtonRemoverImagem.setForeground(Color.WHITE);
        jButtonRemoverImagem.setFont(new Font("Segoe UI", Font.BOLD, 12));
        jButtonRemoverImagem.addActionListener(this::jButtonRemoverImagemActionPerformed);

        JPanel painelControlesImagem = new JPanel();
        painelControlesImagem.setOpaque(false);
        painelControlesImagem.setLayout(new BoxLayout(painelControlesImagem, BoxLayout.Y_AXIS));

        painelControlesImagem.add(jComboBox2);
        painelControlesImagem.add(Box.createVerticalStrut(12));
        painelControlesImagem.add(jButtonRemoverImagem);
        painelControlesImagem.add(Box.createVerticalGlue());

        jPanel3.add(jLabelImagem, BorderLayout.WEST);
        jPanel3.add(painelControlesImagem, BorderLayout.CENTER);

        return jPanel3;
    }

    private JPanel criarPainelAlternativa(String letra, JTextField campoTexto) {
        JPanel painel = new JPanel(new BorderLayout(8, 0));
        painel.setBackground(corPrincipal);
        painel.setBorder(BorderFactory.createLineBorder(corPrincipal));
        painel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 45));
        painel.setPreferredSize(new Dimension(900, 45));

        JLabel labelLetra = new JLabel(letra);
        labelLetra.setFont(new Font("Segoe UI", Font.BOLD, 16));
        labelLetra.setForeground(Color.WHITE);
        labelLetra.setHorizontalAlignment(SwingConstants.CENTER);
        labelLetra.setPreferredSize(new Dimension(38, 45));

        campoTexto.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        campoTexto.setBorder(BorderFactory.createEmptyBorder(0, 8, 0, 8));

        JPanel painelCampo = new JPanel(new BorderLayout());
        painelCampo.setOpaque(false);
        painelCampo.setBorder(new EmptyBorder(5, 0, 5, 5));
        painelCampo.add(campoTexto, BorderLayout.CENTER);

        painel.add(labelLetra, BorderLayout.WEST);
        painel.add(painelCampo, BorderLayout.CENTER);

        if ("A".equals(letra)) {
            jLabel4 = labelLetra;
        } else if ("B".equals(letra)) {
            jLabel5 = labelLetra;
        } else if ("C".equals(letra)) {
            jLabel6 = labelLetra;
        } else if ("D".equals(letra)) {
            jLabel7 = labelLetra;
        }

        return painel;
    }

    private JPanel criarPainelRodape() {
        JPanel painelRodape = new JPanel(new BorderLayout());
        painelRodape.setOpaque(false);
        painelRodape.setMaximumSize(new Dimension(Integer.MAX_VALUE, 45));

        jComboBox1 = new JComboBox<>();
        jComboBox1.setModel(new DefaultComboBoxModel<>(new String[]{"Fácil", "Médio", "Difícil"}));
        jComboBox1.addActionListener(this::jComboBox1ActionPerformed);

        jButton1 = new JButton("Salvar alterações");
        jButton1.setBackground(corPrincipal);
        jButton1.setForeground(Color.WHITE);
        jButton1.setFont(new Font("Segoe UI", Font.BOLD, 12));
        jButton1.setPreferredSize(new Dimension(170, 32));

        // NOVO: botão deletar
        jButtonDeletar = new JButton("Deletar pergunta");
        jButtonDeletar.setBackground(new Color(180, 0, 0));
        jButtonDeletar.setForeground(Color.WHITE);
        jButtonDeletar.setFont(new Font("Segoe UI", Font.BOLD, 12));
        jButtonDeletar.setPreferredSize(new Dimension(150, 32));
        jButtonDeletar.addActionListener(this::jButtonDeletarActionPerformed);

        JPanel painelDificuldade = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        painelDificuldade.setOpaque(false);
        painelDificuldade.add(jComboBox1);

        JPanel painelSalvar = new JPanel(new FlowLayout(FlowLayout.RIGHT, 8, 0));
        painelSalvar.setOpaque(false);
        painelSalvar.add(jButtonDeletar); // NOVO
        painelSalvar.add(jButton1);

        painelRodape.add(painelDificuldade, BorderLayout.WEST);
        painelRodape.add(painelSalvar, BorderLayout.EAST);

        return painelRodape;
    }

    private void carregarMateriaisNoCombobox() {
        String sql = "SELECT m.id_material, m.nome, i.caminho_imagem FROM material m JOIN imagem i ON m.id_material = i.id_imagem";

        java.sql.Connection conn = null;
        java.sql.PreparedStatement ps = null;
        java.sql.ResultSet rs = null;

        try {
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
        } catch (Exception e) {
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
        java.sql.Connection conn = null;
        java.sql.PreparedStatement ps = null;
        java.sql.ResultSet rs = null;

        try {
            conn = br.com.pi_2026_1_etec.config.ConexaoBD.obterConexao();

            ps = conn.prepareStatement(
                    "SELECT p.texto AS enunciado, nv.nome AS dificuldade, p.id_material " +
                            "FROM pergunta p " +
                            "LEFT JOIN nivel nv ON p.id_nivel = nv.id_nivel " +
                            "WHERE p.id_pergunta = ?"
            );
            ps.setInt(1, idPergunta);
            rs = ps.executeQuery();

            if (rs.next()) {
                jTextFieldEditarPergunta.setText(rs.getString("enunciado"));
                jComboBox1.setSelectedItem(rs.getString("dificuldade"));
                selecionarMaterialNoCombo(rs.getInt("id_material"));
            } else {
                return;
            }

            rs.close();
            ps.close();

            ps = conn.prepareStatement(
                    "SELECT texto FROM alternativa WHERE id_pergunta = ? ORDER BY id_alternativa"
            );
            ps.setInt(1, idPergunta);
            rs = ps.executeQuery();

            JTextField[] campos = {jTextField1, jTextField2, jTextField3, jTextField4};
            int i = 0;
            while (rs.next() && i < 4) {
                campos[i].setText(rs.getString("texto"));
                i++;
            }

        } catch (Exception e) {
            System.out.println("Erro ao carregar dados da pergunta: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
            } catch (Exception e) {
            }
            try {
                if (ps != null) ps.close();
            } catch (Exception e) {
            }
            try {
                if (conn != null) conn.close();
            } catch (Exception e) {
            }
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

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {
        // Mantido para preservar função existente.
    }

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {
        // Mantido para preservar função existente.
    }

    private void jButtonRemoverImagemActionPerformed(java.awt.event.ActionEvent evt) {
        jComboBox2.setSelectedIndex(-1);
        jLabelImagem.setIcon(null);
        jLabelImagem.setText("Imagem");
    }

    private void jButtonVoltarActionPerformed(java.awt.event.ActionEvent evt) {
        new TelaGerenciamentoDePergunta().setVisible(true);
        this.dispose();
    }

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {
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

                    ImageIcon icone = new ImageIcon(caminhoDaImagem);

                    int largura = jLabelImagem.getWidth();
                    int altura = jLabelImagem.getHeight();

                    if (largura <= 0) largura = 120;
                    if (altura <= 0) altura = 78;

                    Image imgRedimensionada = icone.getImage().getScaledInstance(
                            largura,
                            altura,
                            Image.SCALE_SMOOTH
                    );

                    jLabelImagem.setIcon(new ImageIcon(imgRedimensionada));

                } catch (Exception e) {
                    jLabelImagem.setIcon(null);
                    jLabelImagem.setText("Erro ao carregar foto");
                }
            } else {
                jLabelImagem.setIcon(null);
                jLabelImagem.setText("Sem imagem");
            }
        }
    }

    private void jTextFieldEditarPerguntaActionPerformed(java.awt.event.ActionEvent evt) {
        // Mantido para preservar função existente.
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        String enunciado = jTextFieldEditarPergunta.getText().trim();
        String altA = jTextField1.getText().trim();
        String altB = jTextField2.getText().trim();
        String altC = jTextField3.getText().trim();
        String altD = jTextField4.getText().trim();
        String dificuldade = jComboBox1.getSelectedItem().toString();

        if (enunciado.isEmpty() || dificuldade.equals("Dificuldade")) {
            JOptionPane.showMessageDialog(
                    this,
                    "Preencha o enunciado e a dificuldade.",
                    "Atenção",
                    JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        if (idPergunta == 0) {
            try {
                salvarNovaPergunta(enunciado, altA, altB, altC, altD, dificuldade);
            } catch (java.sql.SQLException e) {
                JOptionPane.showMessageDialog(
                        this,
                        "Erro ao salvar: " + e.getMessage(),
                        "Erro",
                        JOptionPane.ERROR_MESSAGE
                );
                return;
            }
        } else {
            atualizarPergunta(enunciado, altA, altB, altC, altD, dificuldade);
        }
    }

    // NOVO: handler do botão deletar
    private void jButtonDeletarActionPerformed(java.awt.event.ActionEvent evt) {
        int confirmacao = JOptionPane.showConfirmDialog(
                this,
                "Tem certeza que deseja deletar esta pergunta?\nEsta ação não pode ser desfeita.",
                "Confirmar exclusão",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE
        );

        if (confirmacao != JOptionPane.YES_OPTION) {
            return;
        }

        String sqlDeleteAlternativas = "DELETE FROM alternativa WHERE id_pergunta = ?";
        String sqlDeletePergunta     = "DELETE FROM pergunta WHERE id_pergunta = ?";

        try (java.sql.Connection conn =
                     br.com.pi_2026_1_etec.config.ConexaoBD.obterConexao()) {

            conn.setAutoCommit(false);

            // 1º apaga as alternativas (FK) antes de apagar a pergunta
            try (java.sql.PreparedStatement ps = conn.prepareStatement(sqlDeleteAlternativas)) {
                ps.setInt(1, idPergunta);
                ps.executeUpdate();
            }

            // 2º apaga a pergunta
            try (java.sql.PreparedStatement ps = conn.prepareStatement(sqlDeletePergunta)) {
                ps.setInt(1, idPergunta);
                ps.executeUpdate();
            }

            conn.commit();

            JOptionPane.showMessageDialog(
                    this,
                    "Pergunta deletada com sucesso!",
                    "Sucesso",
                    JOptionPane.INFORMATION_MESSAGE
            );

            new TelaGerenciamentoDePergunta().setVisible(true);
            this.dispose();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                    this,
                    "Erro ao deletar: " + e.getMessage(),
                    "Erro",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    private void salvarNovaPergunta(String enunciado, String altA, String altB,
                                    String altC, String altD, String dificuldade) throws java.sql.SQLException {

        String sqlPergunta =
                "INSERT INTO pergunta (id_pergunta, texto, id_imagem, id_tema, id_material, id_nivel, id_sistema, tipo_pergunta) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        String sqlAlternativa =
                "INSERT INTO alternativa (id_alternativa, texto, correta, errada, id_imagem, id_pergunta) VALUES (?, ?, ?, ?, ?, ?)";

        try (java.sql.Connection conn =
                     br.com.pi_2026_1_etec.config.ConexaoBD.obterConexao()) {

            conn.setAutoCommit(false);

            int novoId = obterProximoIdPergunta(conn);
            Integer idNivel = obterIdNivelPorDificuldade(dificuldade);
            if (idNivel == null) {
                throw new java.sql.SQLException("Nível não encontrado: " + dificuldade);
            }

            try (java.sql.PreparedStatement ps =
                         conn.prepareStatement(sqlPergunta)) {

                ps.setInt(1, novoId);
                ps.setString(2, enunciado);
                ps.setNull(3, java.sql.Types.INTEGER);

                Object itemSelecionado = jComboBox2.getSelectedItem();
                Integer idTema = obterIdTemaPadrao(itemSelecionado instanceof Material ? "Material" : "Sistema");
                ps.setInt(4, idTema);

                if (itemSelecionado instanceof Material material) {
                    ps.setInt(5, material.getId());
                } else {
                    ps.setNull(5, java.sql.Types.INTEGER);
                }

                ps.setInt(6, idNivel);
                ps.setNull(7, java.sql.Types.INTEGER);
                ps.setString(8, "Múltipla escolha");

                ps.executeUpdate();
            }

            String[][] alternativas = {
                    {"A", altA},
                    {"B", altB},
                    {"C", altC},
                    {"D", altD}
            };

            int altId = obterProximoIdAlternativa(conn);
            try (java.sql.PreparedStatement ps =
                         conn.prepareStatement(sqlAlternativa)) {

                for (String[] alt : alternativas) {
                    ps.setInt(1, altId++);
                    ps.setString(2, alt[1]);
                    ps.setInt(3, 0);
                    ps.setInt(4, 0);
                    ps.setNull(5, java.sql.Types.INTEGER);
                    ps.setInt(6, novoId);
                    ps.addBatch();
                }
                ps.executeBatch();
            }

            conn.commit();

            JOptionPane.showMessageDialog(
                    this, "Pergunta adicionada com sucesso!"
            );

            new TelaGerenciamentoDePergunta().setVisible(true);
            this.dispose();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                    this,
                    "Erro ao salvar: " + e.getMessage(),
                    "Erro",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    private Integer obterIdNivelPorDificuldade(String dificuldade) throws java.sql.SQLException {
        String sql = "SELECT id_nivel FROM nivel WHERE nome = ?";
        try (java.sql.Connection conn = br.com.pi_2026_1_etec.config.ConexaoBD.obterConexao();
             java.sql.PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, dificuldade);
            try (java.sql.ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("id_nivel");
                }
            }
        }
        return null;
    }

    private Integer obterIdTemaPorNome(String nome) throws java.sql.SQLException {
        String sql = "SELECT id_tema FROM tema WHERE nome = ?";
        try (java.sql.Connection conn = br.com.pi_2026_1_etec.config.ConexaoBD.obterConexao();
             java.sql.PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, nome);
            try (java.sql.ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("id_tema");
                }
            }
        }
        return null;
    }

    private Integer obterPrimeiroIdTema() throws java.sql.SQLException {
        String sql = "SELECT id_tema FROM tema LIMIT 1";
        try (java.sql.Connection conn = br.com.pi_2026_1_etec.config.ConexaoBD.obterConexao();
             java.sql.PreparedStatement ps = conn.prepareStatement(sql);
             java.sql.ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                return rs.getInt("id_tema");
            }
        }
        return null;
    }

    private Integer obterIdTemaPadrao(String nomePreferido) {
        try {
            Integer idTema = obterIdTemaPorNome(nomePreferido);
            if (idTema != null) {
                return idTema;
            }
            idTema = obterPrimeiroIdTema();
            if (idTema != null) {
                return idTema;
            }
        } catch (java.sql.SQLException e) {
            System.out.println("Não foi possível buscar id_tema: " + e.getMessage());
        }
        return 1;
    }

    private int obterProximoIdPergunta(java.sql.Connection conn) throws java.sql.SQLException {
        String sql = "SELECT COALESCE(MAX(id_pergunta), 0) + 1 AS proximo_id FROM pergunta";
        try (java.sql.PreparedStatement ps = conn.prepareStatement(sql);
             java.sql.ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                return rs.getInt("proximo_id");
            }
        }
        return 1;
    }

    private int obterProximoIdAlternativa(java.sql.Connection conn) throws java.sql.SQLException {
        String sql = "SELECT COALESCE(MAX(id_alternativa), 0) + 1 AS proximo_id FROM alternativa";
        try (java.sql.PreparedStatement ps = conn.prepareStatement(sql);
             java.sql.ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                return rs.getInt("proximo_id");
            }
        }
        return 1;
    }

    private void atualizarPergunta(String enunciado, String altA, String altB,
                                   String altC, String altD, String dificuldade) {

        String sqlPergunta =
                "UPDATE pergunta SET texto = ?, id_imagem = ?, id_tema = ?, id_material = ?, id_nivel = ?, id_sistema = ?, tipo_pergunta = ? WHERE id_pergunta = ?";
        String sqlAlternativaDelete =
                "DELETE FROM alternativa WHERE id_pergunta = ?";
        String sqlAlternativa =
                "INSERT INTO alternativa (id_alternativa, texto, correta, errada, id_imagem, id_pergunta) VALUES (?, ?, ?, ?, ?, ?)";

        try (java.sql.Connection conn =
                     br.com.pi_2026_1_etec.config.ConexaoBD.obterConexao()) {

            conn.setAutoCommit(false);

            try (java.sql.PreparedStatement ps =
                         conn.prepareStatement(sqlPergunta)) {

                ps.setString(1, enunciado);
                ps.setNull(2, java.sql.Types.INTEGER);

                Object itemSelecionado = jComboBox2.getSelectedItem();
                Integer idTema = obterIdTemaPadrao(itemSelecionado instanceof Material ? "Material" : "Sistema");
                ps.setInt(3, idTema);

                if (itemSelecionado instanceof Material material) {
                    ps.setInt(4, material.getId());
                } else {
                    ps.setNull(4, java.sql.Types.INTEGER);
                }

                Integer idNivel = obterIdNivelPorDificuldade(dificuldade);
                if (idNivel == null) {
                    throw new java.sql.SQLException("Nível não encontrado: " + dificuldade);
                }

                ps.setInt(5, idNivel);
                ps.setNull(6, java.sql.Types.INTEGER);
                ps.setString(7, "Múltipla escolha");

                ps.setInt(8, idPergunta);
                ps.executeUpdate();
            }

            String[][] alternativas = {
                    {"A", altA},
                    {"B", altB},
                    {"C", altC},
                    {"D", altD}
            };

            try (java.sql.PreparedStatement ps =
                         conn.prepareStatement(sqlAlternativaDelete)) {
                ps.setInt(1, idPergunta);
                ps.executeUpdate();
            }

            int altId = obterProximoIdAlternativa(conn);
            try (java.sql.PreparedStatement ps =
                         conn.prepareStatement(sqlAlternativa)) {

                for (String[] alt : alternativas) {
                    ps.setInt(1, altId++);
                    ps.setString(2, alt[1]);
                    ps.setInt(3, 0);
                    ps.setInt(4, 0);
                    ps.setNull(5, java.sql.Types.INTEGER);
                    ps.setInt(6, idPergunta);
                    ps.addBatch();
                }
                ps.executeBatch();
            }

            conn.commit();

            JOptionPane.showMessageDialog(
                    this, "Pergunta atualizada com sucesso!"
            );

            new TelaGerenciamentoDePergunta().setVisible(true);
            this.dispose();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                    this,
                    "Erro ao atualizar: " + e.getMessage(),
                    "Erro",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    public static void main(String[] args) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            TelaAlterarPergunta tela = new TelaAlterarPergunta(1);
            tela.setVisible(true);
        });
    }
}