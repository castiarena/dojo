package com.mercadolibre.dojos.cards;

import java.util.ArrayList;

public class UnoDeEspada extends Card {
    public UnoDeEspada(){
        name = "uno de espada";
        winnerCards = new ArrayList<Card>(){{
            add(new UnoDeBasto());
            add(new SieteDeBasto());
            add(new TresDeEspadas());
            add(new TresDeCopas());
            add(new CuatroDeCopas());
            add(new CuatroDeBasto());
        }};
    }
}
