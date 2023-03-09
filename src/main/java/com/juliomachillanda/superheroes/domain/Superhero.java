package com.juliomachillanda.superheros.model;

import javax.persistence.*;

@Entity
@Table(name = "superheros")
public class SuperHeros {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "SUPERPOWER")
    private String superPower;

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

    public String getSuperPower() {
        return superPower;
    }

    public void setSuperPower(String superPower) {
        this.superPower = superPower;
    }

    @Override
    public String toString() {
        return "SuperherosEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", superPower='" + superPower + '\'' +
                '}';
    }
}
