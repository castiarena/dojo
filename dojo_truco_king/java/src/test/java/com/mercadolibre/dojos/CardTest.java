package com.mercadolibre.dojos;

import com.mercadolibre.dojos.cards.Card;
import com.mercadolibre.dojos.cards.TresDeCopas;
import com.mercadolibre.dojos.cards.UnoDeEspada;
import org.junit.Assert;
import org.junit.Test;

public class CardTest {

    @Test
    public void test_card_against_other (){

        Card asDeEspada = new UnoDeEspada();

        Card tresDeCopas = new TresDeCopas();

        Card winnerCard = asDeEspada.versus(tresDeCopas);

        Assert.assertTrue(asDeEspada.equals(winnerCard));
    }
}
