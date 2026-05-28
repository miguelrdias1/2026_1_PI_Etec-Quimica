package br.com.pi_2026_1_etec.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.pi_2026_1_etec.config.ConexaoBD;
import br.com.pi_2026_1_etec.model.Usuario;

public class UsuarioRepository {

    public void cadastrarAluno(Usuario usuario) throws SQLException {
        String sqlPessoa = "INSERT INTO pessoa (nome, senha) VALUES (?, ?)";
        String sqlAluno = "INSERT INTO aluno (pessoa_idpessoa, email) VALUES (?, ?)";
        String sqlProfessor = "INSERT INTO professor (pessoa_idpessoa, email) VALUES (?, ?)";
        
        boolean isProfessor = usuario.getEmail().endsWith("@cps.sp.gov.br")
                   && !usuario.getEmail().endsWith("@aluno.cps.sp.gov.br");

        String sqlPerfil = isProfessor ? sqlProfessor : sqlAluno;

        try (Connection con = ConexaoBD.obterConexao()) {
            con.setAutoCommit(false);

            try (PreparedStatement psPessoa = con.prepareStatement(sqlPessoa, PreparedStatement.RETURN_GENERATED_KEYS)) {
                psPessoa.setString(1, usuario.getNome());
                psPessoa.setString(2, usuario.getSenha());
                psPessoa.executeUpdate();

                ResultSet chave = psPessoa.getGeneratedKeys();
                if (chave.next()) {
                    int idPessoa = chave.getInt(1);

                    try (PreparedStatement psAluno = con.prepareStatement(sqlAluno)) {
                        psAluno.setInt(1, idPessoa);
                        psAluno.setString(2, usuario.getEmail());
                        psAluno.executeUpdate();
                    }
                }
            }

            con.commit();
        }
    }

    public void cadastrarProfessor(Usuario usuario) throws SQLException {
        String sqlPessoa = "INSERT INTO pessoa (nome, senha) VALUES (?, ?)";
        String sqlProfessor = "INSERT INTO professor (pessoa_idpessoa, email) VALUES (?, ?)";

        try (Connection con = ConexaoBD.obterConexao()) {
            con.setAutoCommit(false);

            try (PreparedStatement psPessoa = con.prepareStatement(sqlPessoa, PreparedStatement.RETURN_GENERATED_KEYS)) {
                psPessoa.setString(1, usuario.getNome());
                psPessoa.setString(2, usuario.getSenha());
                psPessoa.executeUpdate();

                ResultSet chave = psPessoa.getGeneratedKeys();
                if (chave.next()) {
                    int idPessoa = chave.getInt(1);

                    try (PreparedStatement psProfessor = con.prepareStatement(sqlProfessor)) {
                        psProfessor.setInt(1, idPessoa);
                        psProfessor.setString(2, usuario.getEmail());
                        psProfessor.executeUpdate();
                    }
                }
            }

            con.commit();
        }
    }

    public boolean emailJaExiste(String email) throws SQLException {
        String sql = "SELECT email FROM aluno WHERE email = ?";
        try (Connection con = ConexaoBD.obterConexao();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        }
    }
    
    public Usuario buscarAlunoPorEmail(String email) throws SQLException {
    String sql = "SELECT p.idpessoa, p.nome, p.senha, a.email " +
                 "FROM pessoa p JOIN aluno a ON a.pessoa_idpessoa = p.idpessoa " +
                 "WHERE a.email = ?";
    try (Connection con = ConexaoBD.obterConexao();
         PreparedStatement ps = con.prepareStatement(sql)) {
        ps.setString(1, email);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            Usuario u = new Usuario();
            u.setId(rs.getInt("idpessoa"));
            u.setNome(rs.getString("nome"));
            u.setEmail(rs.getString("email"));
            u.setSenha(rs.getString("senha"));
            return u;
        }
        return null;
    }
    }
    
    public Usuario buscarProfessorPorEmail(String email) throws SQLException {
    String sql = "SELECT p.idpessoa, p.nome, p.senha, pr.email " +
                 "FROM pessoa p JOIN professor pr ON pr.pessoa_idpessoa = p.idpessoa " +
                 "WHERE pr.email = ?";
    try (Connection con = ConexaoBD.obterConexao();
        PreparedStatement ps = con.prepareStatement(sql)) {
        ps.setString(1, email);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            Usuario u = new Usuario();
            u.setId(rs.getInt("idpessoa"));
            u.setNome(rs.getString("nome"));
            u.setEmail(rs.getString("email"));
            u.setSenha(rs.getString("senha"));
            return u;
        }
        return null;
    }
    }
}