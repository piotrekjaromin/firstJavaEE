package com.lab2.car;


import java.util.ArrayList;
import java.util.List;

class Car {
    private String name;
    private Double price;

    public Car(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String toString() {
        return "name: " + name + ", price: " + price;
    }

}

public class CarChoiceHelper {
    private List<Car> sportCars = new ArrayList<>();
    private List<Car> luxuryCars = new ArrayList<>();
    private List<Car> cityCars = new ArrayList<>();

    public CarChoiceHelper() {
        sportCars.add(new Car("sport1", 100000.0));
        sportCars.add(new Car("sport2", 50000.0));
        sportCars.add(new Car("sport3", 30000.0));

        luxuryCars.add(new Car ("luxusy1", 500000.0));
        luxuryCars.add(new Car ("luxusy2", 200000.0));
        luxuryCars.add(new Car ("luxusy3", 100000.0));


        cityCars.add(new Car ("cityCar1", 300000.0));
        cityCars.add(new Car ("cityCar2", 200000.0));
        cityCars.add(new Car ("cityCar3", 50000.0));
    }

    public List<Car> getSportCars() {
        return sportCars;
    }

    public void setSportCars(List<Car> sportCars) {
        this.sportCars = sportCars;
    }

    public List<Car> getCityCars() {
        return cityCars;
    }

    public void setCityCars(List<Car> cityCars) {
        this.cityCars = cityCars;
    }

    public List<Car> getLuxuryCars() {
        return luxuryCars;
    }

    public void setLuxuryCars(List<Car> luxuryCars) {
        this.luxuryCars = luxuryCars;
    }

    public List<Car> getCars(String type, double priceFrom, double priceTo) {
        if(type.equals("sportowy")){
            return (getCarsBetween(sportCars, priceFrom, priceTo));
        } else if(type.equals("luksusowy")){
            return (getCarsBetween(luxuryCars, priceFrom, priceTo));
        } else
            return (getCarsBetween(cityCars, priceFrom, priceTo));
    }

    private List<Car>getCarsBetween(List<Car> cars, double priceFrom, double priceTo){
        List<Car> result = new ArrayList<>();

        for(Car car : cars){
            if(car.getPrice()>=priceFrom && car.getPrice()<=priceTo)
                result.add(car);
        }
        return result;
    }
}
