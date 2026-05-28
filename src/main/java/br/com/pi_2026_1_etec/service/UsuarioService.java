package br.com.pi_2026_1_etec.service;

import br.com.pi_2026_1_etec.model.Usuario;
import br.com.pi_2026_1_etec.repository.UsuarioRepository;

public class UsuarioService {

    private UsuarioRepository repository = new UsuarioRepository();

    public String cadastrar(String nome, String email, String senha) {
        if (nome.isBlank() || email.isBlank() || senha.isBlank()) {
            return "Preencha todos os campos!"; // Envia o string para caso algum campo esteja vazio.
        }
        if (senha.length() < 6) {
            return "A senha deve ter pelo menos 6 caracteres!";
        }
        boolean ehAluno     = email.matches("^[^@]+@aluno\\.cps\\.sp\\.gov\\.br$");
        boolean ehProfessor = email.matches("^[^@]+@cps\\.sp\\.gov\\.br$"); 
        //Duas booleanas que verificam se o modelo do email bate com o estipulado da etec.

        if (!ehAluno && !ehProfessor){return "Use um email institucional válido.";}// retorna uma string para caso o email não seja de nenum modelo

        try {
            if (repository.emailJaExiste(email)) {
                return "E-mail já cadastrado!";
            } //Verifica no banco se ja existe esse email cadastrado, por isso o try

            Usuario usuario = new Usuario();
            usuario.setNome(nome);
            usuario.setEmail(email);
            usuario.setSenha(senha);
            //cria o usuario com os campos respondidos pelo cadastro caso nenhum dos ifs anteriores seja aceito
            if (ehAluno==true){
                repository.cadastrarAluno(usuario);
            }//se o formato for aluno, aluno é adcionado
            else{//se não for aluno, como o formato ja ta em algum dos dois modelos aceitos, so pode ser professor. logo, adciona professor
                repository.cadastrarProfessor(usuario);
            }
            
            return "sucesso";//Envia uma string avisando que conseguiu fazer o login.

        } catch (Exception e) {
            return "Erro ao cadastrar: " + e.getMessage();
        }
    }
}