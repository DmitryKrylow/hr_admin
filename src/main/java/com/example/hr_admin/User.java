package com.example.hr_admin;

import javax.lang.model.element.NestingKind;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Users")
public class User {
    @Id
    private long id;
    @Column
    private String name;
    @Column
    private String spec;
    @Column
    private String sost;

    public User(String[] parameters) {
        this.id = Long.parseLong(parameters[0]);
        this.name = parameters[1];
        this.spec = parameters[2];
        this.sost = parameters[3];
    }

    public User() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public String getSost() {
        return sost;
    }

    public void setSost(String sost) {
        this.sost = sost;
    }


}
