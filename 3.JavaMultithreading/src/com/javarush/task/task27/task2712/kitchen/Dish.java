package com.javarush.task.task27.task2712.kitchen;

public enum Dish {
    Fish(25),
    Steak(30),
    Soup(15),
    Juice(5),
    Water(3);
    private int duration;  //minutes

    Dish(int duration) {
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }

    public static String allDishesToString(){
        Dish [] dishes = Dish.values();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < dishes.length - 1; i++) {
            builder.append(dishes[i].toString());
            builder.append(", ");
        }
        builder.append(dishes[dishes.length - 1].toString());

        return builder.toString();
    }
}
