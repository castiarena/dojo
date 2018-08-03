package com.mercadolibre.dojos;

import com.mercadolibre.dojos.cards.Card;
import com.mercadolibre.dojos.cards.CardNotFound;

import java.util.ArrayList;

public class NonePlayer extends Player{
    public NonePlayer(){
        super(
                new ArrayList<Card>(){{
                    add(new CardNotFound());
                    add(new CardNotFound());
                    add(new CardNotFound());
                }}
        , "nadie");
    }
}
