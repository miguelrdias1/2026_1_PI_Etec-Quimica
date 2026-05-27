package br.com.pi_2026_1_etec.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import io.github.cdimascio.dotenv.Dotenv;


public class ConexaoBD {
    private static Dotenv dotenv = Dotenv.load();
    private static String host = dotenv.get("DB_HOST");
    private static String porta = dotenv.get("DB_PORT");
    private static String db = dotenv.get("DB_NAME");
    private static String usuario = dotenv.get("DB_USER");
    private static String senha = dotenv.get("DB_PASSWORD");


public static Connection obterConexao() throws SQLException {
    String url = String.format(
        "jdbc:mysql://%s:%s/%s?useSSL=true&requireSSL=true&verifyServerCertificate=false&allowPublicKeyRetrieval=true",
        host, porta, db
    );
    
    return DriverManager.getConnection(url, usuario, senha);
    }
}
