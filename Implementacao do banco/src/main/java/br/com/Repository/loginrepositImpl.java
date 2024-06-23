package br.com.Repository;
import br.com.Models.Login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class loginrepositImpl implements loginRepository {

    private final Connection connection;

    public loginrepositImpl(Connection connection) {
        this.connection = connection;
    }


    @Override
    public Login salvar(Login login) {
        String sql = "INSERT INTO logins(codClasse, dificuldade,idlogin, email, senha,nome,data_nasc ) VALUES(?,?,?,?,?,?,?)";
        try (
            PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, String.valueOf(login.getCod_classe()));
            statement.setString(2, login.getDificuldade());
            statement.setString(3, login.getIdlogin());
            statement.setString(4, login.getEmail());
            statement.setString(5, login.getSenha());
            statement.setString(6, login.getNome());
            statement.setString(7, String.valueOf(login.getData_nasc()));
            statement.execute();

        } catch (SQLException e) {

            throw new RuntimeException("Erro na listagem das informações", e);

        }

        return login;

    }

    public void deletar(String idlogin) {
        String sql = "DELETE FROM logins WHERE idlogin = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, idlogin);
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar", e);
        }
    }


    public Login buscar(String idlogin) {
        Login a = null;
        String sql = "SELECT * FROM logins WHERE idlogin = ?";
        try (
                PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, idlogin);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                a = new Login(result.getInt("codClasse"),
                        result.getString("Dificuldade"),
                        result.getString("idlogin"),
                        result.getString("email"),
                        result.getString("senha"), result.getString("nome"),
                        result.getDate("data_nasc"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return a;
    }

    public Login atualizar(String idlogin, Login login) {
        String sql = "UPDATE logins SET Codclasse = ?, senha = ?, email = ? WHERE idlogin = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, login.getCod_classe());
            statement.setString(2, login.getSenha());
            statement.setString(3, login.getEmail());
            statement.setString(4, login.getIdlogin());
            statement.execute();
//           pesquisei no gpt, quiser adicionar...é tipo um erro de login
//            int rowsAffected = statement.executeUpdate();
//        if (rowsAffected > 0) {
//            loginUp.setIdlogin(idlogin);
//            return loginUp;
//        } else {
//            throw new RuntimeException("login não encontrado");
//        }

    } catch (SQLException e) {
        throw new RuntimeException("Erro ao atualizar login", e);
    }
        return login;
    }


@Override
    public boolean existe(String idlogin) {
        
        Login a = buscar(idlogin);

    return a != null;
    }
}



