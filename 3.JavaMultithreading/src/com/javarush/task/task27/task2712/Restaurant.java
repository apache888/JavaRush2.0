package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.kitchen.Waitor;

import java.util.Observer;

public class Restaurant {

    public static void main(String[] args) {

        Tablet tablet = new Tablet(5);
        Cook firstCook = new Cook("Amigo");
        Observer firstWaitor = new Waitor();
        tablet.addObserver(firstCook);
        firstCook.addObserver(firstWaitor);
        tablet.createOrder();


    }
}
