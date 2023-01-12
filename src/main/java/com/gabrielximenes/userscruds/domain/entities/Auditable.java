package com.gabrielximenes.userscruds.domain.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
@Getter
@Setter
public abstract class Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Type(type = "uuid-char")
//    @Column(name = "id", columnDefinition = "VARCHAR(255)", insertable = false, updatable = false, nullable = false)
    @Column(name = "id", updatable = false, unique = true, nullable = false)

    protected UUID id;

    @CreatedBy
    protected UUID createdById;

    @LastModifiedBy
    protected UUID modifiedById;

    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    protected Date creationDate;

    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    protected Date lastModifiedDate;

    protected Boolean status = true;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Auditable auditable = (Auditable) o;
        return Objects.equals(id, auditable.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
