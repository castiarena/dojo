package com.mercadolibre.dojos;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Round {

    private Card firstCard;
    private Card lastCard;

    private ArrayList<Card> cardsOrdered;

    private ArrayList<Player> playersOrdered;

    public Round(Player playerStart, Player playerSeccond){
        cardsOrdered = new ArrayList<>();
        playersOrdered = new ArrayList<>();
        playersOrdered.add(playerStart);
        playersOrdered.add(playerSeccond);
        playerStart.iCanPlay();
        playerSeccond.iCanNotPlay();
    }

    public void playerThrowFirstCard( Player player, Card card) throws Exception {
        if (playersOrdered.get(0) != player) {
            throw new Exception("No sos mano");
        }

        firstCard = player.throwCard(card);
    }

    public Round playerThrowLastCard(Player player, Card card) {
        lastCard = player.throwCard(card);
        Player winner = defineWinner();
        Player looser = defineLooser(winner);

        return new Round(winner, looser);
    }

    public Player defineWinner(){
        Card winnerCard = firstCard.versus(lastCard);

        Player winner = playersOrdered.stream().filter(
                player -> player.hasCard(winnerCard)
        ).collect(Collectors.toList()).get(0);

        return winner;
    }

    public Player defineLooser(Player winner) {
        return playersOrdered.stream()
                .filter(player -> !player.equals(winner))
                .collect(Collectors.toList()).get(0);
    }
}
