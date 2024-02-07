package br.com.ebac.categories.exceptions;

public class CategoriaAlreadyExistsException extends RuntimeException {

    public CategoriaAlreadyExistsException() {
        super();
    }

    public CategoriaAlreadyExistsException(String message) {
        super(message);
    }

    public CategoriaAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }
}
