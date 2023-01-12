package com.gabrielximenes.userscruds.infra.convert;

import com.gabrielximenes.userscruds.domain.record.UserRecord;
import com.gabrielximenes.userscruds.infra.forms.UserForm;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserConvert implements Converter<UserForm, UserRecord> {

    @Override
    public UserRecord convert(UserForm source) {
        return new UserRecord(
                source.name(),
                source.email(),
                source.username(),
                source.password(),
                source.phone()
        );
    }
}
