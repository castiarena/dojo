package com.mercadolibre.dojos;

import com.mercadolibre.dojos.cards.*;
import org.junit.Ignore;
import org.junit.Test;

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

	/**
	 * el jugador mano tiene el ancho de espadas, 3 de espadas, 4 de copas
	 * el jugador 2 tiene el ancho de basto, 4 de basto y 7 de basto
	 * jugador 1 juega el ancho de espada
	 * jugador 2 juega el 4 de basto
	 * opcion a- jugador 1 puede jugar el 3 de espada
	 */
	@Test
	public void aPlayerWinARoundAndThrowOneCard() throws Exception {

		Player juan = new Player("juan");
		juan.upCards(new UnoDeEspada(), new TresDeEspadas(), new CuatroDeCopas());

		Player ricardo = new Player("ricardo");
		ricardo.upCards(new UnoDeBasto(), new CuatroDeBasto(), new SieteDeBasto());

		Hand hand = new Hand(juan);

		juan.throwCard(new UnoDeEspada(), hand);

		ricardo.throwLastCard(new CuatroDeBasto(), hand);

		juan.throwCard(new TresDeEspadas(), hand);
	}

    /**
     * el jugador mano tiene el ancho de espadas, 3 de espadas, 4 de copas
     * el jugador 2 tiene el ancho de basto, 4 de basto y 7 de basto
     * jugador 1 juega el ancho de espada
     * jugador 2 juega el 4 de basto
     opcion b- jugador 2 intenta jugar y no puede.
     */
    @Test (expected = NotYourTurnException.class)
    public void aPlayerLoseARoundAndTryToThrowA() throws Exception{
		Player esteban = new Player("Esteban");

		esteban.upCards(new UnoDeEspada(), new TresDeEspadas(), new CuatroDeCopas());

		Player raul = new Player("Raul");

		raul.upCards(new UnoDeBasto(), new CuatroDeBasto(), new SieteDeBasto());

		Hand hand = new Hand(esteban);

		hand = esteban.throwCard(new UnoDeEspada(), hand);

		hand = raul.throwLastCard(new CuatroDeBasto(), hand);

		raul.throwCard(new UnoDeBasto(), hand);

    }

	/**
	 * El jugador 1 juega el ancho de espada y El jugador 2 juega el 4 de basto,
	 *   el jugador 1 juega el tres de espada, el 2 el el ancho de basto, y por ultimo
	 *   el jugador 2 juega el 7 de basto y el 1 juega el 4 de copas
	 *   el jugador 1 no tiene puntos y el jugador 2 tiene 1 punto
	 */
	@Test
	public void aPlayerWinTheRoundWithOnePoint() throws Exception{

		Player esteban = new Player("Esteban");

		esteban.upCards(new UnoDeEspada(), new TresDeEspadas(), new CuatroDeCopas());

		Player raul = new Player("Raul");

		raul.upCards(new UnoDeBasto(), new CuatroDeBasto(), new SieteDeBasto());

		Hand hand = new Hand(esteban);

		hand = esteban.throwCard(new UnoDeEspada(), hand);

		hand = raul.throwLastCard(new CuatroDeBasto(), hand);

		hand = esteban.throwCard(new TresDeEspadas(), hand);

		hand = raul.throwLastCard(new UnoDeBasto(), hand);

		hand = raul.throwCard(new TresDeEspadas(), hand);

		hand = esteban.throwLastCard(new UnoDeBasto(), hand);

	}

	/**
	 * Pepe tira el 3 de espadas, Juan tira el uno de basto
	 * Juan canta truco, pepe acepta
	 * Juan tira el 3 de copas, Pepe tira el uno de espadas
	 * Pepe tira el 7 de basto y Juan tira el 4 de basto
	 * Pepe gana la mano con 2 puntos
	 */
	@Test
	@Ignore
	public void aPlayerWinWhitMoveTrick() throws Exception{

	}
	
}
