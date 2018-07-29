package com.mercadolibre.dojos;

public class NoneMove implements IMove{
    private String name;
    private Point points;

    NoneMove(){
        this.name = "no se cantó nada";
        this.points = new Point(1);
    }

    public String print(){
        return this.name;
    }

    public Point forPlayer(Player player) {
        return this.points;
    }
}
