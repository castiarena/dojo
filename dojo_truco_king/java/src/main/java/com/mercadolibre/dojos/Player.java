package com.mercadolibre.dojos;

import com.mercadolibre.dojos.cards.Card;
import com.mercadolibre.dojos.cards.CardNotFound;
import com.mercadolibre.dojos.moves.IMove;
import com.mercadolibre.dojos.moves.Move;
import com.mercadolibre.dojos.moves.NoneMove;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private List<Card> cards = new ArrayList<>();
    private String name;
    private ArrayList<IMove> wantMoveList = new ArrayList<>();
    private IMove winMove = new NoneMove();

    public Player(String name) {
        this.name = name;
    }

    public void upCards(Card firstCard, Card secondCard, Card thirdCard){
        this.cards.add(firstCard);
        this.cards.add(secondCard);
        this.cards.add(thirdCard);
    }

    public Move sing(Move move){
        return move;
    }

    public Hand throwCard(Card cardToPlay, Hand hand) throws NotYourTurnException {
        return hand.startRoundFor(this, cardToPlay);
    }

    public Hand throwLastCard(Card cardToPlay, Hand hand) throws NotYourTurnException{

        return hand.continueRoundFor(this, cardToPlay);

    }

    public Player challengeWinnerByCardOrDefault(Card cardToChanllege, Player otherPlayer) {
        boolean meHasTheCard = this.cards.stream()
                .anyMatch(card -> card.equals(cardToChanllege));

        return meHasTheCard ? this : otherPlayer;
    }

    public Player challengeLooserByCardOrDefault(Card cardToChanllenge, Player otherPlayer) {
        boolean heHasTheCard = otherPlayer.cards.stream()
                .anyMatch(card -> card.equals(cardToChanllenge));

        return heHasTheCard ? this : otherPlayer;
    }

    public Move pickMove(Move move){
        return move;
    }

    public void want(Move sing){
        this.wantMoveList.add(sing);
    }

    public void saveWinMove(IMove move){
        this.winMove = move;
    }

    public String print(){
        return this.name;
    }

    public Point summaryPoints(){
        return this.winMove.forPlayer(this);
    }
}
