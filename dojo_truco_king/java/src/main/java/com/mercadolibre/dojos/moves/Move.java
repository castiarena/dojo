package com.mercadolibre.dojos.moves;

import com.mercadolibre.dojos.Player;
import com.mercadolibre.dojos.Point;

public abstract class Move implements IMove {
    private String name;
    private Player player;
    protected Point points;

    Move(String name) {
        this.name = name;
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
