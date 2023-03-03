package com.juliomachillanda.superheros.model;

import javax.persistence.*;

@Entity
@Table(name = "superheros")
public class SuperherosEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @Override
    public String toString() {
        return "SuperherosEntity{" +
                "id=" + id +
                ", nameSuperHeroe='" + nameSuperHeroe + '\'' +
                ", characteristicsSuperHeroe='" + characteristicsSuperHeroe + '\'' +
                '}';
    }
}
