package br.com.Repository;

import br.com.Models.Login;

public interface loginRepository {

    Login salvar(Login login);
    void deletar(String idlogin);
    Login buscar(String idlogin);
    Login atualizar(String idlogin, Login livro);
    boolean existe(String idlogin);

}