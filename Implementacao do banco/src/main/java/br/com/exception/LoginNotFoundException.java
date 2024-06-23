package br.com.exception;

public class LoginNotFoundException extends Exception {

    public LoginNotFoundException() {
        super("Login não encontrado no banco de dados");
    }

    public LoginNotFoundException(String message) {
        super(message);
    }

    public LoginNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public LoginNotFoundException(Throwable cause) {
        super(cause);
    }
}
