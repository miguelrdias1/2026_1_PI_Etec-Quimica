package br.com.pi_2026_1_etec.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.pi_2026_1_etec.config.ConexaoBD;
import br.com.pi_2026_1_etec.model.Partida;

public class PartidaDAO {

    public void inserir(Partida p) throws SQLException {
        String sql = "INSERT INTO partida (email_aluno, data, acertos, erros) VALUES (?, ?, ?, ?)";
        try (Connection con = ConexaoBD.obterConexao();
             PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, p.getEmailAluno());
            ps.setObject(2, p.getData());
            ps.setInt(3, p.getAcertos());
            ps.setInt(4, p.getErros());
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) p.setIdPartida(rs.getInt(1));
            }
        }
    }

    public List<Partida> listarPorAluno(String emailAluno) throws SQLException {
        String sql = "SELECT * FROM partida WHERE email_aluno = ? ORDER BY data DESC";
        List<Partida> lista = new ArrayList<>();
        try (Connection con = ConexaoBD.obterConexao();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, emailAluno);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    lista.add(mapear(rs));
                }
            }
        }
        return lista;
    }

    private Partida mapear(ResultSet rs) throws SQLException {
        Partida p = new Partida();
        p.setIdPartida(rs.getInt("id_partida"));
        p.setEmailAluno(rs.getString("email_aluno"));
        p.setData(rs.getObject("data", java.time.LocalDateTime.class));
        p.setAcertos(rs.getInt("acertos"));
        p.setErros(rs.getInt("erros"));
        return p;
    }
}