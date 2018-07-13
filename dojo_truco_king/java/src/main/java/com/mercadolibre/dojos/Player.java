package com.mercadolibre.dojos;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Player {

    private List<Card> cards;
    private String name;

    public Player(String name, List<Card> cards) {
        this.name = name;
        this.cards = cards;
    }

    public Card throwCard(Card cardToPlay) {
        List<Card> filterCard = this.cards.stream()
                .filter(it -> it.equals(cardToPlay))
                .collect(Collectors.toList());

        this.cards.remove(cardToPlay);
        try {
            return filterCard.get(0);
        }catch (Exception exeption) {

            return new CardNotFound();
        }
    }
}
