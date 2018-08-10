package com.mercadolibre.dojos;

import com.mercadolibre.dojos.cards.*;
import com.mercadolibre.dojos.moves.IMove;
import com.mercadolibre.dojos.moves.Move;
import com.mercadolibre.dojos.moves.Truco;
import org.junit.Assert;
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

		Round firstRound = new Round(juan, ricardo);

		firstRound.playerThrowFirstCard(juan, new UnoDeEspada());
		Round secondRound = firstRound.playerThrowLastCard(ricardo, new CuatroDeBasto());

		secondRound.playerThrowFirstCard(juan, new TresDeEspadas());
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

		Round firstRound = new Round(esteban, raul);

		firstRound.playerThrowFirstCard(esteban, new UnoDeEspada());

		Round round2 = firstRound.playerThrowLastCard(raul, new CuatroDeBasto());
		round2.playerThrowFirstCard( raul, new TresDeEspadas() );
    }

	/**
	 * El jugador 1 juega el ancho de espada y El jugador 2 juega el 4 de basto,
	 *   el jugador 1 juega el tres de espada, el 2 el el ancho de basto, y por ultimo
	 *   el jugador 2 juega el 7 de basto y el 1 juega el 4 de copas
	 *   el jugador 1 no tiene puntos y el jugador 2 tiene 1 punto
	 */
	@Test
	public void aPlayerWinTheRoundWithOnePoint() throws Exception{
		Player diego = new Player("Diego");
		diego.upCards(new UnoDeEspada(), new TresDeEspadas(), new CuatroDeCopas());

		Player juli = new Player("Juli");
		juli.upCards( new CuatroDeBasto(), new SieteDeBasto(), new UnoDeBasto());

		Round firstRound = new Round(diego, juli);
		firstRound.playerThrowFirstCard(diego, new UnoDeEspada());
		Round secondRound = firstRound.playerThrowLastCard(juli, new CuatroDeBasto());

		secondRound.playerThrowFirstCard(diego, new TresDeEspadas());
		Round thirdRound = secondRound.playerThrowLastCard(juli, new UnoDeBasto());

		thirdRound.playerThrowFirstCard(juli, new SieteDeBasto());
		thirdRound.playerThrowLastCard(diego, new CuatroDeCopas());

		Hand hand = new Hand(firstRound, secondRound, thirdRound);
		Assert.assertEquals(hand.result(), "Ganó la mano Juli con 1 punto");
		Assert.assertEquals(hand.summary(), "Primera jugada:\n" +
				"  Ganó Diego, perdió Juli\n" +
				"    no se cantó nada\n" +
				"Segunda jugada:\n" +
				"  Ganó Juli, perdió Diego\n" +
				"    no se cantó nada\n" +
				"Tercera jugada:\n" +
				"  Ganó Juli, perdió Diego\n" +
				"    no se cantó nada\n");

	}

	/**
	 * Pepe tira el 3 de espadas, Juan tira el uno de basto
	 * Juan canta truco, pepe acepta
	 * Juan tira el 3 de copas, Pepe tira el uno de espadas
	 * Pepe tira el 7 de basto y Juan tira el 4 de basto
	 * Pepe gana la mano con 2 puntos
	 */
	@Test
	public void aPlayerWinWhitMoveTrick() throws Exception{
		Player pepe = new Player("Pepe");
		pepe.upCards(new TresDeEspadas(), new UnoDeEspada(), new SieteDeBasto());

		Player juan = new Player("Juan");
		juan.upCards(new UnoDeBasto(), new TresDeCopas(), new CuatroDeBasto());

		Round firstRound = new Round(pepe, juan);
		firstRound.playerThrowFirstCard(pepe, new TresDeEspadas());

		Round secondRound = firstRound.playerThrowLastCard(juan, new UnoDeBasto());

		Move trick = juan.sing(new Truco());
		pepe.want(trick);

		secondRound.playerThrowFirstCard(juan, new TresDeCopas());
		Round thirdRound = secondRound.playerThrowLastCard(pepe, new UnoDeEspada());

		thirdRound.playerThrowFirstCard(pepe, new SieteDeBasto());
		thirdRound.playerThrowLastCard(juan, new CuatroDeBasto());

		Hand mano = new Hand(firstRound, secondRound, thirdRound);

		Assert.assertEquals(mano.result(), "Ganó la mano Pepe con 2 puntos");
	}
	
}
