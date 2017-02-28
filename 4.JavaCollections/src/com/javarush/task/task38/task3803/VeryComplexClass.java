package com.javarush.task.task38.task3803;

/* 
Runtime исключения (unchecked exception)
*/

import java.util.TreeMap;

public class VeryComplexClass {
    public void methodThrowsClassCastException() {
        Object x = new Integer(0);
        System.out.println((String)x);
    }

    public void methodThrowsNullPointerException() {
        System.out.println(new TreeMap<String, Integer>().put(null, null));

    }

    public static void main(String[] args) {

    }
}
