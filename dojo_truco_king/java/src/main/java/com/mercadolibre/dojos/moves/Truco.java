package com.mercadolibre.dojos.moves;

import com.mercadolibre.dojos.Player;
import com.mercadolibre.dojos.Point;

public class Truco extends Move{

    public Truco(Player player){
        super("Truco");
        this.points = new Point(2);
    }
}
