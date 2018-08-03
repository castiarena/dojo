package com.mercadolibre.dojos.moves;

import com.mercadolibre.dojos.Player;
import com.mercadolibre.dojos.Point;

public class NoneMove implements IMove{
    private String name;
    private Point points;

    public NoneMove(){
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
