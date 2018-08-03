package com.mercadolibre.dojos.moves;

import com.mercadolibre.dojos.Player;
import com.mercadolibre.dojos.Point;

public interface IMove {
    public String print();
    public Point forPlayer(Player player);
}
