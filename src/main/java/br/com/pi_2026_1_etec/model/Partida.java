package br.com.pi_2026_1_etec.model;

import java.time.LocalDateTime;

public class Partida {
    private int idPartida;
    private String emailAluno;
    private LocalDateTime data;
    private int acertos;
    private int erros;

    public Partida() {}

    public Partida(String emailAluno, int acertos, int erros) {
        this.emailAluno = emailAluno;
        this.acertos = acertos;
        this.erros = erros;
        this.data = LocalDateTime.now();
    }

    public int getIdPartida() { return idPartida; }
    public void setIdPartida(int idPartida) { this.idPartida = idPartida; }

    public String getEmailAluno() { return emailAluno; }
    public void setEmailAluno(String emailAluno) { this.emailAluno = emailAluno; }

    public LocalDateTime getData() { return data; }
    public void setData(LocalDateTime data) { this.data = data; }

    public int getAcertos() { return acertos; }
    public void setAcertos(int acertos) { this.acertos = acertos; }

    public int getErros() { return erros; }
    public void setErros(int erros) { this.erros = erros; }
}