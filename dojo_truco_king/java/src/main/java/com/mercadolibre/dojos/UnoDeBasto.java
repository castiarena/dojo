package com.mercadolibre.dojos;

import java.util.ArrayList;

public class UnoDeBasto extends Card {
    public UnoDeBasto() {

        this.name = "Uno de basto";
        this.winnerCards = new ArrayList<Card>(){{
            add(new TresDeEspadas());
            add(new TresDeCopas());
            add(new SieteDeBasto());
            add(new CuatroDeCopas());
            add(new CuatroDeBasto());
        }};
    }
}
