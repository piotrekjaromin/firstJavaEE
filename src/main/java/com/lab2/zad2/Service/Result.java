package com.lab2.zad2.Service;

/**
 * Created by piotrek on 27.03.16.
 */
public class Result {

    public static String compare(String a, String b) {
        if(a.equals("paper") && b.equals("rock"))
            return "You won";
        else if(a.equals("rock") && b.equals("paper"))
            return "You lost";
        else if(a.equals("paper") && b.equals("scissors"))
            return "You lost";
        else if(a.equals("scissors") && b.equals("paper"))
            return "You won";
        else if(a.equals("scissors") && b.equals("rock"))
            return "You lost";
        else if(a.equals("rock") && b.equals("scissors"))
            return "You won";
        else if(a.equals(b))
            return "Draw";
        else
            return "Error";
    }
}
