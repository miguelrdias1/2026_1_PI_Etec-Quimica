package br.com.pi_2026_1_etec.view.telas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.sql.SQLException;
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
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import br.com.pi_2026_1_etec.dao.PerguntaDAO;
import br.com.pi_2026_1_etec.model.Pergunta;
import br.com.pi_2026_1_etec.model.Sessao;

public class TelaMenuAlunos extends JFrame {

    private static final java.util.logging.Logger logger =
            java.util.logging.Logger.getLogger(TelaMenuAlunos.class.getName());

    private JButton btnFacil;
    private JButton btnMedio;
    private JButton btnDificil;
    private JButton btnRandom;
    private JButton btnLogout;

    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JLabel jLabel8;
    private JLabel menu;

    private JLayeredPane jLayeredPane1;
    private JPanel pnlTelaMenu;

    private final Color corFacil = new Color(7, 92, 110);
    private final Color corMedio = new Color(56, 69, 79);
    private final Color corDificil = new Color(107, 44, 45);
    private final Color corRandom = new Color(146, 25, 19);

    public TelaMenuAlunos() {
        initComponents();

        if (!Sessao.estaLogado()) {
            JOptionPane.showMessageDialog(this, "Faça login para acessar.");
            new TelaLogin().setVisible(true);
            this.dispose();
            return;
        }

        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    private void initComponents() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Menu Alunos");
        setMinimumSize(new Dimension(1000, 600));
        setBackground(Color.WHITE);

        jLayeredPane1 = new JLayeredPane();

        pnlTelaMenu = new JPanel(new BorderLayout(25, 25));
        pnlTelaMenu.setBackground(Color.WHITE);
        pnlTelaMenu.setBorder(new EmptyBorder(18, 35, 30, 35));

        JPanel painelTopo = criarPainelTopo();
        JPanel painelCentro = criarPainelCentro();
        JPanel painelInferior = criarPainelInferior();

        pnlTelaMenu.add(painelTopo, BorderLayout.NORTH);
        pnlTelaMenu.add(painelCentro, BorderLayout.CENTER);
        pnlTelaMenu.add(painelInferior, BorderLayout.SOUTH);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(pnlTelaMenu, BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }

    private JPanel criarPainelTopo() {
        JPanel painelTopo = new JPanel(new BorderLayout());
        painelTopo.setOpaque(false);

        menu = new JLabel("Menu");
        menu.setFont(new Font("Segoe UI", Font.BOLD, 28));
        menu.setHorizontalAlignment(SwingConstants.CENTER);

        btnLogout = new JButton("Logout");
        btnLogout.setBackground(new Color(195, 16, 12));
        btnLogout.setForeground(Color.WHITE);
        btnLogout.setFont(new Font("Segoe UI", Font.BOLD, 12));
        btnLogout.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnLogout.setPreferredSize(new Dimension(85, 32));
        btnLogout.addActionListener(this::btnLogoutActionPerformed);

        JPanel painelLogout = new JPanel(new FlowLayout(FlowLayout.RIGHT, 0, 0));
        painelLogout.setOpaque(false);
        painelLogout.add(btnLogout);

        painelTopo.add(Box.createHorizontalStrut(85), BorderLayout.WEST);
        painelTopo.add(menu, BorderLayout.CENTER);
        painelTopo.add(painelLogout, BorderLayout.EAST);

        return painelTopo;
    }

    private JPanel criarPainelCentro() {
        JPanel painelCentro = new JPanel(new GridLayout(1, 4, 28, 0));
        painelCentro.setOpaque(false);
        painelCentro.setBorder(new EmptyBorder(10, 5, 10, 5));

        btnFacil = criarBotaoNivel(corFacil, "/ImagensEtec/nivelFacil.png", "Fácil");
        btnMedio = criarBotaoNivel(corMedio, "/ImagensEtec/nivelMedio.png", "Médio");
        btnDificil = criarBotaoNivel(corDificil, "/ImagensEtec/nivelDificil.png", "Difícil");
        btnRandom = criarBotaoNivel(corRandom, "/ImagensEtec/nivelRandom.png", "Aleatório");

        btnFacil.addActionListener(this::btnFacilActionPerformed);
        btnMedio.addActionListener(this::btnMedioActionPerformed);
        btnDificil.addActionListener(this::btnDificilActionPerformed);
        btnRandom.addActionListener(this::btnRandomActionPerformed);

        painelCentro.add(btnFacil);
        painelCentro.add(btnMedio);
        painelCentro.add(btnDificil);
        painelCentro.add(btnRandom);

        return painelCentro;
    }

    private JButton criarBotaoNivel(Color cor, String caminhoIcone, String textoAlternativo) {
        JButton botao = new JButton();
        botao.setBackground(cor);
        botao.setForeground(Color.WHITE);
        botao.setFont(new Font("Segoe UI", Font.BOLD, 18));
        botao.setCursor(new Cursor(Cursor.HAND_CURSOR));
        botao.setFocusPainted(false);
        botao.setBorder(BorderFactory.createLineBorder(cor.darker(), 2));
        botao.setPreferredSize(new Dimension(170, 260));

        try {
            botao.setIcon(new ImageIcon(getClass().getResource(caminhoIcone)));
        } catch (Exception e) {
            botao.setText(textoAlternativo);
        }

        return botao;
    }

    private JPanel criarPainelInferior() {
        JPanel painelInferior = new JPanel(new BorderLayout(20, 0));
        painelInferior.setOpaque(false);
        painelInferior.setBorder(new EmptyBorder(10, 5, 0, 5));
        painelInferior.setPreferredSize(new Dimension(900, 130));

        jLabel2 = new JLabel();
        jLabel2.setBackground(new Color(10, 141, 168));
        jLabel2.setOpaque(true);
        jLabel2.setPreferredSize(new Dimension(95, 110));
        jLabel2.setLayout(new BorderLayout());

        jLabel3 = new JLabel();
        jLabel3.setHorizontalAlignment(SwingConstants.CENTER);

        try {
            jLabel3.setIcon(new ImageIcon(getClass().getResource("/ImagensEtec/menu.png")));
        } catch (Exception e) {
            jLabel3.setText("?");
            jLabel3.setForeground(Color.WHITE);
            jLabel3.setFont(new Font("Segoe UI", Font.BOLD, 28));
        }

        jLabel2.add(jLabel3, BorderLayout.CENTER);

        JPanel painelTexto = new JPanel();
        painelTexto.setOpaque(false);
        painelTexto.setLayout(new BoxLayout(painelTexto, BoxLayout.Y_AXIS));
        painelTexto.setAlignmentX(Component.LEFT_ALIGNMENT);

        jLabel4 = new JLabel("Como funciona o jogo?");
        jLabel4.setFont(new Font("Segoe UI", Font.BOLD, 17));
        jLabel4.setAlignmentX(Component.LEFT_ALIGNMENT);

        jLabel6 = criarLabelExplicacao("Selecione uma das dificuldades acima e pratique");
        jLabel7 = criarLabelExplicacao("o quanto quiser! Seu resultado será guardado");
        jLabel8 = criarLabelExplicacao("para que você possa analisar questões que você");
        jLabel5 = criarLabelExplicacao("possui mais dificuldade!");

        painelTexto.add(jLabel4);
        painelTexto.add(Box.createVerticalStrut(14));
        painelTexto.add(jLabel6);
        painelTexto.add(Box.createVerticalStrut(4));
        painelTexto.add(jLabel7);
        painelTexto.add(Box.createVerticalStrut(4));
        painelTexto.add(jLabel8);
        painelTexto.add(Box.createVerticalStrut(4));
        painelTexto.add(jLabel5);

        painelInferior.add(jLabel2, BorderLayout.WEST);
        painelInferior.add(painelTexto, BorderLayout.CENTER);

        return painelInferior;
    }

    private JLabel criarLabelExplicacao(String texto) {
        JLabel label = new JLabel(texto);
        label.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        label.setHorizontalAlignment(SwingConstants.LEFT);
        label.setAlignmentX(Component.LEFT_ALIGNMENT);
        return label;
    }

    private void btnMedioActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            PerguntaDAO dao = new PerguntaDAO();
            List<Pergunta> perguntas = dao.listarPorNivel(2);
            this.dispose();
            new TelaQuestao1(perguntas).setVisible(true);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Erro: " + e.getMessage());
        }
    }

    private void btnFacilActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            PerguntaDAO dao = new PerguntaDAO();
            List<Pergunta> perguntas = dao.listarPorNivel(1);
            this.dispose();
            new TelaQuestao1(perguntas).setVisible(true);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Erro: " + e.getMessage());
        }
    }

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {
        Sessao.logout();
        new TelaLogin().setVisible(true);
        this.dispose();
    }

    private void btnRandomActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            PerguntaDAO dao = new PerguntaDAO();
            List<Pergunta> perguntasFaceis = dao.listarPorNivel(1);
            List<Pergunta> perguntasMedias = dao.listarPorNivel(2);
            List<Pergunta> perguntasDificeis = dao.listarPorNivel(3);
            List<Pergunta> todasAsPerguntas= new java.util.ArrayList<>();
            todasAsPerguntas.addAll(perguntasFaceis);
            todasAsPerguntas.addAll(perguntasMedias);
            todasAsPerguntas.addAll(perguntasDificeis);
            java.util.Collections.shuffle(todasAsPerguntas);

            new TelaQuestao1(todasAsPerguntas).setVisible(true);
            this.dispose();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Erro: " + e.getMessage());
        }
    }

    private void btnDificilActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            PerguntaDAO dao = new PerguntaDAO();
            List<Pergunta> perguntas = dao.listarPorNivel(3);
            this.dispose();
            new TelaQuestao1(perguntas).setVisible(true);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Erro: " + e.getMessage());
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

        java.awt.EventQueue.invokeLater(() -> new TelaMenuAlunos().setVisible(true));
    }
}