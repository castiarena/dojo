package com.mercadolibre.dojos;

public class NotYourTurnException extends Exception{
    NotYourTurnException(Player player){
        super("Tranca " +player.print()+ ", no vas vos");
    }
}
