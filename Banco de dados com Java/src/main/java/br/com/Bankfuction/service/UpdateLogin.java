package br.com.Bankfuction.service;

import br.com.Models.Login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateLogin {

    private final Connection connection;

    public UpdateLogin(Connection connection) {
        this.connection = connection;
    }

    public void atualizarLogin(String idLogin, Login novoLogin) {
        String sql = "UPDATE login SET email = ?, senha = ?, nome = ?, data_nasc = ? WHERE id_login = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, novoLogin.getEmail());
            statement.setString(2, novoLogin.getSenha());
            statement.setString(3, novoLogin.getNome());
            statement.setDate(4, novoLogin.getDataNasc());
            statement.setString(5, idLogin);

            int linhasAfetadas = statement.executeUpdate();
            if (linhasAfetadas > 0) {
                System.out.println("Login atualizado com sucesso!");
            } else {
                System.out.println("Nenhum login foi atualizado.");
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar login", e);
        }
    }
}
