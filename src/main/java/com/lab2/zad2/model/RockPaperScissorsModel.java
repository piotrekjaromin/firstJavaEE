package com.lab2.zad2.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by piotrek on 10.03.16.
 */
public class RockPaperScissorsModel {
    private List<String> value = new ArrayList<>();
    public RockPaperScissorsModel(){
        value.add("rock");
        value.add("paper");
        value.add("scissors");
    }

    public List<String> getValue() {
        return value;
    }

    public String generate(){
        int random = (int)(Math.random() *3);
        return value.get(random);
    }

    public void setValue(List<String> value) {
        this.value = value;
    }

}
