package com.mercadolibre.dojos;

public class Point {
    private Integer amount;
    Point(Integer amount) {
        this.amount = amount;
    }

    public String print(){
        String subfix = this.amount > 1 ? "puntos" : "punto";
        return Integer.toString(this.amount) + " " + subfix;
    }
}
