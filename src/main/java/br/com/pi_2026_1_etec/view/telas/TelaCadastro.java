package br.com.pi_2026_1_etec.view.telas;

import br.com.pi_2026_1_etec.service.UsuarioService;

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

public class TelaCadastro extends JFrame {

    private static final java.util.logging.Logger logger =
            java.util.logging.Logger.getLogger(TelaCadastro.class.getName());

    private final Color corPrincipal = new Color(146, 25, 19);
    private final Color corDestaque = new Color(230, 65, 55);

    private JButton jButtonCriarConta;
    private JButton jButtonVoltarLogin;

    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JLabel jLabelCadastro;
    private JLabel jLabelEmail;
    private JLabel jLabelMostrarSenha;
    private JLabel jLabelNome;
    private JLabel jLabelSenha;

    private JLayeredPane jLayeredPane1;
    private JPanel jPanelAzul;
    private JPanel jPanelLogin;
    private JPanel jPanelVermelho;

    private JToggleButton jToggleButtonMostrarSenha;

    private JTextField txtEmail;
    private JTextField txtNome;
    private JPasswordField txtSenha;

    public TelaCadastro() {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    private void initComponents() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Cadastro");
        setMinimumSize(new Dimension(900, 550));
        setResizable(true);

        jLayeredPane1 = new JLayeredPane();

        jPanelVermelho = new JPanel(new BorderLayout());
        jPanelVermelho.setBackground(Color.WHITE);

        jPanelAzul = criarPainelLateral();
        jPanelLogin = criarPainelCadastro();

        JPanel painelConteudo = new JPanel(new BorderLayout());
        painelConteudo.setBackground(Color.WHITE);

        painelConteudo.add(jPanelAzul, BorderLayout.WEST);

        JPanel painelCentro = new JPanel(new GridBagLayout());
        painelCentro.setBackground(Color.WHITE);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.anchor = GridBagConstraints.CENTER;

        painelCentro.add(jPanelLogin, gbc);

        painelConteudo.add(painelCentro, BorderLayout.CENTER);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(painelConteudo, BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }

    private JPanel criarPainelLateral() {
        JPanel painel = new JPanel();
        painel.setBackground(corPrincipal);
        painel.setPreferredSize(new Dimension(340, 600));
        painel.setMinimumSize(new Dimension(300, 500));
        painel.setLayout(new GridBagLayout());

        JPanel textos = new JPanel();
        textos.setOpaque(false);
        textos.setLayout(new BoxLayout(textos, BoxLayout.Y_AXIS));
        textos.setBorder(new EmptyBorder(20, 30, 20, 30));

        jLabel3 = new JLabel("O GRANDE");
        jLabel3.setFont(new Font("Segoe UI", Font.BOLD, 20));
        jLabel3.setForeground(corDestaque);
        jLabel3.setAlignmentX(Component.LEFT_ALIGNMENT);

        jLabel2 = new JLabel("DESAFIO");
        jLabel2.setFont(new Font("Segoe UI", Font.BOLD, 34));
        jLabel2.setForeground(Color.WHITE);
        jLabel2.setAlignmentX(Component.LEFT_ALIGNMENT);

        jLabel4 = new JLabel("DA QUÍMICA");
        jLabel4.setFont(new Font("Segoe UI", Font.BOLD, 20));
        jLabel4.setForeground(corDestaque);
        jLabel4.setAlignmentX(Component.LEFT_ALIGNMENT);

        jLabel5 = new JLabel("Bem-vindo(a)!");
        jLabel5.setFont(new Font("Segoe UI", Font.BOLD, 24));
        jLabel5.setForeground(Color.WHITE);
        jLabel5.setAlignmentX(Component.LEFT_ALIGNMENT);

        jLabel6 = new JLabel("Cadastre-se para acessar a experiência que");
        jLabel6.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        jLabel6.setForeground(Color.WHITE);
        jLabel6.setAlignmentX(Component.LEFT_ALIGNMENT);

        jLabel7 = new JLabel("transforma conhecimento em desafio.");
        jLabel7.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        jLabel7.setForeground(Color.WHITE);
        jLabel7.setAlignmentX(Component.LEFT_ALIGNMENT);

        textos.add(jLabel3);
        textos.add(Box.createVerticalStrut(2));
        textos.add(jLabel2);
        textos.add(Box.createVerticalStrut(2));
        textos.add(jLabel4);
        textos.add(Box.createVerticalStrut(60));
        textos.add(jLabel5);
        textos.add(Box.createVerticalStrut(22));
        textos.add(jLabel6);
        textos.add(Box.createVerticalStrut(6));
        textos.add(jLabel7);

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

    private JPanel criarPainelCadastro() {
        JPanel painel = new JPanel();
        painel.setBackground(Color.WHITE);
        painel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(204, 204, 204)),
                new EmptyBorder(28, 38, 26, 38)
        ));
        painel.setPreferredSize(new Dimension(430, 440));
        painel.setMinimumSize(new Dimension(390, 420));
        painel.setLayout(new BoxLayout(painel, BoxLayout.Y_AXIS));

        jLabelCadastro = new JLabel("Faça seu cadastro");
        jLabelCadastro.setFont(new Font("Segoe UI", Font.BOLD, 24));
        jLabelCadastro.setAlignmentX(Component.CENTER_ALIGNMENT);

        jLabel1 = new JLabel("Informe as suas credenciais para continuar");
        jLabel1.setForeground(new Color(153, 153, 153));
        jLabel1.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        jLabel1.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel painelCampos = new JPanel();
        painelCampos.setOpaque(false);
        painelCampos.setLayout(new BoxLayout(painelCampos, BoxLayout.Y_AXIS));
        painelCampos.setAlignmentX(Component.CENTER_ALIGNMENT);
        painelCampos.setMaximumSize(new Dimension(300, 260));
        painelCampos.setPreferredSize(new Dimension(300, 260));

        jLabelNome = criarLabelCampo("Nome");
        txtNome = criarCampoTexto();

        jLabelEmail = criarLabelCampo("E-mail");
        txtEmail = criarCampoTexto();
        txtEmail.addActionListener(this::txtEmailActionPerformed);

        jLabelSenha = criarLabelCampo("Senha");
        txtSenha = new JPasswordField();
        txtSenha.setMaximumSize(new Dimension(300, 32));
        txtSenha.setPreferredSize(new Dimension(300, 32));
        txtSenha.setAlignmentX(Component.LEFT_ALIGNMENT);
        txtSenha.setEchoChar('•');

        jToggleButtonMostrarSenha = new JToggleButton();
        jToggleButtonMostrarSenha.setPreferredSize(new Dimension(16, 16));
        jToggleButtonMostrarSenha.setMaximumSize(new Dimension(16, 16));
        jToggleButtonMostrarSenha.addActionListener(this::jToggleButtonMostrarSenhaActionPerformed);

        jLabelMostrarSenha = new JLabel("Mostrar senha");
        jLabelMostrarSenha.setFont(new Font("Segoe UI", Font.PLAIN, 11));

        JPanel painelMostrarSenha = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        painelMostrarSenha.setOpaque(false);
        painelMostrarSenha.setMaximumSize(new Dimension(300, 22));
        painelMostrarSenha.setAlignmentX(Component.LEFT_ALIGNMENT);
        painelMostrarSenha.add(jToggleButtonMostrarSenha);
        painelMostrarSenha.add(Box.createHorizontalStrut(8));
        painelMostrarSenha.add(jLabelMostrarSenha);

        painelCampos.add(jLabelNome);
        painelCampos.add(Box.createVerticalStrut(6));
        painelCampos.add(txtNome);
        painelCampos.add(Box.createVerticalStrut(16));

        painelCampos.add(jLabelEmail);
        painelCampos.add(Box.createVerticalStrut(6));
        painelCampos.add(txtEmail);
        painelCampos.add(Box.createVerticalStrut(16));

        painelCampos.add(jLabelSenha);
        painelCampos.add(Box.createVerticalStrut(6));
        painelCampos.add(txtSenha);
        painelCampos.add(Box.createVerticalStrut(8));
        painelCampos.add(painelMostrarSenha);

        jButtonCriarConta = new JButton("Criar conta");
        jButtonCriarConta.setBackground(corPrincipal);
        jButtonCriarConta.setForeground(Color.WHITE);
        jButtonCriarConta.setFont(new Font("Segoe UI", Font.BOLD, 12));
        jButtonCriarConta.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jButtonCriarConta.setMaximumSize(new Dimension(300, 34));
        jButtonCriarConta.setPreferredSize(new Dimension(300, 34));
        jButtonCriarConta.setAlignmentX(Component.CENTER_ALIGNMENT);
        jButtonCriarConta.addActionListener(this::jButtonCriarContaActionPerformed);

        jButtonVoltarLogin = new JButton("Voltar para a página de login");
        jButtonVoltarLogin.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        jButtonVoltarLogin.setForeground(new Color(51, 51, 255));
        jButtonVoltarLogin.setBorder(null);
        jButtonVoltarLogin.setContentAreaFilled(false);
        jButtonVoltarLogin.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jButtonVoltarLogin.setAlignmentX(Component.CENTER_ALIGNMENT);
        jButtonVoltarLogin.addActionListener(this::jButtonVoltarLoginActionPerformed);

        painel.add(jLabelCadastro);
        painel.add(Box.createVerticalStrut(8));
        painel.add(jLabel1);
        painel.add(Box.createVerticalStrut(34));
        painel.add(painelCampos);
        painel.add(Box.createVerticalStrut(24));
        painel.add(jButtonCriarConta);
        painel.add(Box.createVerticalStrut(12));
        painel.add(jButtonVoltarLogin);

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

    private void jToggleButtonMostrarSenhaActionPerformed(java.awt.event.ActionEvent evt) {
        if (jToggleButtonMostrarSenha.isSelected()) {
            txtSenha.setEchoChar((char) 0);
        } else {
            txtSenha.setEchoChar('•');
        }
    }

    private void jButtonCriarContaActionPerformed(java.awt.event.ActionEvent evt) {
        String nome = txtNome.getText();
        String email = txtEmail.getText();
        String senha = new String(txtSenha.getPassword());

        UsuarioService service = new UsuarioService();
        String resultado = service.cadastrar(nome, email, senha);

        if (resultado.equals("sucesso")) {
            javax.swing.JOptionPane.showMessageDialog(this, "Cadastro realizado com sucesso!");
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, resultado);
        }
    }

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {
        // Mantido para preservar função existente.
    }

    private void jButtonVoltarLoginActionPerformed(java.awt.event.ActionEvent evt) {
        new TelaLogin().setVisible(true);
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

        java.awt.EventQueue.invokeLater(() -> new TelaCadastro().setVisible(true));
    }
}