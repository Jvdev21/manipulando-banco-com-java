package br.com.Bankfuction.service;

import br.com.Models.Login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateLogin {

    private final Connection connection;

    public UpdateLogin(Connection connection) {
        this.connection = connection;
    }

    public void atualizarLogin(String idlogin, Login novoLogin) {
        String sql = "UPDATE logins SET codClasse = ?, dificuldade = ?, email = ?, senha = ?, nome = ?, data_nasc = ? WHERE idlogin = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, novoLogin.getCod_classe());
            statement.setString(2, novoLogin.getDificuldade());
            statement.setString(3, novoLogin.getEmail());
            statement.setString(4, novoLogin.getSenha());
            statement.setString(5, novoLogin.getNome());
            statement.setDate(6, novoLogin.getData_nasc());
            statement.setString(7, idlogin);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar login", e);
        }
    }

    public static void main(String[] args) {
        // Exemplo de uso da classe UpdateLogin
        try (Connection conexao = DriverManager.getConnection("jdbc:postgresql://localhost:5432/QFK",
                "postgres", "2004")) {

            UpdateLogin updateLogin = new UpdateLogin(conexao);

            // Exemplo de atualização de um login com idlogin 'exemplo_idlogin'
            Login novoLogin = new Login(1, "Alta", "exemplo_idlogin", "novoemail@example.com", "novasenha", "Novo Nome", java.sql.Date.valueOf("2000-01-01"));
            updateLogin.atualizarLogin("exemplo_idlogin", novoLogin);

            System.out.println("Login atualizado com sucesso!");

        } catch (SQLException e) {
            System.err.println("Erro na conexão com o banco de dados: " + e.getMessage());
        }
    }
}
