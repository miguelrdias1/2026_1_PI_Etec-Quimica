package br.com.pi_2026_1_etec.service;

import br.com.pi_2026_1_etec.model.Usuario;
import br.com.pi_2026_1_etec.repository.UsuarioRepository;
import java.sql.SQLException;

public class UsuarioService {

    private UsuarioRepository repository = new UsuarioRepository();

    public String cadastrar(String nome, String email, String senha) {
        if (nome.isBlank() || email.isBlank() || senha.isBlank()) {
            return "Preencha todos os campos!";
        }
        if (!email.contains("@")) {
            return "E-mail inválido!";
        }
        if (senha.length() < 6) {
            return "A senha deve ter pelo menos 6 caracteres!";
        }

        try {
            if (repository.emailJaExiste(email)) {
                return "E-mail já cadastrado!";
            }

            Usuario usuario = new Usuario();
            usuario.setNome(nome);
            usuario.setEmail(email);
            usuario.setSenha(senha);

            repository.cadastrar(usuario);
            return "sucesso";

        } catch (SQLException e) {
            return "Erro ao cadastrar: " + e.getMessage();
        }
    }
}