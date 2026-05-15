package br.com.pi_2026_1_etec.controller;

import br.com.pi_2026_1_etec.service.UsuarioService;;

public class UsuarioController {

    private UsuarioService service = new UsuarioService();

    public String cadastrar(String nome, String email, String senha) {
        return service.cadastrar(nome, email, senha);
    }
}