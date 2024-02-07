package br.com.ebac.memes.exceptions;

public class UserOrCategoryNotExistException extends RuntimeException {

    public UserOrCategoryNotExistException() {
        super();
    }

    public UserOrCategoryNotExistException(String message) {
        super(message);
    }

    public UserOrCategoryNotExistException(String message, Throwable cause) {
        super(message, cause);
    }
}
