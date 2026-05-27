//package br.com.pi_2026_1_etec.repository;
//
//import br.com.pi_2026_1_etec.model.Alternativa;
//import br.com.pi_2026_1_etec.model.Questao;
//import br.com.pi_2026_1_etec.util.ConexaoBD;
//
//import java.sql.*;
//import java.util.*;

//public class QuestaoRepository {
//    public List<Questao> buscarPorNivel(int nivel) {
//        List<Questao> lista = new ArrayList<>();
//
//        String sql = nivel == 0
//            ? """
//              SELECT q.id, q.enunciado, q.imagem_path, q.nivel,
//                     a.id AS alt_id, a.texto, a.correta
//              FROM questao q
//              JOIN alternativa a ON a.questao_id = q.id
//              ORDER BY RAND()
//              """
//            : """
//              SELECT q.id, q.enunciado, q.imagem_path, q.nivel,
//                     a.id AS alt_id, a.texto, a.correta
//              FROM questao q
//              JOIN alternativa a ON a.questao_id = q.id
//              WHERE q.nivel = ?
//              ORDER BY RAND()
//              """;
//
//        try (Connection c = ConexaoBD.getConnection();
//             PreparedStatement ps = c.prepareStatement(sql)) {
//
//            if (nivel != 0) ps.setInt(1, nivel);
//
//            ResultSet rs = ps.executeQuery();
//            Map<Integer, Questao> map = new LinkedHashMap<>();
//
//            while (rs.next()) {
//                int qid = rs.getInt("id");
//                if (!map.containsKey(qid)) {
//                    Questao q = new Questao();
//                    q.setId(qid);
//                    q.setEnunciado(rs.getString("enunciado"));
//                    q.setImagemPath(rs.getString("imagem_path"));
//                    q.setNivel(rs.getInt("nivel"));
//                    q.setAlternativas(new ArrayList<>());
//                    map.put(qid, q);
//                }
//
//                Alternativa alt = new Alternativa();
//                alt.setId(rs.getInt("alt_id"));
//                alt.setTexto(rs.getString("texto"));
//                alt.setCorreta(rs.getBoolean("correta"));
//                map.get(qid).getAlternativas().add(alt);
//            }
//
//            lista.addAll(map.values());
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return lista;
//    }
//}