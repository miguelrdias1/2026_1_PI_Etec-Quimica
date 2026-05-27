package br.com.pi_2026_1_etec.dao;

import br.com.pi_2026_1_etec.config.ConexaoBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ImagemDAO {
    
    public static List<Object[]> buscarTodasImagensComCaminho() {
        List<Object[]> lista = new ArrayList<>();
        String sql = "SELECT id_imagem, caminho_imagem FROM imagem ORDER BY caminho_imagem";
 
        try (Connection con = ConexaoBD.obterConexao();
             PreparedStatement stmt = con.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
 
            while (rs.next()) {
                Object[] linha = new Object[2];
                linha[0] = rs.getInt("id_imagem");
                linha[1] = rs.getString("caminho_imagem");
                lista.add(linha);
            }
 
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar imagens: " + e.getMessage());
        }
 
        return lista;
    }

    public static String buscarCaminhoImagem(int idPergunta) {

        String sql = "SELECT i.caminho_imagem " +
                     "FROM pergunta p " +
                     "JOIN imagem i ON p.id_imagem = i.id_imagem " + 
                     "WHERE p.id_pergunta = ?";

        try (Connection con = ConexaoBD.obterConexao();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, idPergunta);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return rs.getString("caminho_imagem"); 
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar imagem: " + e.getMessage());
        }

        return null; 
    }

    public static void atualizarCaminhoImagem(int idImagem, String novoCaminho) {

        String sql = "UPDATE imagem SET caminho_imagem = ? WHERE id_imagem = ?";

        try (Connection con = ConexaoBD.obterConexao();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, novoCaminho);
            stmt.setInt(2, idImagem);
            stmt.executeUpdate();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar imagem: " + e.getMessage());
        }
    }
    
    public static int buscarIdImagem(int idPergunta) {

        String sql = "SELECT id_imagem FROM pergunta WHERE id_pergunta = ?";

        try (Connection con = ConexaoBD.obterConexao();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, idPergunta);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return rs.getInt("id_imagem");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar id da imagem: " + e.getMessage());
        }

        return -1; 
    }
}
