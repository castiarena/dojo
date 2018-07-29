package com.mercadolibre.dojos;

import com.sun.tools.corba.se.idl.constExpr.Not;
import org.junit.Assert;
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

	/**
	 * el jugador mano tiene el ancho de espadas, 3 de espadas, 4 de copas
	 * el jugador 2 tiene el ancho de basto, 4 de basto y 7 de basto
	 * jugador 1 juega el ancho de espada
	 * jugador 2 juega el 4 de basto
	 * opcion a- jugador 1 puede jugar el 3 de espada
	 */
	@Test
	public void aPlayerWinARoundAndThrowOneCard  () {
		Player playerA = new Player(new ArrayList<Card>(){{
				add(new UnoDeEspada());
				add(new TresDeEspadas());
				add(new CuatroDeCopas());
			}}, "Juan");
		Player playerB = new Player(new ArrayList<Card>(){{
				add(new UnoDeBasto());
				add(new CuatroDeBasto());
				add(new SieteDeBasto());
			}}, "Ricardo");

		Round firstRound = new Round(playerA, playerB);
		try{
			firstRound.playerThrowFirstCard(playerA, new UnoDeEspada());
		}catch(Exception error){ /*en este test no controlamos este error */ }

		try {
			firstRound.playerThrowSecondCard(playerB, new CuatroDeBasto());
		}catch(Exception error){ /*en este test no controlamos este error */ }

		Card tresDeEspadas = new TresDeEspadas();

		Assert.assertTrue( tresDeEspadas.equals(playerA.throwCard(tresDeEspadas)) );

	}

    /**
     * el jugador mano tiene el ancho de espadas, 3 de espadas, 4 de copas
     * el jugador 2 tiene el ancho de basto, 4 de basto y 7 de basto
     * jugador 1 juega el ancho de espada
     * jugador 2 juega el 4 de basto
     opcion b- jugador 2 intenta jugar y no puede.
     */
    @Test
    public void aPlayerLoseARoundAndTryToThrowA  () {
		Player playerA = new Player(new ArrayList<Card>(){{
				add(new UnoDeEspada());
				add(new TresDeEspadas());
				add(new CuatroDeCopas());
			}}, "Esteban");
		Player playerB = new Player(new ArrayList<Card>(){{
				add(new UnoDeBasto());
				add(new CuatroDeBasto());
				add(new SieteDeBasto());
			}}, "Raul");

		Round firstRound = new Round(playerA, playerB);

		try{
			firstRound.playerThrowFirstCard(playerA, new UnoDeEspada());
		}catch(Exception error){ /*en este test no controlamos este error */ }

		try {
			Round round2 = firstRound.playerThrowSecondCard(playerB, new CuatroDeBasto());
			round2.playerThrowFirstCard( playerB, new TresDeEspadas() );
		}catch (NotYourTurnException error){
			Assert.assertEquals(error.getMessage(), "Tranca Raul, no vas vos");
		}
    }

	/**
	 * El jugador 1 juega el ancho de espada y El jugador 2 juega el 4 de basto,
	 *   el jugador 1 juega el tres de espada, el 2 el el ancho de basto, y por ultimo
	 *   el jugador 2 juega el 7 de basto y el 1 juega el 4 de copas
	 *   el jugador 1 no tiene puntos y el jugador 2 tiene 1 punto
	 */
	@Test
	public void aPlayerWinTheRoundWithOnePoint(){
		Player diego = new Player(new ArrayList<Card>(){{
			add(new UnoDeEspada());
			add(new TresDeEspadas());
			add(new CuatroDeCopas());
		}}, "Diego");
		Player juli = new Player(new ArrayList<Card>(){{
			add(new CuatroDeBasto());
			add(new SieteDeBasto());
			add(new UnoDeBasto());
		}}, "Juli");

		try{
			Round firstRound = new Round(diego, juli);
			firstRound.playerThrowFirstCard(diego, new UnoDeEspada());
			Round secondRound = firstRound.playerThrowSecondCard(juli, new CuatroDeBasto());

			secondRound.playerThrowFirstCard(diego, new TresDeEspadas());
			Round thirdRound = secondRound.playerThrowSecondCard(juli, new UnoDeBasto());

			thirdRound.playerThrowFirstCard(juli, new SieteDeBasto());
			thirdRound.playerThrowSecondCard(diego, new CuatroDeCopas());

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
		}catch(NotYourTurnException exception) {
			// no controlamos esta excepcion
		}

	}

	/**
	 * Pepe tira el 3 de espadas, Juan tira el uno de basto
	 * Juan canta truco, pepe acepta
	 * Juan tira el 3 de copas, Pepe tira el uno de espadas
	 * Pepe tira el 7 de basto y Juan tira el 4 de basto
	 * Pepe gana la mano con 2 puntos
	 */
	@Test
	public void aPlayerWinWhitMoveTrick(){
		Player pepe = new Player(new ArrayList<Card>(){{
			add(new TresDeEspadas()); add(new UnoDeEspada()); add(new SieteDeBasto());
		}}, "Pepe");
		Player juan = new Player(new ArrayList<Card>(){{
			add(new UnoDeBasto()); add(new TresDeCopas()); add(new CuatroDeBasto());
		}}, "Juan");

		try {
			Round firstRound = new Round(pepe, juan);
			firstRound.playerThrowFirstCard(pepe, new TresDeEspadas());
			Round secondRound = firstRound.playerThrowSecondCard(juan, new UnoDeBasto());
			secondRound.playerThrowFirstCard(juan, new TresDeCopas());
			Round thirdRound = secondRound.playerThrowSecondCard(pepe, new UnoDeEspada());

			Sing trick = thirdRound.playerPickAMove(juan, new Truco());
			pepe.want(trick);

			thirdRound.playerThrowFirstCard(pepe, new SieteDeBasto());
			thirdRound.playerThrowSecondCard(juan, new CuatroDeBasto());

			Hand mano = new Hand(firstRound, secondRound, thirdRound);
			Assert.assertEquals(mano.result(), "Ganó la mano Pepe con 2 puntos");
		}catch (NotYourTurnException exception) {
			Assert.assertEquals(exception.getMessage(), "No vas vos");
		}
	}
	
}
