package com.mercadolibre.dojos;

import com.mercadolibre.dojos.cards.*;
import org.junit.Assert;
import org.junit.Test;

public class PlayerTest {

    @Test
    public void test_return_player_if_has_a_card() {

        Player esteban = new Player("Esteban");

        esteban.upCards(new UnoDeEspada(), new TresDeEspadas(), new CuatroDeCopas());

        Player raul = new Player("Raul");

        raul.upCards(new UnoDeBasto(), new CuatroDeBasto(), new SieteDeBasto());

        Player winnerPlayer = esteban.challengeWith(raul, new UnoDeEspada());

        Assert.assertTrue(winnerPlayer.equals(esteban));

    }

}
