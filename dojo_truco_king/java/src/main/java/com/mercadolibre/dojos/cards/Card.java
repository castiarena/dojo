package com.mercadolibre.dojos.cards;

import java.util.ArrayList;
import java.util.List;

public class Card {
    protected List<Card> winnerCards = new ArrayList<>();

    protected String name;
    public boolean equals(Card card) {
        return this.name.equals(card.name);
    }

    private boolean win(Card winnerCard) {
        return winnerCards.stream()
            .anyMatch( card -> card.equals(winnerCard)
        );
    }

    public Card versus(Card versusCard) {
        return this.win(versusCard) ? this : versusCard;
    }
}
