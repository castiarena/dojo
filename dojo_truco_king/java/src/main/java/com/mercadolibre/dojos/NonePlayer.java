package com.mercadolibre.dojos;

import java.util.ArrayList;

public class NonePlayer extends Player{
    NonePlayer(){
        super(
                new ArrayList<Card>(){{
                    add(new CardNotFound());
                    add(new CardNotFound());
                    add(new CardNotFound());
                }}
        , "nadie");
    }
}
