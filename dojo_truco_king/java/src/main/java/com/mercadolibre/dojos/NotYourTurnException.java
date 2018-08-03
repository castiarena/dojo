package com.mercadolibre.dojos;

public class NotYourTurnException extends Exception{
    public NotYourTurnException(Player player){
        super("Tranca " +player.print()+ ", no vas vos");
    }
}
