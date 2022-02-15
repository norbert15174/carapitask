package pl.carapi.demo.models.enums;

import lombok.Getter;

@Getter
public enum Color {
    RED("CZERWONY" , "RED"),
    BLUE("NIEBIESKI" , "BLUE"),
    GREEN("ZIELONY" , "GREEN"),
    GREY("SZARY" , "GREY"),
    YELLOW("ŻÓŁTY" , "YELLOW");

    Color(String plValue , String engValue) {
        this.plValue = plValue;
        this.engValue = engValue;
    }

    private String plValue;
    private String engValue;

}
