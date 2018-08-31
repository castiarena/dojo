package com.mercadolibre.dojos;

import com.mercadolibre.dojos.cards.Card;
import com.mercadolibre.dojos.moves.IMove;
import com.mercadolibre.dojos.moves.Move;
import com.mercadolibre.dojos.moves.NoneMove;

public class Round {

    private Card firstCard;
    private Card secondCard;
    private Player firstPlayer;
    private Player secondPlayer;

    public Round(Player player, Card card) {
        firstPlayer = player;
        firstCard = card;
    }

    public Player playAgainst (Player player, Card card) throws NotYourTurnException {

        if (this.firstPlayer == player){
            throw new NotYourTurnException(player);
        }
        this.secondPlayer = player;
        this.secondCard = card;

        Card winnerCard = this.secondCard.versus(this.firstCard);

        Player winnerPlayer = this.firstPlayer.challengeWith(this.secondPlayer, winnerCard);

        return winnerPlayer;

    }


}
