package com.cafecitoDev.cafecito.persitence.exception;

import java.io.Serial;

public class CancionNotFoundException extends Exception {

    @Serial
    public static final long serialVersionUID = 1L;

    public CancionNotFoundException(String message) { super(message);}
}
