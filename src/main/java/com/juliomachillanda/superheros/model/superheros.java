package com.juliomachillanda.superheros.model;

import javax.persistence.*;

@Entity
@Table(name = "superheros")
public class superheros {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "NAME")
    private String nameSuperHeroe;

    @Column(name = "CHARACTERISTICS")
    private String characteristicsSuperHeroe;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameSuperHeroe() {
        return nameSuperHeroe;
    }

    public void setNameSuperHeroe(String nameSuperHeroe) {
        this.nameSuperHeroe = nameSuperHeroe;
    }

    public String getCharacteristicsSuperHeroe() {
        return characteristicsSuperHeroe;
    }

    public void setCharacteristicsSuperHeroe(String characteristicsSuperHeroe) {
        this.characteristicsSuperHeroe = characteristicsSuperHeroe;
    }
}
