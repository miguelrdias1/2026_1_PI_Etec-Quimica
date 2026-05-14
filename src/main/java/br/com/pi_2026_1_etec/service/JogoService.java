package br.com.pi_2026_1_etec.service;

import java.util.Scanner;

public class JogoService {
    Scanner scanner = new Scanner(System.in);
    public void iniciar () {
        Questao p1 = new Questao();
        p1.enunciado = "Qual o nome desse material";
    }
}