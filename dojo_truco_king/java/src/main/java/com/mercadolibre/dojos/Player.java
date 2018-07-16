package com.mercadolibre.dojos;

import java.util.List;

public class Player {

    private List<Card> cards;
    private boolean canPlay;

    public Player(List<Card> cards) {
        this.cards = cards;
        this.canPlay = false;
    }

    public void iCanNotPlay(){
        canPlay = false;
    }

    public void iCanPlay(){
        canPlay = true;
    }

    public Card throwCard(Card cardToPlay) {
        boolean canPlayAndExistCard = this.cards.stream()
            .anyMatch(
                card -> card.equals(cardToPlay)
            ) && this.canPlay;

        return canPlayAndExistCard
                ? cardToPlay
                : new CardNotFound();
    }

    public boolean equals(Player player){
        return this == player;
    }

    public boolean hasCard(Card cardToCompare) {
        return this.cards.stream()
                .anyMatch(card -> card.equals(cardToCompare));
    }
}
