package com.lab3.BeerAdviser.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by piotrek on 17.03.16.
 */
public class EkspertPiwny {


    List marki = new ArrayList();

    public EkspertPiwny(String color){
        if (color.equals("bursztynowy")) {
            marki.add("bursz1");
            marki.add("bursz2");
            marki.add("bursz3");
            marki.add("bursz4");
        } else if (color.equals("jasny")) {
            marki.add("jasny1");
            marki.add("jasny2");
            marki.add("jasny3");
            marki.add("jasny4");
        }else if (color.equals("brazowy")) {
            marki.add("brazowy1");
            marki.add("brazowy2");
            marki.add("brazowy3");
            marki.add("brazowy4");
        } else {
            marki.add("ciemny1");
            marki.add("ciemny2");
            marki.add("ciemny3");
            marki.add("ciemny4");
        }
    }
    public List<String> getMarki() {
        return marki;
    }
}
