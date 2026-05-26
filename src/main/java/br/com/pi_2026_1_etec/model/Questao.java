package br.com.pi_2026_1_etec.model;

import java.util.List;

public class Questao {
    private int id;
    private String enunciado;
    private String imagemPath;    // LEMBRAR!!! Que tem q ser null se não tiver imagem.
    private int nivel;
    private List<Alternativa> alternativas;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getEnunciado() { return enunciado; }
    public void setEnunciado(String e) { this.enunciado = e; }
    public String getImagemPath() { return imagemPath; }
    public void setImagemPath(String p) { this.imagemPath = p; }
    public int getNivel() { return nivel; }
    public void setNivel(int n) { this.nivel = n; }
    public List<Alternativa> getAlternativas() { return alternativas; }
    public void setAlternativas(List<Alternativa> a) { this.alternativas = a; }
    public int getNumAlternativas() {
        return alternativas != null ? alternativas.size() : 0;
    }
}