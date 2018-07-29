package com.mercadolibre.dojos;

import java.util.ArrayList;

public class SieteDeBasto extends Card {
    public SieteDeBasto(){
        this.name = "Siete de basto";
        this.winnerCards = new ArrayList<Card>(){{
            add(new CuatroDeCopas());
            add(new CuatroDeBasto());
        }};
    }
}
