public int contarAlunos() {
    String sql = "SELECT COUNT(*) FROM aluno";
    try (Connection conn = ConexaoBanco.getConexao();
         PreparedStatement ps = conn.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {
            
        if (rs.next()) {
            return rs.getInt(1);
        }
    } catch (SQLException e) {
        java.util.logging.Logger.getLogger(AlunoDAO.class.getName())
            .log(java.util.logging.Level.SEVERE, "Erro ao contar alunos", e);
    }
    return 0;
}