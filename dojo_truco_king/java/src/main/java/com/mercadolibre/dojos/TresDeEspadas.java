package com.mercadolibre.dojos;

import java.util.ArrayList;

public class TresDeEspadas extends Card {
    public TresDeEspadas() {
        this.name = "Tres de espadas";
        this.winnerCards = new ArrayList<Card>(){{
            add(new CuatroDeCopas());
            add(new CuatroDeBasto());
            add(new SieteDeBasto());
        }};
    }
}
