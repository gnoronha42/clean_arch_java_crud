package com.gabrielximenes.userscruds.domain.exceptions;


import java.io.Serial;

public class UserInvalidException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    public UserInvalidException(String msg) {
        super(msg);
    }

    public UserInvalidException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
