package br.com.pi_2026_1_etec.model;

public class Alternativa {
    private int idAlternativa;
    private String texto;
    private boolean correta;
    private boolean errada;
    private int idImagem;
    private int idPergunta;

    public Alternativa() {}

    public Alternativa(String texto, boolean correta, boolean errada, int idImagem, int idPergunta) {
        this.texto = texto;
        this.correta = correta;
        this.errada = errada;
        this.idImagem = idImagem;
        this.idPergunta = idPergunta;
    }

    public int getIdAlternativa() { return idAlternativa; }
    public void setIdAlternativa(int idAlternativa) { this.idAlternativa = idAlternativa; }

    public String getTexto() { return texto; }
    public void setTexto(String texto) { this.texto = texto; }

    public boolean isCorreta() { return correta; }
    public void setCorreta(boolean correta) { this.correta = correta; }

    public boolean isErrada() { return errada; }
    public void setErrada(boolean errada) { this.errada = errada; }

    public int getIdImagem() { return idImagem; }
    public void setIdImagem(int idImagem) { this.idImagem = idImagem; }

    public int getIdPergunta() { return idPergunta; }
    public void setIdPergunta(int idPergunta) { this.idPergunta = idPergunta; }
}