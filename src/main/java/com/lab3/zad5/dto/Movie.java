package com.lab3.zad5.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by piotrek on 28.03.16.
 */
public class Movie {
    private String title;
    private String Type;
    private short year;
    private double income;

    public Movie(String title, double income, short year, String type) {
        this.title = title;
        this.income = income;
        this.year = year;
        Type = type;
    }

    public static List<Movie> getMovies(){
        List<Movie> movies = new ArrayList();
        movies.add(new Movie("title1", 1234.4, (short)4325, "type1"));
        movies.add(new Movie("title2", 1242334.4, (short)8765, "wojenny"));
        movies.add(new Movie("title3", 12344.4, (short)2345, "type3"));
        return movies;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public short getYear() {
        return year;
    }

    public void setYear(short year) {
        this.year = year;
    }

    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }
}
