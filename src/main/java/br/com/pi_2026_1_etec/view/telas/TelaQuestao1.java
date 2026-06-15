package br.com.pi_2026_1_etec.view.telas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import br.com.pi_2026_1_etec.model.Alternativa;
import br.com.pi_2026_1_etec.model.Pergunta;

public class TelaQuestao1 extends JFrame {

    private List<Pergunta> listaPerguntas;
    private int indiceAtual = 0;
    private List<Alternativa> alternativasAtuais;

    private static final java.util.logging.Logger logger =
            java.util.logging.Logger.getLogger(TelaQuestao1.class.getName());

    private JButton jButtonA;
    private JButton jButtonB;
    private JButton jButtonC;
    private JButton jButtonD;
    private JButton jButtonDica;

    private JLabel jLabelImagemPergunta;
    private JLabel jLabelPergunta;

    private JLayeredPane jLayeredPane1;
    private JPanel jPanel1;
    private JProgressBar jProgressBar1;

    private final Color corPrincipal = new Color(7, 92, 110);

    public TelaQuestao1(List<Pergunta> perguntas) {
        initComponents();

        this.listaPerguntas = perguntas;
        this.indiceAtual = 0;

        exibirPerguntaAtual();

        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    private void exibirPerguntaAtual() {
        if (listaPerguntas != null && indiceAtual < listaPerguntas.size()) {
            Pergunta p = listaPerguntas.get(indiceAtual);

            jLabelPergunta.setText(formatarTextoPergunta(p.getTexto()));

            atualizarBarraProgresso();

            carregarImagemPergunta(p.getIdPergunta());

            try {
                br.com.pi_2026_1_etec.dao.AlternativaDAO altDAO =
                        new br.com.pi_2026_1_etec.dao.AlternativaDAO();

                this.alternativasAtuais = altDAO.listarPorPergunta(p.getIdPergunta());

                java.util.Collections.shuffle(this.alternativasAtuais);

                if (alternativasAtuais.size() >= 4) {
                    jButtonA.setText(formatarTextoBotao(alternativasAtuais.get(0).getTexto()));
                    jButtonB.setText(formatarTextoBotao(alternativasAtuais.get(1).getTexto()));
                    jButtonC.setText(formatarTextoBotao(alternativasAtuais.get(2).getTexto()));
                    jButtonD.setText(formatarTextoBotao(alternativasAtuais.get(3).getTexto()));
                } else {
                    JOptionPane.showMessageDialog(this, "Essa pergunta não possui 4 alternativas cadastradas.");
                }

            } catch (java.sql.SQLException e) {
                JOptionPane.showMessageDialog(this, "Erro ao carregar alternativas: " + e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(this, "Fim do jogo");
            new TelaMenuAlunos().setVisible(true);
            this.dispose();
        }
    }

    private void carregarImagemPergunta(int idPergunta) {
        String caminho = br.com.pi_2026_1_etec.dao.ImagemDAO.buscarCaminhoImagem(idPergunta);

        if (caminho == null || caminho.isBlank()) {
            jLabelImagemPergunta.setIcon(null);
            jLabelImagemPergunta.setText("Sem imagem");
            return;
        }

        String caminhoResource = caminho.startsWith("/") ? caminho : "/" + caminho;

        java.net.URL urlImagem = getClass().getResource(caminhoResource);

        if (urlImagem == null) {
            logger.warning("Imagem não encontrada no classpath: " + caminhoResource);
            jLabelImagemPergunta.setIcon(null);
            jLabelImagemPergunta.setText("Imagem não encontrada");
            return;
        }

        ImageIcon iconOriginal = new ImageIcon(urlImagem);

        int largura = jLabelImagemPergunta.getWidth() > 0 ? jLabelImagemPergunta.getWidth() : 420;
        int altura = jLabelImagemPergunta.getHeight() > 0 ? jLabelImagemPergunta.getHeight() : 280;

        java.awt.Image imagemEscalada = iconOriginal.getImage().getScaledInstance(
                largura, altura, java.awt.Image.SCALE_SMOOTH
        );

        jLabelImagemPergunta.setIcon(new ImageIcon(imagemEscalada));
        jLabelImagemPergunta.setText(null);
    }

    private String formatarTextoPergunta(String texto) {
        if (texto == null) {
            texto = "";
        }

        return "<html><div style='text-align:center; width:850px;'>"
                + texto
                + "</div></html>";
    }

    private String formatarTextoBotao(String texto) {
        if (texto == null) {
            texto = "";
        }

        return "<html><div style='text-align:center; width:330px;'>"
                + texto
                + "</div></html>";
    }

    private void atualizarBarraProgresso() {
        if (listaPerguntas == null || listaPerguntas.isEmpty()) {
            jProgressBar1.setValue(0);
            return;
        }

        int total = listaPerguntas.size();
        int atual = indiceAtual + 1;

        jProgressBar1.setMaximum(total);
        jProgressBar1.setValue(atual);
        jProgressBar1.setString(atual + " / " + total);
        jProgressBar1.setStringPainted(true);
    }

    private void verificarResposta(Alternativa alternativaClicada) {
        if (alternativaClicada.isCorreta()) {
            JOptionPane.showMessageDialog(this, "Acertou");
        } else {
            JOptionPane.showMessageDialog(this, "Resposta incorreta");
        }

        avancarPergunta();
    }

    private void avancarPergunta() {
        indiceAtual++;
        exibirPerguntaAtual();
    }

    private void initComponents() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Questão");
        setMinimumSize(new Dimension(1000, 650));

        jLayeredPane1 = new JLayeredPane();

        jPanel1 = new JPanel(new BorderLayout(25, 20));
        jPanel1.setBackground(Color.WHITE);
        jPanel1.setBorder(new EmptyBorder(18, 35, 30, 35));

        JPanel painelTopo = criarPainelTopo();
        JPanel painelCentro = criarPainelCentro();
        JPanel painelInferior = criarPainelInferior();

        jPanel1.add(painelTopo, BorderLayout.NORTH);
        jPanel1.add(painelCentro, BorderLayout.CENTER);
        jPanel1.add(painelInferior, BorderLayout.SOUTH);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(jPanel1, BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }

    private JPanel criarPainelTopo() {
        JPanel painelTopo = new JPanel(new BorderLayout(15, 0));
        painelTopo.setOpaque(false);

        jLabelPergunta = new JLabel("Pergunta");
        jLabelPergunta.setFont(new Font("Segoe UI", Font.BOLD, 20));
        jLabelPergunta.setHorizontalAlignment(SwingConstants.CENTER);
        jLabelPergunta.setVerticalAlignment(SwingConstants.CENTER);

        jButtonDica = new JButton();
        jButtonDica.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jButtonDica.setPreferredSize(new Dimension(45, 45));
        jButtonDica.setFocusPainted(false);
        jButtonDica.addActionListener(this::jButtonDicaActionPerformed);

        try {
            jButtonDica.setIcon(new ImageIcon(getClass().getResource("/ImagensEtec/Dica.png")));
        } catch (Exception e) {
            jButtonDica.setText("?");
        }

        painelTopo.add(Box.createHorizontalStrut(45), BorderLayout.WEST);
        painelTopo.add(jLabelPergunta, BorderLayout.CENTER);
        painelTopo.add(jButtonDica, BorderLayout.EAST);

        return painelTopo;
    }

    private JPanel criarPainelCentro() {
        JPanel painelCentro = new JPanel();
        painelCentro.setOpaque(false);
        painelCentro.setLayout(new BoxLayout(painelCentro, BoxLayout.Y_AXIS));

        JPanel painelImagem = new JPanel(new BorderLayout());
        painelImagem.setOpaque(false);
        painelImagem.setAlignmentX(Component.CENTER_ALIGNMENT);
        painelImagem.setMaximumSize(new Dimension(420, 280));
        painelImagem.setPreferredSize(new Dimension(420, 280));

        jLabelImagemPergunta = new JLabel("Imagem");
        jLabelImagemPergunta.setHorizontalAlignment(SwingConstants.CENTER);
        jLabelImagemPergunta.setVerticalAlignment(SwingConstants.CENTER);
        jLabelImagemPergunta.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        jLabelImagemPergunta.setBorder(BorderFactory.createLineBorder(new Color(153, 153, 153)));
        jLabelImagemPergunta.setPreferredSize(new Dimension(420, 280));

        painelImagem.add(jLabelImagemPergunta, BorderLayout.CENTER);

        jProgressBar1 = new JProgressBar();
        jProgressBar1.setMaximumSize(new Dimension(700, 18));
        jProgressBar1.setPreferredSize(new Dimension(700, 18));
        jProgressBar1.setAlignmentX(Component.CENTER_ALIGNMENT);

        painelCentro.add(Box.createVerticalGlue());
        painelCentro.add(painelImagem);
        painelCentro.add(Box.createVerticalStrut(25));
        painelCentro.add(jProgressBar1);
        painelCentro.add(Box.createVerticalGlue());

        return painelCentro;
    }

    private JPanel criarPainelInferior() {
        JPanel painelInferior = new JPanel(new GridLayout(2, 2, 18, 14));
        painelInferior.setOpaque(false);
        painelInferior.setBorder(new EmptyBorder(0, 95, 0, 95));
        painelInferior.setPreferredSize(new Dimension(900, 190));

        jButtonA = criarBotaoAlternativa("Alternativa A");
        jButtonB = criarBotaoAlternativa("Alternativa B");
        jButtonC = criarBotaoAlternativa("Alternativa C");
        jButtonD = criarBotaoAlternativa("Alternativa D");

        jButtonA.addActionListener(this::jButtonAActionPerformed);
        jButtonB.addActionListener(this::jButtonBActionPerformed);
        jButtonC.addActionListener(this::jButtonCActionPerformed);
        jButtonD.addActionListener(this::jButtonDActionPerformed);

        painelInferior.add(jButtonA);
        painelInferior.add(jButtonB);
        painelInferior.add(jButtonC);
        painelInferior.add(jButtonD);

        return painelInferior;
    }

    private JButton criarBotaoAlternativa(String texto) {
        JButton botao = new JButton(texto);
        botao.setBackground(corPrincipal);
        botao.setForeground(Color.WHITE);
        botao.setFont(new Font("Segoe UI", Font.BOLD, 14));
        botao.setCursor(new Cursor(Cursor.HAND_CURSOR));
        botao.setFocusPainted(false);
        botao.setBorder(BorderFactory.createLineBorder(corPrincipal.darker(), 2));
        return botao;
    }

    private void jButtonAActionPerformed(java.awt.event.ActionEvent evt) {
        if (alternativasAtuais != null && alternativasAtuais.size() >= 1) {
            verificarResposta(alternativasAtuais.get(0));
        }
    }

    private void jButtonBActionPerformed(java.awt.event.ActionEvent evt) {
        if (alternativasAtuais != null && alternativasAtuais.size() >= 2) {
            verificarResposta(alternativasAtuais.get(1));
        }
    }

    private void jButtonCActionPerformed(java.awt.event.ActionEvent evt) {
        if (alternativasAtuais != null && alternativasAtuais.size() >= 3) {
            verificarResposta(alternativasAtuais.get(2));
        }
    }

    private void jButtonDActionPerformed(java.awt.event.ActionEvent evt) {
        if (alternativasAtuais != null && alternativasAtuais.size() >= 4) {
            verificarResposta(alternativasAtuais.get(3));
        }
    }

    private void jButtonDicaActionPerformed(java.awt.event.ActionEvent evt) {
         if (listaPerguntas == null || indiceAtual >= listaPerguntas.size()) {
        return;
    }

    Pergunta p = listaPerguntas.get(indiceAtual);

    br.com.pi_2026_1_etec.repository.DicaRepository dicaRepository = new br.com.pi_2026_1_etec.repository.DicaRepository();
    String dica = dicaRepository.buscarTextoPorQuestao(p.getIdPergunta());

    if (dica == null || dica.isBlank()) {
        JOptionPane.showMessageDialog(this, "Não há dica disponível para esta pergunta.", "Dica", JOptionPane.INFORMATION_MESSAGE);
    } else {
        JOptionPane.showMessageDialog(this, dica, "Dica", JOptionPane.INFORMATION_MESSAGE);
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

        JOptionPane.showMessageDialog(
                null,
                "Essa tela precisa receber uma lista de perguntas para funcionar.\nAbra ela pelo Menu de Alunos."
        );
    }
}