package com.mercadolibre.dojos;

public class Move implements IMove {
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
