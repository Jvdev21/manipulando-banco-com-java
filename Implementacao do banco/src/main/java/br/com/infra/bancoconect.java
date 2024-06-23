package br.com.infra;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class bancoconect{
    private static final String URL_DB = "jdbc:postgresql://localhost:5433/QFK";
    private static final String USER = "postgres";
    private static final String PASS = "0808";

    public static Connection connection;

    public static Connection getConnection() throws SQLException {
        if(connection==null || connection.isClosed()) {
            connection = DriverManager.getConnection(URL_DB, USER, PASS);
        }
        return connection;
    }
}





/*

public class bancoconect {
    // Método principal que é o ponto de entrada do programa
    public static void main(String[] args) {
        // Bloco try-with-resources para garantir que a conexão com o banco de dados seja fechada automaticamente
        try (Connection conexao = DriverManager.getConnection("jdbc:postgresql://localhost:5432/QFK",
                "postgres", "2004")) {
            // Verifica se a conexão foi estabelecida com sucesso
            if (conexao != null) {
                System.out.println("Banco ok");
                // Cria um objeto Statement para executar consultas SQL
                Statement stm = conexao.createStatement();


            }
        } catch (SQLException e) {
            // Lança uma RuntimeException se ocorrer um erro de SQL
            throw new RuntimeException(e);
        }
    }
}
*/