//package br.com.pi_2026_1_etec.controller;
//
//import br.com.pi_2026_1_etec.model.Questao;
//import br.com.pi_2026_1_etec.service.JogoService;
//import br.com.pi_2026_1_etec.view.telas.TelaQuestao1;
//import br.com.pi_2026_1_etec.view.telas.TelaQuestão2;

//public class JogoController {
//    private final JogoService service = new JogoService();
//
//    //Essas telas, apenas uma fica aberta por vez. São layouts diferentes
//    private TelaQuestao1 layout1;
//    private TelaQuestão2 layout2;
//
//    public void iniciarJogo(int nivel) {
//        service.iniciar(nivel);
//        carregarProxima();
//    }
//
//    public void carregarProxima() {
//        if (!service.temProxima()) {
//            exibirFim();
//            return;
//        }
//        Questao q = service.getAtual();
//        int total = service.getTotalQuestoes();
//        int indice = service.getIndice();
//        if (q.getNumAlternativas() == 3) {
//            if (layout1 != null) { layout1.dispose(); layout1 = null; }
//            if (layout2 == null) {
//                layout2 = new TelaQuestao2(this);
//                layout2.setVisible(true);
//            }
//            layout2.exibirQuestao(q, indice, total);
//        } else {
//            if (layout2 != null) { layout2.dispose(); layout2 = null; }
//
//            if (layout1 == null) {
//                layout1 = new TelaQuestao1(this);
//                layout1.setVisible(true);
//            }
//            layout1.exibirQuestao(q, indice, total);
//        }
//    }
//
//    public void responder(int idAlternativa) {
//        boolean acertou = service.responder(idAlternativa);
//        int idCorreta = service.getIdCorreta();
//        if (layout1 != null) layout1.destacar(idAlternativa, idCorreta, acertou);
//        if (layout1 != null) layout2.destacar(idAlternativa, idCorreta, acertou);
//        javax.swing.Timer t = new javax.swing.Timer(30000, e -> carregarProxima());
//        t.setRepeats(false);
//        t.start();
//    }
//
//    private void exibirFim() {
//        int pontuacao = service.getPontuacao();
//        int total = service.getTotalQuestoes();
//        if (layout1 != null) layout1.dispose();
//        if (layout2 != null) layout2.dispose();
//        javax.swing.JOptionPane.showMessageDialog(null,
//            "Fim de jogo!\nVocê acertou " + (pontuacao / 10) + " de " + total + " questões.",
//            "Resultado", javax.swing.JOptionPane.INFORMATION_MESSAGE);
//        new br.com.pi_2026_1_etec.view.telas.TelaMenuAlunos().setVisible(true);
//    }
//}