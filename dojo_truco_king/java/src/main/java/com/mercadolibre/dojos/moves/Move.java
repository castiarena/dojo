package com.mercadolibre.dojos.moves;

import com.mercadolibre.dojos.Player;
import com.mercadolibre.dojos.Point;

public class Move implements IMove {
    private String name;
    private Player player;
    protected Point points;

    Move(String name, Player player) {
        this.name = name;
        this.player = player;
    }

    @Override
    public String print() {
        return this.name;
    }

    @Override
    public Point forPlayer(Player player) {
        this.player = player;
        return this.points;
    }
}
