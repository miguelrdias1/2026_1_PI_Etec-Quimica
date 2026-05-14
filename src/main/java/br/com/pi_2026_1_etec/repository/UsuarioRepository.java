package br.com.pi_2026_1_etec.repository;

import br.com.pi_2026_1_etec.model.Usuario;
import br.com.pi_2026_1_etec.util.ConexaoBD;
import java.sql.*;

public class UsuarioRepository {

    public void cadastrar(Usuario usuario) throws SQLException {
        String sql = "INSERT INTO usuario (nome, email, senha) VALUES (?, ?, ?)";

        try (Connection con = ConexaoBD.getConexao();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, usuario.getNome());
            ps.setString(2, usuario.getEmail());
            ps.setString(3, usuario.getSenha());
            ps.executeUpdate();
        }
    }

    public boolean emailJaExiste(String email) throws SQLException {
        String sql = "SELECT id FROM usuario WHERE email = ?";

        try (Connection con = ConexaoBD.getConexao();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            return rs.next(); // true se encontrou algum resultado
        }
    }
}

//Insere um novo usuário no banco de dados e verifica se o email já está cadastrado