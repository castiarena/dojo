package com.mercadolibre.dojos;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
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

	Player playerA;
	Player playerB;

	@Before
	public void executeBeforeEach(){
		playerA = new Player(
				new ArrayList<Card>(){{
					add(new UnoDeEspada());
					add(new TresDeEspadas());
					add(new CuatroDeCopas());
				}});

		playerB = new Player(
				new ArrayList<Card>(){{
					add(new UnoDeBasto());
					add(new CuatroDeBasto());
					add(new SieteDeBasto());
				}});
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
		playerA.throwCard(new UnoDeEspada());
		playerB.throwCard(new CuatroDeBasto());

		Card tresDeEspadas = new TresDeEspadas();

		Assert.assertTrue( tresDeEspadas.equals(
				playerA.throwCard(tresDeEspadas)
		));

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
		Round round1 = new Round(playerA, playerB);

		try {
			round1.playerThrowFirstCard( playerA, new UnoDeEspada() );
		} catch (Exception e) {
			Assert.assertEquals("Esto no deberia pasar", "");
		}

		Round round2 = round1.playerThrowLastCard( playerB, new CuatroDeBasto() );

		try {
			round2.playerThrowFirstCard(playerB, new TresDeEspadas() );
		} catch (Exception e) {
			Assert.assertEquals(e.getMessage(), "No sos mano");
		}
    }
	
}
