package com.mercadolibre.dojos.cards;

import java.util.ArrayList;

public class TresDeCopas extends Card {
    public TresDeCopas(){
        this.name = "Tres de Copas";
        this.winnerCards = new ArrayList<Card>(){{
            add(new CuatroDeCopas());
            add(new CuatroDeBasto());
            add(new SieteDeBasto());
        }};
    }
}
