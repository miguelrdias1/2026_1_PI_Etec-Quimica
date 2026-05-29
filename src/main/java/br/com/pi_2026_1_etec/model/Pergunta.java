package br.com.pi_2026_1_etec.model;

public class Pergunta {
    private int idPergunta;
    private String texto;
    private int idImagem;
    private int idMaterial;
    private int idNivel;
    private int idSistema;
    private String tipoPergunta;
    private int idTema;

    public int getIdTema() {
        return idTema;
    }

    public void setIdTema(int idTema) {
        this.idTema = idTema;
    }

    public Pergunta() {
    }

    public Pergunta(String texto, int idImagem, int idTema, int idMaterial, int idNivel, int idSistema,
            String tipoPergunta) {
        this.texto = texto;
        this.idImagem = idImagem;
        this.idTema = idTema;
        this.idMaterial = idMaterial;
        this.idNivel = idNivel;
        this.idSistema = idSistema;
        this.tipoPergunta = tipoPergunta;
    }

    public int getIdPergunta() {
        return idPergunta;
    }

    public String getTexto() {
        return texto;
    }

    public int getIdImagem() {
        return idImagem;
    }

    public int getIdMaterial() {
        return idMaterial;
    }

    public int getIdNivel() {
        return idNivel;
    }

    public int getIdSistema() {
        return idSistema;
    }

    public String getTipoPergunta() {
        return tipoPergunta;
    }

    public void setIdPergunta(int idPergunta) {
        this.idPergunta = idPergunta;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public void setIdImagem(int idImagem) {
        this.idImagem = idImagem;
    }

    public void setIdMaterial(int idMaterial) {
        this.idMaterial = idMaterial;
    }

    public void setIdNivel(int idNivel) {
        this.idNivel = idNivel;
    }

    public void setIdSistema(int idSistema) {
        this.idSistema = idSistema;
    }

    public void setTipoPergunta(String tipoPergunta) {
        this.tipoPergunta = tipoPergunta;
    }

}
