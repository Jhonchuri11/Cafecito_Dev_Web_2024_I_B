package com.cafecitoDev.cafecito.persitence.exception;

import java.io.Serial;

public class AlbumNotFoundException extends Exception {

    @Serial
    public static final long  serialVersionUIDD = 1L;

    public AlbumNotFoundException(String message)
    {
        super(message);
    }
}
