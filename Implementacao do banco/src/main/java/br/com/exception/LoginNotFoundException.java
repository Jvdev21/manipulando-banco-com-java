package br.com.exception;

public class LoginNotFoundException extends Exception{
    public LoginNotFoundException(){
    super("login nao encontrado no banco de dados");
    }
}
