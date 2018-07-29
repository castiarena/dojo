package com.mercadolibre.dojos;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private List<Card> cards;
    private String name;
    private ArrayList<Sing> propussedSingList = new ArrayList<>();
    private ArrayList<Sing> wantSingList = new ArrayList<>();
    private IMove winMove = (IMove) new NoneMove();

    public Player(List<Card> cards, String name) {
        this.cards = cards;
        this.name = name;
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

    public Sing pickMove(Move move){
        Sing playerSing = new Sing(this, move);
        this.propussedSingList.add(playerSing);

        return playerSing;
    }

    public void want(Sing sing){
        this.wantSingList.add(sing);
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
