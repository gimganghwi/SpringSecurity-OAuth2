package com.rw.springsecurity.vo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="\"account\"")
public class Account implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "principal", unique=true)
    private String principal;

    @Column(name = "name")
    private String name;

    @Column(name = "reg_date")
    private Date regDate;

    protected Account(){

    }

    public Account(String principal, String name, Date regDate) {
        this.principal = principal;
        this.name = name;
        this.regDate = regDate;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", principal=" + principal +
                ", name='" + name + '\'' +
                ", regDate=" + regDate +
                '}';
    }

    public Long getId() {
        return id;
    }

    public String getPrincipal() {
        return principal;
    }

    public String getName() {
        return name;
    }

    public Date getRegDate() {
        return regDate;
    }
}
