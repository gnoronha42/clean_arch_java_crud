package com.gabrielximenes.userscruds.domain.exceptions;

import java.io.Serial;

public class EmailInvalidException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    public EmailInvalidException(String msg) {
        super(msg);
    }

    public EmailInvalidException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
