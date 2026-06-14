package br.com.pi_2026_1_etec.view.telas;

import br.com.pi_2026_1_etec.repository.UsuarioRepository;
import br.com.pi_2026_1_etec.model.Usuario;
import br.com.pi_2026_1_etec.model.Sessao;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class TelaLogin extends JFrame {

    private static final java.util.logging.Logger logger =
            java.util.logging.Logger.getLogger(TelaLogin.class.getName());

    private final Color corPrincipal = new Color(7, 92, 110);
    private final Color corDestaque = new Color(0, 180, 220);

    private JButton entrar;
    private JButton jButtonRedirecionamentoCadastro;

    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JLabel jLabel8;
    private JLabel jLabelEmail;
    private JLabel jLabelLogin;
    private JLabel jLabelMostrarSenha;
    private JLabel jLabelSenha;

    private JLayeredPane jLayeredPane1;

    private JPanel jPanelFundoAzul;
    private JPanel jPanelFundoBranco;
    private JPanel jPanelFundoLogin;

    private JTextField jTextFieldEmail;
    private JToggleButton mostrarSenha;
    private JPasswordField txtSenha;

    public TelaLogin() {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    private void initComponents() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Login");
        setMinimumSize(new Dimension(950, 550));
        setResizable(true);

        jLayeredPane1 = new JLayeredPane();

        jPanelFundoBranco = new JPanel(new BorderLayout());
        jPanelFundoBranco.setBackground(Color.WHITE);

        jPanelFundoAzul = criarPainelLateral();
        jPanelFundoLogin = criarPainelLogin();

        JPanel painelConteudo = new JPanel(new BorderLayout());
        painelConteudo.setBackground(Color.WHITE);

        painelConteudo.add(jPanelFundoAzul, BorderLayout.WEST);

        JPanel painelCentro = new JPanel(new GridBagLayout());
        painelCentro.setBackground(Color.WHITE);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.anchor = GridBagConstraints.CENTER;

        painelCentro.add(jPanelFundoLogin, gbc);

        painelConteudo.add(painelCentro, BorderLayout.CENTER);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(painelConteudo, BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }

    private JPanel criarPainelLateral() {
        JPanel painel = new JPanel();
        painel.setBackground(corPrincipal);

        // Aumentado para o texto não cortar.
        painel.setPreferredSize(new Dimension(430, 600));
        painel.setMinimumSize(new Dimension(400, 500));

        painel.setLayout(new GridBagLayout());

        JPanel textos = new JPanel();
        textos.setOpaque(false);
        textos.setLayout(new BoxLayout(textos, BoxLayout.Y_AXIS));
        textos.setBorder(new EmptyBorder(20, 33, 20, 33));

        jLabel3 = new JLabel("O GRANDE");
        jLabel3.setFont(new Font("Segoe UI", Font.BOLD, 22));
        jLabel3.setForeground(corDestaque);
        jLabel3.setAlignmentX(Component.LEFT_ALIGNMENT);

        jLabel4 = new JLabel("DESAFIO");
        jLabel4.setFont(new Font("Segoe UI", Font.BOLD, 38));
        jLabel4.setForeground(Color.WHITE);
        jLabel4.setAlignmentX(Component.LEFT_ALIGNMENT);

        jLabel5 = new JLabel("DA QUÍMICA");
        jLabel5.setFont(new Font("Segoe UI", Font.BOLD, 22));
        jLabel5.setForeground(corDestaque);
        jLabel5.setAlignmentX(Component.LEFT_ALIGNMENT);

        jLabel6 = new JLabel("Bem-vindo(a)!");
        jLabel6.setFont(new Font("Segoe UI", Font.BOLD, 30));
        jLabel6.setForeground(Color.WHITE);
        jLabel6.setAlignmentX(Component.LEFT_ALIGNMENT);

        jLabel7 = new JLabel("Entre para acessar a experiência");
        jLabel7.setFont(new Font("Segoe UI", Font.PLAIN, 17));
        jLabel7.setForeground(Color.WHITE);
        jLabel7.setAlignmentX(Component.LEFT_ALIGNMENT);

        jLabel8 = new JLabel("que transforma conhecimento em desafio.");
        jLabel8.setFont(new Font("Segoe UI", Font.PLAIN, 17));
        jLabel8.setForeground(Color.WHITE);
        jLabel8.setAlignmentX(Component.LEFT_ALIGNMENT);

        jLabel1 = new JLabel();

        textos.add(jLabel3);
        textos.add(Box.createVerticalStrut(2));
        textos.add(jLabel4);
        textos.add(Box.createVerticalStrut(2));
        textos.add(jLabel5);
        textos.add(Box.createVerticalStrut(70));
        textos.add(jLabel6);
        textos.add(Box.createVerticalStrut(26));
        textos.add(jLabel7);
        textos.add(Box.createVerticalStrut(10));
        textos.add(jLabel8);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        painel.add(textos, gbc);

        return painel;
    }

    private JPanel criarPainelLogin() {
        JPanel painel = new JPanel();
        painel.setBackground(Color.WHITE);
        painel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(204, 204, 204)),
                new EmptyBorder(28, 38, 26, 38)
        ));
        painel.setPreferredSize(new Dimension(430, 385));
        painel.setMinimumSize(new Dimension(390, 360));
        painel.setLayout(new BoxLayout(painel, BoxLayout.Y_AXIS));

        jLabelLogin = new JLabel("Faça seu login");
        jLabelLogin.setFont(new Font("Segoe UI", Font.BOLD, 24));
        jLabelLogin.setAlignmentX(Component.CENTER_ALIGNMENT);

        jLabel2 = new JLabel("Use suas credenciais para continuar");
        jLabel2.setForeground(new Color(153, 153, 153));
        jLabel2.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        jLabel2.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel painelCampos = new JPanel();
        painelCampos.setOpaque(false);
        painelCampos.setLayout(new BoxLayout(painelCampos, BoxLayout.Y_AXIS));
        painelCampos.setAlignmentX(Component.CENTER_ALIGNMENT);
        painelCampos.setMaximumSize(new Dimension(300, 170));
        painelCampos.setPreferredSize(new Dimension(300, 170));

        jLabelEmail = criarLabelCampo("E-mail");
        jTextFieldEmail = criarCampoTexto();

        jLabelSenha = criarLabelCampo("Senha");

        txtSenha = new JPasswordField();
        txtSenha.setMaximumSize(new Dimension(300, 32));
        txtSenha.setPreferredSize(new Dimension(300, 32));
        txtSenha.setAlignmentX(Component.LEFT_ALIGNMENT);
        txtSenha.setEchoChar('•');

        mostrarSenha = new JToggleButton();
        mostrarSenha.setPreferredSize(new Dimension(16, 16));
        mostrarSenha.setMaximumSize(new Dimension(16, 16));
        mostrarSenha.addActionListener(this::mostrarSenhaActionPerformed);

        jLabelMostrarSenha = new JLabel("Mostrar senha");
        jLabelMostrarSenha.setFont(new Font("Segoe UI", Font.PLAIN, 11));

        JPanel painelMostrarSenha = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        painelMostrarSenha.setOpaque(false);
        painelMostrarSenha.setMaximumSize(new Dimension(300, 22));
        painelMostrarSenha.setAlignmentX(Component.LEFT_ALIGNMENT);
        painelMostrarSenha.add(mostrarSenha);
        painelMostrarSenha.add(Box.createHorizontalStrut(8));
        painelMostrarSenha.add(jLabelMostrarSenha);

        painelCampos.add(jLabelEmail);
        painelCampos.add(Box.createVerticalStrut(6));
        painelCampos.add(jTextFieldEmail);
        painelCampos.add(Box.createVerticalStrut(16));

        painelCampos.add(jLabelSenha);
        painelCampos.add(Box.createVerticalStrut(6));
        painelCampos.add(txtSenha);
        painelCampos.add(Box.createVerticalStrut(8));
        painelCampos.add(painelMostrarSenha);

        entrar = new JButton("Entrar");
        entrar.setBackground(corPrincipal);
        entrar.setForeground(Color.WHITE);
        entrar.setFont(new Font("Segoe UI", Font.BOLD, 12));
        entrar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        entrar.setMaximumSize(new Dimension(300, 34));
        entrar.setPreferredSize(new Dimension(300, 34));
        entrar.setAlignmentX(Component.CENTER_ALIGNMENT);
        entrar.addActionListener(this::entrarActionPerformed);

        jButtonRedirecionamentoCadastro = new JButton("Ainda não possui login? Faça o cadastro aqui");
        jButtonRedirecionamentoCadastro.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        jButtonRedirecionamentoCadastro.setForeground(new Color(51, 51, 255));
        jButtonRedirecionamentoCadastro.setBorder(null);
        jButtonRedirecionamentoCadastro.setContentAreaFilled(false);
        jButtonRedirecionamentoCadastro.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jButtonRedirecionamentoCadastro.setAlignmentX(Component.CENTER_ALIGNMENT);
        jButtonRedirecionamentoCadastro.addActionListener(this::jButtonRedirecionamentoCadastroActionPerformed);

        painel.add(jLabelLogin);
        painel.add(Box.createVerticalStrut(8));
        painel.add(jLabel2);
        painel.add(Box.createVerticalStrut(34));
        painel.add(painelCampos);
        painel.add(Box.createVerticalStrut(24));
        painel.add(entrar);
        painel.add(Box.createVerticalStrut(12));
        painel.add(jButtonRedirecionamentoCadastro);

        return painel;
    }

    private JLabel criarLabelCampo(String texto) {
        JLabel label = new JLabel(texto);
        label.setFont(new Font("Segoe UI", Font.BOLD, 12));
        label.setAlignmentX(Component.LEFT_ALIGNMENT);
        label.setMaximumSize(new Dimension(300, 18));
        return label;
    }

    private JTextField criarCampoTexto() {
        JTextField campo = new JTextField();
        campo.setMaximumSize(new Dimension(300, 32));
        campo.setPreferredSize(new Dimension(300, 32));
        campo.setAlignmentX(Component.LEFT_ALIGNMENT);
        return campo;
    }

    private void entrarActionPerformed(java.awt.event.ActionEvent evt) {
        String email = jTextFieldEmail.getText();
        String senha = new String(txtSenha.getPassword());

        if (email.isBlank() || senha.isBlank()) {
            javax.swing.JOptionPane.showMessageDialog(
                    this,
                    "Preencha todos os campos!",
                    "Aviso",
                    javax.swing.JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        try {
            UsuarioRepository repository = new UsuarioRepository();

            Usuario aluno = repository.buscarAlunoPorEmail(email);
            if (aluno != null && aluno.getSenha().equals(senha)) {
                Sessao.login(aluno);
                new TelaMenuAlunos().setVisible(true);
                this.dispose();
                return;
            }

            Usuario professor = repository.buscarProfessorPorEmail(email);
            if (professor != null && professor.getSenha().equals(senha)) {
                Sessao.login(professor);
                new TelaMenuProfessores().setVisible(true);
                this.dispose();
                return;
            }

            javax.swing.JOptionPane.showMessageDialog(
                    this,
                    "E-mail ou senha incorretos.",
                    "Erro",
                    javax.swing.JOptionPane.ERROR_MESSAGE
            );

        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(
                    this,
                    "Erro ao conectar: " + e.getMessage(),
                    "Erro",
                    javax.swing.JOptionPane.ERROR_MESSAGE
            );
        }
    }

    private void mostrarSenhaActionPerformed(java.awt.event.ActionEvent evt) {
        if (mostrarSenha.isSelected()) {
            txtSenha.setEchoChar((char) 0);
        } else {
            txtSenha.setEchoChar('•');
        }
    }

    private void jButtonRedirecionamentoCadastroActionPerformed(java.awt.event.ActionEvent evt) {
        new TelaCadastro().setVisible(true);
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

        java.awt.EventQueue.invokeLater(() -> new TelaLogin().setVisible(true));
    }
}