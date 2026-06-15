package br.com.pi_2026_1_etec.repository;

import br.com.pi_2026_1_etec.config.ConexaoBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DicaRepository {

    public String buscarTextoPorQuestao(int questaoId) {

        String sql = "SELECT texto FROM dicas WHERE id_pergunta = ?";
        String texto = null;

        try (Connection c = ConexaoBD.obterConexao();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setInt(1, questaoId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                texto = rs.getString("texto");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return texto;
    }
}
