package com.mercadolibre.dojos;

import com.mercadolibre.dojos.cards.Card;
import com.mercadolibre.dojos.moves.IMove;
import com.mercadolibre.dojos.moves.Move;
import com.mercadolibre.dojos.moves.NoneMove;

public class Round {

    private Card firstCard;
    private Card secondCard;
    private Card winnerCard;
    private Player firstPlayer;
    private Player secondPlayer;
    private Player winnerPlayer;
    private Player looserPlayer;

    private IMove move = new NoneMove();

    public Round(Player firstPlayer, Player secondPlayer){
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
    }

    public Round(Player firstPlayer, Player secondPlayer, IMove move){
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
        this.move = move;
    }

    public Round playerThrowFirstCard( Player player, Card card) throws NotYourTurnException{
        if( player.equals(this.secondPlayer) ){
            throw new NotYourTurnException(player);
        }

        this.firstCard = player.throwCard(card);
        return this;
    }

    public Round playerThrowLastCard(Player player, Card card) throws NotYourTurnException{
        if ( player.equals(this.firstPlayer)) {
            throw new NotYourTurnException(player);
        }

        this.secondCard = player.throwCard(card);

        this.winnerCard = this.firstCard.versus(this.secondCard);
        this.winnerPlayer = this.firstPlayer.challengeWinnerByCardOrDefault(this.winnerCard, this.secondPlayer);
        this.looserPlayer = this.secondPlayer.challengeLooserByCardOrDefault(this.winnerCard, this.firstPlayer);

        this.winnerPlayer.saveWinMove(this.move);
        return new Round(winnerPlayer, looserPlayer, this.move);
    }

    public String result(){
        String roundStatusResult = "Ganó " + this.winnerPlayer.print() + ",";
        roundStatusResult = roundStatusResult + " perdió " + this.looserPlayer.print() + "\n";
        roundStatusResult = roundStatusResult + "    "+ this.move.print() + "\n";
        return roundStatusResult;
    }

    public Point totalPoints(){
        return this.winnerPlayer.summaryPoints();
    }

    public Player challengeWinner(Player playerToChallenge) {
        return playerToChallenge.equals(this.winnerPlayer) ? playerToChallenge : this.winnerPlayer;
    }

    public Move playerPickAMove(Player player, Move move){
        this.move = move;
        return player.pickMove(move);
    }
}
