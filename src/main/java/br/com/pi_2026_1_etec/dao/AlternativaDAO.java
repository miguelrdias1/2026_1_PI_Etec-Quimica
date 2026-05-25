package br.com.pi_2026_1_etec.dao;

import br.com.pi_2026_1_etec.config.ConexaoBD;
import br.com.pi_2026_1_etec.model.Alternativa;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlternativaDAO {

    public void inserir(Alternativa a) throws SQLException {
        String sql = "INSERT INTO alternativa (texto, correta, errada, id_imagem, id_pergunta) VALUES (?, ?, ?, ?, ?)";
        try (Connection con = ConexaoBD.obterConexao();
             PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, a.getTexto());
            ps.setInt(2, a.isCorreta() ? 1 : 0);
            ps.setInt(3, a.isErrada() ? 1 : 0);
            ps.setInt(4, a.getIdImagem());
            ps.setInt(5, a.getIdPergunta());
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) a.setIdAlternativa(rs.getInt(1));
            }
        }
    }

    public List<Alternativa> listarPorPergunta(int idPergunta) throws SQLException {
        String sql = "SELECT * FROM alternativa WHERE id_pergunta = ?";
        List<Alternativa> lista = new ArrayList<>();
        try (Connection con = ConexaoBD.obterConexao();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idPergunta);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Alternativa a = new Alternativa();
                    a.setIdAlternativa(rs.getInt("id_alternativa"));
                    a.setTexto(rs.getString("texto"));
                    a.setCorreta(rs.getInt("correta") == 1);
                    a.setErrada(rs.getInt("errada") == 1);
                    a.setIdImagem(rs.getInt("id_imagem"));
                    a.setIdPergunta(rs.getInt("id_pergunta"));
                    lista.add(a);
                }
            }
        }
        return lista;
    }

    public Alternativa buscarPorId(int idAlternativa) throws SQLException {
        String sql = "SELECT * FROM alternativa WHERE id_alternativa = ?";
        try (Connection con = ConexaoBD.obterConexao();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idAlternativa);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Alternativa a = new Alternativa();
                    a.setIdAlternativa(rs.getInt("id_alternativa"));
                    a.setTexto(rs.getString("texto"));
                    a.setCorreta(rs.getInt("correta") == 1);
                    a.setErrada(rs.getInt("errada") == 1);
                    a.setIdImagem(rs.getInt("id_imagem"));
                    a.setIdPergunta(rs.getInt("id_pergunta"));
                    return a;
                }
            }
        }
        return null;
    }

    public void atualizar(Alternativa a) throws SQLException {
        String sql = "UPDATE alternativa SET texto = ?, correta = ?, errada = ?, id_imagem = ? WHERE id_alternativa = ?";
        try (Connection con = ConexaoBD.obterConexao();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, a.getTexto());
            ps.setInt(2, a.isCorreta() ? 1 : 0);
            ps.setInt(3, a.isErrada() ? 1 : 0);
            ps.setInt(4, a.getIdImagem());
            ps.setInt(5, a.getIdAlternativa());
            ps.executeUpdate();
        }
    }

    public void deletar(int idAlternativa) throws SQLException {
        String sql = "DELETE FROM alternativa WHERE id_alternativa = ?";
        try (Connection con = ConexaoBD.obterConexao();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idAlternativa);
            ps.executeUpdate();
        }
    }
}