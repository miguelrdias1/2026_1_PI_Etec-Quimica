package br.com.pi_2026_1_etec.model;

public class Material {
    private int id;
    private String nome;
    private String caminhoImagem;
    
    public Material(int id, String nome, String caminhoImagem){
        this.id = id;
        this.nome = nome;
        this.caminhoImagem = caminhoImagem;
    }
    
    @Override
    public String toString() {
        return this.nome;
    }
    
    public String getCaminhoImagem(){
        return caminhoImagem;
    }
    
    public String getNome(){
        return nome;
    }
    
    public int getID(){
        return id;
    }
    }

