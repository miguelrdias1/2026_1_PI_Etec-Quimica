package br.com.pi_2026_1_etec.dao;

import br.com.pi_2026_1_etec.config.ConexaoBD;
import br.com.pi_2026_1_etec.model.Pergunta;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class PerguntaDAO {

    public List<Pergunta> listarPorNivel(int idNivel) throws SQLException {
        String sql = "SELECT * FROM pergunta WHERE id_nivel = ?";
        List<Pergunta> lista = new ArrayList<>();
        try (Connection con = ConexaoBD.obterConexao();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idNivel);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    lista.add(mapear(rs));
                }
            }
        }
        return lista;
    }

    public Pergunta buscarPorId(int idPergunta) throws SQLException {
        String sql = "SELECT * FROM pergunta WHERE id_pergunta = ?";
        try (Connection con = ConexaoBD.obterConexao();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idPergunta);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) return mapear(rs);
            }
        }
        return null;
    }

    public void inserir(Pergunta p) throws SQLException {
        String sql = "INSERT INTO pergunta (id_pergunta, texto, id_imagem, id_tema, id_material, id_nivel, id_sistema, tipo_pergunta) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection con = ConexaoBD.obterConexao();
             PreparedStatement ps = con.prepareStatement(sql)) {
            int proximoId = obterProximoIdPergunta(con);
            ps.setInt(1, proximoId);
            ps.setString(2, p.getTexto());
            ps.setInt(3, p.getIdImagem());
            ps.setInt(4, p.getIdTema());
            ps.setInt(5, p.getIdMaterial());
            ps.setInt(6, p.getIdNivel());
            ps.setInt(7, p.getIdSistema());
            ps.setString(8, p.getTipoPergunta());
            ps.executeUpdate();
            p.setIdPergunta(proximoId);
        }
    }

    public void atualizar(Pergunta p) throws SQLException {
        String sql = "UPDATE pergunta SET texto = ?, id_imagem = ?, id_tema = ?, id_material = ?, id_nivel = ?, id_sistema = ?, tipo_pergunta = ? WHERE id_pergunta = ?";
        try (Connection con = ConexaoBD.obterConexao();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, p.getTexto());
            ps.setInt(2, p.getIdImagem());
            ps.setInt(3, p.getIdTema());
            ps.setInt(4, p.getIdMaterial());
            ps.setInt(5, p.getIdNivel());
            ps.setInt(6, p.getIdSistema());
            ps.setString(7, p.getTipoPergunta());
            ps.setInt(8, p.getIdPergunta());
            ps.executeUpdate();
        }
    }

    public void deletar(int idPergunta) throws SQLException {
        String sql = "DELETE FROM pergunta WHERE id_pergunta = ?";
        try (Connection con = ConexaoBD.obterConexao();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idPergunta);
            ps.executeUpdate();
        }
    }

    public int contarPerguntas() {
        String sql = "SELECT COUNT(*) AS total FROM pergunta";
        try (Connection con = ConexaoBD.obterConexao();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            return rs.next() ? rs.getInt("total") : 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static void vincularImagem(int idPergunta, int idImagem) {
        String sql = "UPDATE pergunta SET id_imagem = ? WHERE id_pergunta = ?";
        try (Connection con = ConexaoBD.obterConexao();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idImagem);
            ps.setInt(2, idPergunta);
            ps.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao vincular imagem: " + e.getMessage());
        }
    }

    public static void removerImagem(int idPergunta) {
        String sql = "UPDATE pergunta SET id_imagem = NULL WHERE id_pergunta = ?";
        try (Connection con = ConexaoBD.obterConexao();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idPergunta);
            ps.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao remover imagem: " + e.getMessage());
        }
    }

    private Pergunta mapear(ResultSet rs) throws SQLException {
        Pergunta p = new Pergunta();
        p.setIdPergunta(rs.getInt("id_pergunta"));
        p.setTexto(rs.getString("texto"));
        p.setIdImagem(rs.getInt("id_imagem"));
        p.setIdTema(rs.getInt("id_tema"));
        p.setIdMaterial(rs.getInt("id_material"));
        p.setIdNivel(rs.getInt("id_nivel"));
        p.setIdSistema(rs.getInt("id_sistema"));
        p.setTipoPergunta(rs.getString("tipo_pergunta"));
        return p;
    }
    private int obterProximoIdPergunta(Connection con) throws SQLException {
        String sql = "SELECT COALESCE(MAX(id_pergunta), 0) + 1 AS proximo_id FROM pergunta";
        try (PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                return rs.getInt("proximo_id");
            }
        }
        return 1;
    }}