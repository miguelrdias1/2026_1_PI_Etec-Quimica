package br.com.pi_2026_1_etec.dao;

import br.com.pi_2026_1_etec.config.ConexaoBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class PerguntaDAO {

    public static void vincularImagem(int idPergunta, int idImagem) {

        String sql = "UPDATE pergunta SET id_imagem = ? WHERE id_pergunta = ?";

        try (Connection con = ConexaoBD.obterConexao();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, idImagem);
            stmt.setInt(2, idPergunta);
            stmt.executeUpdate();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao vincular imagem: " + e.getMessage());
        }
    }

    public static void removerImagem(int idPergunta) {

        String sql = "UPDATE pergunta SET id_imagem = NULL WHERE id_pergunta = ?";

        try (Connection con = ConexaoBD.obterConexao();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, idPergunta);
            stmt.executeUpdate();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao remover imagem: " + e.getMessage());
        }
    }
}