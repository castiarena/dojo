package com.mercadolibre.dojos;

import com.mercadolibre.dojos.cards.Card;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Hand {

    private List<Round> rounds = new ArrayList<>();
    private Round actualRound;
    private Player actualPlayer;
    private Tantos tantos = new Tantos();

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

    public Point pointsOf(Player playerToCalculate) {

        Player player = this.rounds.stream()
                .map(x -> x.winnerPlayer(playerToCalculate))
                .filter()
                .collect(Collectors.toList());


        return this.exposeWinnerPoints(player);
    }

    private Point exposeWinnerPoints(Player player){

    }

    private Point exposeWinnerPoints(NonePlayer player){

    }


}
