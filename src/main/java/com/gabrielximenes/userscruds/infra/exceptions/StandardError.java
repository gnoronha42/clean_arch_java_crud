package com.gabrielximenes.userscruds.infra.exceptions;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@Component
@NoArgsConstructor
public class StandardError {

    private Integer status;
    private String field;
    private String error;
    private String defaultMessage;

    public StandardError(Integer status, String field, String error, String defaultMessage) {
        this.status = status;
        this.field = field;
        this.error = error;
        this.defaultMessage = defaultMessage;
    }

}
