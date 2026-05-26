package br.com.pi_2026_1_etec.service;

import br.com.pi_2026_1_etec.model.Questao;
import br.com.pi_2026_1_etec.repository.QuestaoRepository;
import java.util.List;

public class JogoService {
    private final QuestaoRepository repo = new QuestaoRepository();
    private List<Questao> questoes;
    private int indice = 0;
    private int pontuacao = 0;

    public void iniciar(int nivel) {
        questoes = repo.buscarPorNivel(nivel);
        indice = 0;
        pontuacao = 0;
    }

    public Questao getAtual() { return questoes.get(indice); }
    public boolean temProxima() { return indice < questoes.size(); }
    public int getPontuacao() { return pontuacao; }
    public int getTotalQuestoes() { return questoes.size(); }
    public int getIndice() { return indice; }

    public boolean responder(int idAlternativa) {
        Questao q = getAtual();
        boolean acertou = q.getAlternativas().stream()
            .anyMatch(a -> a.getId() == idAlternativa && a.isCorreta());
        if (acertou) pontuacao += 10;
        indice++;
        return acertou;
    }
    
    public int getIdCorreta() {
        return questoes.get(indice - 1).getAlternativas().stream()
            .filter(a -> a.isCorreta())
            .mapToInt(a -> a.getId())
            .findFirst().orElse(-1);
    }
}