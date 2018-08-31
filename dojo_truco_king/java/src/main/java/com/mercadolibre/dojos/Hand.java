package com.mercadolibre.dojos;

import com.mercadolibre.dojos.cards.Card;

import java.util.ArrayList;
import java.util.List;

public class Hand {

    private List<Round> rounds = new ArrayList<>();
    private Round actualRound;
    private Player actualPlayer;



    public Hand(Player player1) {
        this.actualPlayer = player1;
    }

    public Hand startRoundFor (Player player, Card card) throws NotYourTurnException {

        if (player != this.actualPlayer){
            throw new NotYourTurnException(player);
        }
        this.actualRound = new Round(this.actualPlayer, card);

        return this;
    }

    public Hand continueRoundFor (Player player, Card card) throws NotYourTurnException {

        Player roundWiner = this.actualRound.playAgainst(player, card);
        this.actualPlayer = roundWiner;

        rounds.add(this.actualRound);

        return this;

    }

    public Point getPoints() {

    }



}
