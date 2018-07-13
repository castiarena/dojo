package com.mercadolibre.dojos;

public class Card {

    protected String name;

    public Card() {
        this.name = "no name";
    }

    public Card(String name) {
        this.name = name;
    }

    public boolean equals(Object otherCard){
        return this.name.equals(((Card)otherCard).name);
    }
}
