package com.juliomachillanda.superheroes.builder;

import com.juliomachillanda.superheroes.domain.Superhero;

public class SuperheroBuilder {

    private final Superhero superhero;

    public SuperheroBuilder() {
        superhero = new Superhero();
    }

    public SuperheroBuilder withId(Long id) {
        superhero.setId(id);
        return this;
    }

    public SuperheroBuilder withName(String name) {
        superhero.setName(name);
        return this;
    }

    public SuperheroBuilder withSuperpower(String superpower) {
        superhero.setSuperpower(superpower);
        return this;
    }

    public Superhero build() {
        return superhero;
    }

    public static Superhero getSpiderMan() {
        return new SuperheroBuilder()
                .withName("Spider Man")
                .withSuperpower("Spider senses")
                .build();
    }

    public static Superhero getIronMan() {
        return new SuperheroBuilder()
                .withName("Iron Man")
                .withSuperpower("Suit of armor")
                .build();
    }

    public static Superhero getWonderWoman() {
        return new SuperheroBuilder()
                .withName("Wonder Woman")
                .withSuperpower("Super strength")
                .build();
    }

    public static Superhero getBatman() {
        return new SuperheroBuilder()
                .withName("Batman")
                .withSuperpower("Utility belt")
                .build();
    }

    public static Superhero getHulk() {
        return new SuperheroBuilder()
                .withName("Hulk")
                .withSuperpower("Leap great distances")
                .build();
    }
}
