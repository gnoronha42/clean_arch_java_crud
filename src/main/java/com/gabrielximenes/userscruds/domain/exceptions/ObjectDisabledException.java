package com.gabrielximenes.userscruds.domain.exceptions;

import java.io.Serial;

public class ObjectDisabledException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    public ObjectDisabledException(String msg) {
        super(msg);
    }

    public ObjectDisabledException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
