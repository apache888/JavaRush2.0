package com.javarush.task.task27.task2712.kitchen;

import java.util.Observable;
import java.util.Observer;

public class Cook extends Observable implements Observer {

    private String name;

    public Cook(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Cook{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public void update(Observable obj, Object arg) {
        Order order = (Order) arg;
        System.out.println("Start cooking - " + order + ", cooking time " + order.getTotalCookingTime() + "min");
        setChanged();
        notifyObservers(order);
    }
}
