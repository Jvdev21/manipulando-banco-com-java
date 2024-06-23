package br.com.service;

import br.com.Models.Login;
import br.com.Repository.loginRepository;
import br.com.exception.LoginNotFoundException;

public class loginsService {
private final loginRepository loginRepository;

    public loginsService(br.com.Repository.loginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }
    public Login criarLivro(Login login){
        Login a = null;
        if(login.getIdlogin() != null){
            if (loginRepository.existe(login.getIdlogin())){
                throw new RuntimeException("Login já existente");
            }
            a = loginRepository.salvar(login);
        }
        return a;
    }

    public Login buscarLogin(String idlogin) throws LoginNotFoundException {
        Login login = loginRepository.buscar(idlogin);
        if(login == null){
            throw new LoginNotFoundException();
        }else{
            return login;
        }
    }
    public void deletar(String idlogin) throws LoginNotFoundException {
        if(loginRepository.existe(idlogin)){
            loginRepository.deletar(idlogin);
        }else{
            throw new LoginNotFoundException();
        }
    }
    public Login atualizar(String idlogin, Login login) throws LoginNotFoundException {

        Login l1 = buscarLogin(idlogin);

//        if(login.getCod_classe()!=null){ faz esse funcionar

        if(!(login.getSenha()==null)){

            l1.setSenha(login.getSenha());

        }if(!(login.getEmail()==null)){

            l1.setEmail(login.getEmail());

        }

        return loginRepository.salvar(l1);

    }
}
