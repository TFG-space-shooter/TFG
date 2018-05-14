package com.solarsystem.game.util;

import java.text.DecimalFormat;

public class Format {

    private static DecimalFormat format = new DecimalFormat("###,###,###,##0");

  
    public static String format(int number){
        return format.format(number);
    }
}
