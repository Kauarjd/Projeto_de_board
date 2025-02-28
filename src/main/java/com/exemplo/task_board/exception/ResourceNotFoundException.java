package com.exemplo.task_board.exception;

public class ResourceNotFoundException extends RuntimeException {

    // Construtor que recebe uma mensagem de erro
    public ResourceNotFoundException(String message) {
        super(message);
    }

    // Construtor que recebe uma mensagem de erro e uma causa (outra exceção)
    public ResourceNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}