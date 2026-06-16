package br.com.pi_2026_1_etec.view.telas;

import br.com.pi_2026_1_etec.dao.AlunoDAO;
import br.com.pi_2026_1_etec.model.Aluno;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class TelaGerenciarAlunos extends JFrame {

    private AlunoDAO alunoDAO = new AlunoDAO();
    private ArrayList<Aluno> alunosCarregados = new ArrayList<>();

    private static final java.util.logging.Logger logger =
            java.util.logging.Logger.getLogger(TelaGerenciarAlunos.class.getName());

    private JButton jButton1;
    private JButton jButtonVoltar;

    private JLabel jLabelAlunos;
    private JLabel jLabelContador;
    private JLabel jLabelNomeAluno;
    private JLabel jLabelPerguntas;
    private JLabel jLabelAcertos;
    private JLabel jLabelErros;
    private JLabel jLabel3;

    private JPanel jPanel1;
    private JPanel jPanel6;
    private JPanel jPanelListaDeAlunos;
    private JPanel jPanelTotalPerguntas;
    private JPanel jPanelAcertos;
    private JPanel jPanelErros;
    private JPanel jPanelGraficos;

    private JTextField jTextField1;

    private final Color corPrincipal = new Color(7, 92, 110);
    private final Color corFundoClaro = new Color(245, 250, 252);

    public TelaGerenciarAlunos() {
        initComponents();
        configurarBusca();
        carregarAlunos();

        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    private void initComponents() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Gerenciar Alunos");
        setMinimumSize(new Dimension(1000, 600));

        jPanel1 = new JPanel(new BorderLayout(20, 15));
        jPanel1.setBackground(Color.WHITE);
        jPanel1.setBorder(new EmptyBorder(15, 20, 20, 20));

        jButtonVoltar = new JButton("Voltar");
        jButtonVoltar.addActionListener(this::jButtonVoltarActionPerformed);

        JPanel painelTopo = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        painelTopo.setOpaque(false);
        painelTopo.add(jButtonVoltar);

        JPanel painelConteudo = new JPanel(new BorderLayout(25, 0));
        painelConteudo.setOpaque(false);

        JPanel painelEsquerdo = criarPainelEsquerdo();
        JPanel painelDireito = criarPainelDireito();

        painelConteudo.add(painelEsquerdo, BorderLayout.WEST);
        painelConteudo.add(painelDireito, BorderLayout.CENTER);

        jPanel1.add(painelTopo, BorderLayout.NORTH);
        jPanel1.add(painelConteudo, BorderLayout.CENTER);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(jPanel1, BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }

    private JPanel criarPainelEsquerdo() {
        JPanel painelEsquerdo = new JPanel();
        painelEsquerdo.setOpaque(false);
        painelEsquerdo.setLayout(new BoxLayout(painelEsquerdo, BoxLayout.Y_AXIS));
        painelEsquerdo.setPreferredSize(new Dimension(420, 600));
        painelEsquerdo.setMinimumSize(new Dimension(360, 500));

        jLabelAlunos = new JLabel("Alunos");
        jLabelAlunos.setFont(new Font("Segoe UI", Font.BOLD, 24));
        jLabelAlunos.setAlignmentX(LEFT_ALIGNMENT);

        jTextField1 = new JTextField();
        jTextField1.setPreferredSize(new Dimension(280, 32));
        jTextField1.setMaximumSize(new Dimension(Integer.MAX_VALUE, 32));

        jButton1 = new JButton("Buscar");
        jButton1.setBackground(corPrincipal);
        jButton1.setForeground(Color.WHITE);
        jButton1.setFont(new Font("Segoe UI", Font.BOLD, 12));

        JPanel painelBusca = new JPanel(new BorderLayout(10, 0));
        painelBusca.setOpaque(false);
        painelBusca.setMaximumSize(new Dimension(Integer.MAX_VALUE, 34));
        painelBusca.setAlignmentX(LEFT_ALIGNMENT);
        painelBusca.add(jTextField1, BorderLayout.CENTER);
        painelBusca.add(jButton1, BorderLayout.EAST);

        JLabel jLabel2 = new JLabel("Lista de Alunos");
        jLabel2.setFont(new Font("Segoe UI", Font.BOLD, 16));

        jLabelContador = new JLabel("0");
        jLabelContador.setFont(new Font("Segoe UI", Font.BOLD, 12));
        jLabelContador.setForeground(Color.WHITE);
        jLabelContador.setHorizontalAlignment(SwingConstants.CENTER);
        jLabelContador.setOpaque(true);
        jLabelContador.setBackground(corPrincipal);
        jLabelContador.setBorder(new EmptyBorder(2, 8, 2, 8));

        JPanel painelTituloLista = new JPanel(new BorderLayout());
        painelTituloLista.setOpaque(false);
        painelTituloLista.setMaximumSize(new Dimension(Integer.MAX_VALUE, 32));
        painelTituloLista.setAlignmentX(LEFT_ALIGNMENT);
        painelTituloLista.add(jLabel2, BorderLayout.WEST);
        painelTituloLista.add(jLabelContador, BorderLayout.EAST);

        jPanelListaDeAlunos = new JPanel();
        jPanelListaDeAlunos.setBackground(corFundoClaro);
        jPanelListaDeAlunos.setLayout(new BoxLayout(jPanelListaDeAlunos, BoxLayout.Y_AXIS));

        JScrollPane scrollLista = new JScrollPane(jPanelListaDeAlunos);
        scrollLista.setBorder(BorderFactory.createLineBorder(corPrincipal));
        scrollLista.setAlignmentX(LEFT_ALIGNMENT);
        scrollLista.setPreferredSize(new Dimension(400, 300));
        scrollLista.setMaximumSize(new Dimension(Integer.MAX_VALUE, 300));
        scrollLista.getVerticalScrollBar().setUnitIncrement(16);

        JPanel painelLogo = new JPanel(new FlowLayout(FlowLayout.CENTER));
        painelLogo.setOpaque(false);
        painelLogo.setMaximumSize(new Dimension(Integer.MAX_VALUE, 100));
        painelLogo.setAlignmentX(LEFT_ALIGNMENT);

        jLabel3 = new JLabel();
        try {
            ImageIcon logo = new ImageIcon(getClass().getResource("/ImagensEtec/LogoCPS.png"));
            jLabel3.setIcon(logo);
        } catch (Exception e) {
            jLabel3.setText("");
        }
        painelLogo.add(jLabel3);

        painelEsquerdo.add(Box.createVerticalStrut(10));
        painelEsquerdo.add(jLabelAlunos);
        painelEsquerdo.add(Box.createVerticalStrut(15));
        painelEsquerdo.add(painelBusca);
        painelEsquerdo.add(Box.createVerticalStrut(25));
        painelEsquerdo.add(painelTituloLista);
        painelEsquerdo.add(Box.createVerticalStrut(12));
        painelEsquerdo.add(scrollLista);
        painelEsquerdo.add(Box.createVerticalGlue());
        painelEsquerdo.add(painelLogo);

        return painelEsquerdo;
    }

    private JPanel criarPainelDireito() {
        jPanel6 = new JPanel(new BorderLayout(20, 20));
        jPanel6.setBackground(Color.WHITE);
        jPanel6.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(corPrincipal),
                new EmptyBorder(25, 30, 30, 30)
        ));

        jLabelNomeAluno = new JLabel("Selecione um aluno");
        jLabelNomeAluno.setFont(new Font("Segoe UI", Font.BOLD, 24));

        jPanelTotalPerguntas = new JPanel();
        jPanelAcertos = new JPanel();
        jPanelErros = new JPanel();

        jLabelPerguntas = new JLabel("Perguntas: -");
        jLabelAcertos = new JLabel("Acertos: -");
        jLabelErros = new JLabel("Erros: -");

        configurarCard(jPanelTotalPerguntas, jLabelPerguntas);
        configurarCard(jPanelAcertos, jLabelAcertos);
        configurarCard(jPanelErros, jLabelErros);

        JPanel painelCards = new JPanel(new GridLayout(1, 3, 20, 0));
        painelCards.setOpaque(false);
        painelCards.setPreferredSize(new Dimension(800, 100));
        painelCards.setMinimumSize(new Dimension(600, 100));
        painelCards.setMaximumSize(new Dimension(Integer.MAX_VALUE, 100));

        painelCards.add(jPanelTotalPerguntas);
        painelCards.add(jPanelAcertos);
        painelCards.add(jPanelErros);

        jPanelGraficos = new JPanel(new BorderLayout());
        jPanelGraficos.setBackground(corFundoClaro);
        jPanelGraficos.setBorder(BorderFactory.createLineBorder(corPrincipal));

        JPanel painelLabelsGraficos = new JPanel(new GridLayout(1, 3));
        painelLabelsGraficos.setOpaque(false);
        painelLabelsGraficos.setPreferredSize(new Dimension(800, 60));

        painelLabelsGraficos.add(criarLabelGrafico("Fácil"));
        painelLabelsGraficos.add(criarLabelGrafico("Médio"));
        painelLabelsGraficos.add(criarLabelGrafico("Difícil"));

        jPanelGraficos.add(Box.createVerticalGlue(), BorderLayout.CENTER);
        jPanelGraficos.add(painelLabelsGraficos, BorderLayout.SOUTH);

        JPanel painelCentro = new JPanel();
        painelCentro.setOpaque(false);
        painelCentro.setLayout(new BoxLayout(painelCentro, BoxLayout.Y_AXIS));

        painelCards.setAlignmentX(LEFT_ALIGNMENT);
        jPanelGraficos.setAlignmentX(LEFT_ALIGNMENT);

        painelCentro.add(painelCards);
        painelCentro.add(Box.createVerticalStrut(20));
        painelCentro.add(jPanelGraficos);

        jPanel6.add(jLabelNomeAluno, BorderLayout.NORTH);
        jPanel6.add(painelCentro, BorderLayout.CENTER);

        return jPanel6;
    }

    private JLabel criarLabelGrafico(String texto) {
        JLabel label = new JLabel(texto);
        label.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setVerticalAlignment(SwingConstants.CENTER);
        return label;
    }

    private void configurarCard(JPanel painel, JLabel label) {
        painel.removeAll();
        painel.setBackground(corFundoClaro);
        painel.setBorder(BorderFactory.createLineBorder(corPrincipal));
        painel.setLayout(new BorderLayout());

        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setVerticalAlignment(SwingConstants.CENTER);
        label.setFont(new Font("Segoe UI", Font.BOLD, 16));

        painel.add(label, BorderLayout.CENTER);
        painel.setPreferredSize(new Dimension(180, 90));
        painel.setMinimumSize(new Dimension(150, 90));
        painel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 90));

        painel.revalidate();
        painel.repaint();
    }

    private void configurarBusca() {
        jButton1.addActionListener(e -> buscarAlunos(jTextField1.getText()));
        jTextField1.addActionListener(e -> buscarAlunos(jTextField1.getText()));
    }

    private void carregarAlunos() {
        alunosCarregados = alunoDAO.listarAlunos();
        mostrarAlunosNaTela(alunosCarregados);
    }

    private void buscarAlunos(String textoBusca) {
        if (textoBusca == null || textoBusca.isBlank()) {
            carregarAlunos();
            return;
        }

        alunosCarregados = alunoDAO.buscarAlunos(textoBusca);
        mostrarAlunosNaTela(alunosCarregados);
    }

    private void mostrarAlunosNaTela(ArrayList<Aluno> alunos) {
        jPanelListaDeAlunos.removeAll();

        jLabelContador.setText(String.valueOf(alunos.size()));

        if (alunos.isEmpty()) {
            JLabel semAlunos = new JLabel("  Nenhum aluno encontrado.");
            semAlunos.setFont(new Font("Segoe UI", Font.ITALIC, 13));
            semAlunos.setForeground(Color.GRAY);
            jPanelListaDeAlunos.add(semAlunos);
        }

        for (Aluno aluno : alunos) {
            JPanel painelItem = new JPanel(new BorderLayout());
            painelItem.setBackground(Color.WHITE);
            painelItem.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(220, 220, 220)),
                    new EmptyBorder(8, 12, 8, 12)
            ));
            painelItem.setMaximumSize(new Dimension(Integer.MAX_VALUE, 50));
            painelItem.setCursor(new Cursor(Cursor.HAND_CURSOR));

            JLabel labelNome = new JLabel(aluno.getNome());
            labelNome.setFont(new Font("Segoe UI", Font.BOLD, 13));

            JLabel labelEmail = new JLabel(aluno.getEmail());
            labelEmail.setFont(new Font("Segoe UI", Font.PLAIN, 11));
            labelEmail.setForeground(Color.GRAY);

            JPanel painelTexto = new JPanel();
            painelTexto.setOpaque(false);
            painelTexto.setLayout(new BoxLayout(painelTexto, BoxLayout.Y_AXIS));
            painelTexto.add(labelNome);
            painelTexto.add(labelEmail);

            painelItem.add(painelTexto, BorderLayout.CENTER);

            painelItem.addMouseListener(new java.awt.event.MouseAdapter() {
                @Override
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    mostrarDetalhesAluno(aluno);
                }

                @Override
                public void mouseEntered(java.awt.event.MouseEvent evt) {
                    painelItem.setBackground(new Color(235, 245, 248));
                }

                @Override
                public void mouseExited(java.awt.event.MouseEvent evt) {
                    painelItem.setBackground(Color.WHITE);
                }
            });

            jPanelListaDeAlunos.add(painelItem);
        }

        jPanelListaDeAlunos.revalidate();
        jPanelListaDeAlunos.repaint();
    }

    private void mostrarDetalhesAluno(Aluno aluno) {
        jLabelNomeAluno.setText(aluno.getNome());

        int perguntas = aluno.getQuestoesRespondidas();
        int acertos = aluno.getTaxaAcertos();
        int erros = aluno.getErros();

        jLabelPerguntas.setText("Perguntas: " + perguntas);
        jLabelAcertos.setText("Acertos: " + acertos);
        jLabelErros.setText("Erros: " + erros);

        jPanelTotalPerguntas.revalidate();
        jPanelTotalPerguntas.repaint();
        jPanelAcertos.revalidate();
        jPanelAcertos.repaint();
        jPanelErros.revalidate();
        jPanelErros.repaint();
    }

    private void jButtonVoltarActionPerformed(java.awt.event.ActionEvent evt) {
        new TelaMenuProfessores().setVisible(true);
        this.dispose();
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
            new TelaGerenciarAlunos().setVisible(true);
        });
    }
}
