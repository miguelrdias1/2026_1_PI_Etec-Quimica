package br.com.pi_2026_1_etec.util;
import java.sql.*;

public class ConexaoBD {
    public static Connection getConexao() throws SQLException {
        return DriverManager.getConnection(
            "link do banco escreve aqui gente! por: nakai s2",
            "root", "senha do banco escreve aqui gente!"
        );
    }
}