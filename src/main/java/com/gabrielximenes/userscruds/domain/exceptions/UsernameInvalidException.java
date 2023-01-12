package com.gabrielximenes.userscruds.domain.exceptions;

import java.io.Serial;

public class UsernameInvalidException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    public UsernameInvalidException(String msg) {
        super(msg);
    }

    public UsernameInvalidException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
