package com.meli.management.exception;

public class PetitionerException extends RuntimeException{

    /**
     * The Constant serialVersionUID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Instantiates a new unauthorized exception.
     */
    public PetitionerException() {
        super();
    }

    /**
     * Instantiates a new unauthorized exception.
     *
     * @param message the message
     */
    public PetitionerException(String message) {
        super(message);
    }

    public PetitionerException(String message, Exception e) {
        super(message, e);
    }
}
