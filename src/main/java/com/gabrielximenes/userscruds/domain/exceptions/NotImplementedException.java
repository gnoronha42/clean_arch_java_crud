package com.gabrielximenes.userscruds.domain.exceptions;

import java.io.Serial;

public class NotImplementedException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    public NotImplementedException() {
        super("Funcionalidade não implementada");
    }

    public NotImplementedException(String msg) {
        super(msg);
    }

    public NotImplementedException(String msg, Throwable cause) {
        super(msg, cause);
    }

}