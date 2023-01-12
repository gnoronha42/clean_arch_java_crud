package com.gabrielximenes.userscruds.domain.entities;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "users")
@DynamicUpdate
@DynamicInsert
@Getter
@Setter
public class UserEntity extends Auditable {

    private String name;

    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String username;

    private String password;

    @Column(unique = true)
    private String telefone;




    public UserEntity() {
    }


    public UserEntity(String name, String email, String username, String password) {
        this.name = name;
        this.email = email;
        this.username = username;
        this.password = password;
    }


}