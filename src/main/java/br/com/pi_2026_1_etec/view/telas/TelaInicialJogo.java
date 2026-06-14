package br.com.pi_2026_1_etec.view.telas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class TelaInicialJogo extends JFrame {

    private static final java.util.logging.Logger logger =
            java.util.logging.Logger.getLogger(TelaInicialJogo.class.getName());

    private JButton jButtonJogar;
    private JLabel jLabelTitulo1;
    private JLabel jLabelTitulo2;
    private JLabel jLabelSubtitulo;
    private JLabel jLabelLogo;
    private JLabel jLabelImagemFundo;
    private JPanel jPanel1;

    private final Color corPrincipal = new Color(7, 92, 110);

    public TelaInicialJogo() {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    private void initComponents() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("O Grande Desafio da Química");
        setMinimumSize(new Dimension(900, 550));

        jPanel1 = new JPanelComImagemFundo("/ImagensEtec/telaInicio.png");
        jPanel1.setLayout(new BorderLayout());
        jPanel1.setBorder(new EmptyBorder(40, 45, 35, 45));

        JPanel painelConteudo = new JPanel(new BorderLayout());
        painelConteudo.setOpaque(false);

        JPanel painelTextos = criarPainelTextos();
        JPanel painelLogo = criarPainelLogo();

        painelConteudo.add(painelTextos, BorderLayout.WEST);
        painelConteudo.add(painelLogo, BorderLayout.SOUTH);

        jPanel1.add(painelConteudo, BorderLayout.CENTER);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(jPanel1, BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }

    private JPanel criarPainelTextos() {
        JPanel painelContainer = new JPanel(new GridBagLayout());
        painelContainer.setOpaque(false);
        painelContainer.setPreferredSize(new Dimension(460, 400));

        JPanel painelTextos = new JPanel();
        painelTextos.setOpaque(false);
        painelTextos.setLayout(new BoxLayout(painelTextos, BoxLayout.Y_AXIS));

        jLabelTitulo1 = new JLabel("O GRANDE DESAFIO");
        jLabelTitulo1.setFont(new Font("Segoe UI", Font.BOLD, 38));
        jLabelTitulo1.setForeground(corPrincipal);
        jLabelTitulo1.setAlignmentX(Component.CENTER_ALIGNMENT);

        jLabelTitulo2 = new JLabel("DA QUÍMICA");
        jLabelTitulo2.setFont(new Font("Segoe UI", Font.BOLD, 38));
        jLabelTitulo2.setForeground(corPrincipal);
        jLabelTitulo2.setAlignmentX(Component.CENTER_ALIGNMENT);

        jLabelSubtitulo = new JLabel("Uma forma mais divertida de estudar Química");
        jLabelSubtitulo.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        jLabelSubtitulo.setForeground(Color.BLACK);
        jLabelSubtitulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        jButtonJogar = new JButton("JOGAR");
        jButtonJogar.setBackground(corPrincipal);
        jButtonJogar.setForeground(Color.WHITE);
        jButtonJogar.setFont(new Font("Segoe UI", Font.BOLD, 18));
        jButtonJogar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jButtonJogar.setFocusPainted(false);
        jButtonJogar.setPreferredSize(new Dimension(150, 42));
        jButtonJogar.setMaximumSize(new Dimension(150, 42));
        jButtonJogar.setAlignmentX(Component.CENTER_ALIGNMENT);
        jButtonJogar.addActionListener(this::jButtonJogarActionPerformed);

        painelTextos.add(jLabelTitulo1);
        painelTextos.add(Box.createVerticalStrut(4));
        painelTextos.add(jLabelTitulo2);
        painelTextos.add(Box.createVerticalStrut(14));
        painelTextos.add(jLabelSubtitulo);
        painelTextos.add(Box.createVerticalStrut(48));
        painelTextos.add(jButtonJogar);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0, 0, 80, 0);

        painelContainer.add(painelTextos, gbc);

        return painelContainer;
    }

    private JPanel criarPainelLogo() {
        JPanel painelLogo = new JPanel(new BorderLayout());
        painelLogo.setOpaque(false);

        jLabelLogo = new JLabel();

        try {
            jLabelLogo.setIcon(new ImageIcon(getClass().getResource("/ImagensEtec/LogoCPS.png")));
        } catch (Exception e) {
            jLabelLogo.setText("");
        }

        painelLogo.add(jLabelLogo, BorderLayout.WEST);

        return painelLogo;
    }

    private void jButtonJogarActionPerformed(java.awt.event.ActionEvent evt) {
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

        java.awt.EventQueue.invokeLater(() -> new TelaInicialJogo().setVisible(true));
    }

    private static class JPanelComImagemFundo extends JPanel {

        private Image imagemFundo;

        public JPanelComImagemFundo(String caminhoImagem) {
            try {
                imagemFundo = new ImageIcon(getClass().getResource(caminhoImagem)).getImage();
            } catch (Exception e) {
                imagemFundo = null;
                setBackground(Color.WHITE);
            }
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            if (imagemFundo != null) {
                g.drawImage(imagemFundo, 0, 0, getWidth(), getHeight(), this);
            }
        }
    }
}