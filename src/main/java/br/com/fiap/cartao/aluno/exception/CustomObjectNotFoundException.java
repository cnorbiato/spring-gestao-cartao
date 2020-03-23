package br.com.fiap.cartao.aluno.exception;

public class CustomObjectNotFoundException extends RuntimeException {

    public CustomObjectNotFoundException(String msg) {
        super(msg);
    }

    public CustomObjectNotFoundException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
