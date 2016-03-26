package com.lab2.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by piotrek on 10.03.16.
 */
public class PapKamNoz {
    private List<String> value = new ArrayList<>();
    public PapKamNoz(){
        value.add("papier");
        value.add("kamien");
        value.add("nozyce");
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

    public int compare(String a, String b) {
        if(a.equals("papier") && b.equals("kamien"))
            return 1;
        else if(a.equals("kamien") && b.equals("papier"))
            return -1;
        else if(a.equals("papier") && b.equals("nozyce"))
            return -1;
        else if(a.equals("nozyce") && b.equals("papier"))
            return 1;
        else if(a.equals("nozyce") && b.equals("kamien"))
            return -1;
        else if(a.equals("kamien") && b.equals("nozyce"))
            return 1;
        else if(a.equals(b))
            return 0;
        else
            return 100;
    }

}
