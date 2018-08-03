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
    private IMove winMove = (IMove) new NoneMove();

    public Player(String name) {
        this.name = name;
    }

    public void upCards(Card firstCard, Card secondCard, Card thirCard){
        this.cards.add(firstCard);
        this.cards.add(secondCard);
        this.cards.add(thirCard);
    }

    public Move sing(Move move){
        return move;
    }

    public Card throwCard(Card cardToPlay) {
        boolean canPlayAndExistCard = this.cards.stream()
            .anyMatch(
                card -> card.equals(cardToPlay)
            );

        return canPlayAndExistCard
                ? cardToPlay
                : new CardNotFound();
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

    public void want(IMove sing){
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
