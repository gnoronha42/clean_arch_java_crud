package com.gabrielximenes.userscruds.domain.exceptions;

import java.io.Serial;

public class NotNullException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    public NotNullException(String msg) {
        super(msg);
    }

    public NotNullException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
