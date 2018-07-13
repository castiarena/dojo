package com.mercadolibre.dojos;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Tests for the dojo.
 */

/*



el jugador mano tiene el ancho de espadas, 3 de espadas, 4 de copas
el jugador 2 tiene el ancho de basto, 4 de basto y 7 de basto
jugador 1 juega el ancho de espada
jugador 2 juega el 4 de basto
opcion a- jugador 1 puede jugar el 3 de espada
opcion b- jugador 2 intenta jugar y no puede.

 */

public class KingTrickTest {

	private List<Card> playerBInitialCards() {
		return new ArrayList<Card>() {
			{
				add(new Card("ancho de basto"));
				add(new Card("4 de ebasto"));
				add(new Card("7 de basto"));
			}
		};
	}

	private List<Card> playerAInitialCards() {
		return new ArrayList<Card>() {
			{
				add(new Card("ancho de espadas"));
				add(new Card("3 de espadas"));
				add(new Card("4 de copas"));
			}
		};
	}
	/**
	 * el jugador mano tiene el ancho de espadas, 3 de espadas, 4 de copas
	 * el jugador 2 tiene el ancho de basto, 4 de basto y 7 de basto
	 * jugador 1 juega el ancho de espada
	 * jugador 2 juega el 4 de basto
	 * opcion a- jugador 1 puede jugar el 3 de espada
	 */
	@Test
	public void onePlayerWinARoundAndThrowOneCard  () {
		Player playerA = new Player("playerA", playerAInitialCards());
		Player playerB = new Player("playerB", playerBInitialCards());

		playerA.throwCard(new Card("ancho de espadas"));
		playerB.throwCard(new Card("4 de basto"));

		Card tresDeEspadas = new Card("3 de espadas");

		Assert.assertEquals(tresDeEspadas , playerA.throwCard(tresDeEspadas));
	}

    /**
     * el jugador mano tiene el ancho de espadas, 3 de espadas, 4 de copas
     * el jugador 2 tiene el ancho de basto, 4 de basto y 7 de basto
     * jugador 1 juega el ancho de espada
     * jugador 2 juega el 4 de basto
     opcion b- jugador 2 intenta jugar y no puede.
     */
    @Test
    public void onePlayerLoseARoundAndTryToThrowA  () {
        Player playerA = new Player("playerA", playerAInitialCards());
        Player playerB = new Player("playerB", playerBInitialCards());

        playerA.throwCard(new Card("ancho de espadas"));
        playerB.throwCard(new Card("4 de basto"));

        Card tresDeEspadas = new Card("3 de espadas");

        Assert.assertEquals(new CardNotFound() , playerB.throwCard(tresDeEspadas));
    }
	
}
