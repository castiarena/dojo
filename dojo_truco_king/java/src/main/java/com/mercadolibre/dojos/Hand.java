package com.mercadolibre.dojos;

import java.util.*;

public class Hand {
    private Round firstRound;
    private Round secondRound;
    private Round thirdRound;

    private Map<Integer,String> roundsNames = new HashMap<Integer, String>(){{
        put(0, "Primera jugada");
        put(1, "Segunda jugada");
        put(2, "Tercera jugada");
    }};

    Hand(Round firstRound, Round secondRound, Round thirdRound) {
        this.firstRound = firstRound;
        this.secondRound = secondRound;
        this.thirdRound = thirdRound;
    }

    private void iterateForRounds(RoundIterator lambda){
        ArrayList<Round> rounds = new ArrayList<Round>(){{
            add(firstRound); add(secondRound); add(thirdRound);
        }};

        for( int i = 0; i < rounds.size(); i++) {
            lambda.eachRound( rounds.get(i), i);
        }
    }

    private Player winnerPlayer(ArrayList<Player> roundWinners){
        Set<Player> uniquePlayer = new HashSet<>(roundWinners);
        Map<Integer, Player> timesPlayerAppear = new HashMap<>();
        for (Player key : uniquePlayer) {
            timesPlayerAppear.put(Collections.frequency(roundWinners, key), key);
        }
        return timesPlayerAppear.get(2);
    }

    public String result(){
        ArrayList<Player> roundWinners = new ArrayList<>();
        this.iterateForRounds((round, index) ->
            roundWinners.add(round.challengeWinner(new NonePlayer()))
        );

        Player handWinner = this.winnerPlayer(roundWinners);
        Point lastRoundPoints = thirdRound.totalPoints();
        return "Ganó la mano " + handWinner.print() + " con " + lastRoundPoints.print();
    }

    public String summary() {
        ArrayList<String> roundsResult = new ArrayList<>();
        this.iterateForRounds((round, index) ->
            roundsResult.add( this.roundsNames.get(index) + ":\n  " + round.result() )
        );
        return roundsResult.stream()
                .reduce("", (roundResultA, roundResultB) -> roundResultA + roundResultB);
    }
}
