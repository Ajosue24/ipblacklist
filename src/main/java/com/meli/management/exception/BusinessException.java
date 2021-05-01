package com.meli.management.exception;

public class BusinessException extends RuntimeException{

    /**
     * The Constant serialVersionUID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Instantiates a new unauthorized exception.
     */
    public BusinessException() {
        super();
    }

    /**
     * Instantiates a new unauthorized exception.
     *
     * @param message the message
     */
    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String message, Exception e) {
        super(message, e);
    }
}
