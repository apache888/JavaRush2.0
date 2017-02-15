package com.javarush.task.task10.task1006;

/* 
Задача №6 на преобразование целых типов
*/

public class Solution {
    public static void main(String[] args) {
        short b = 45;
//        short b = (short) 45;
        char c = 'c';
//        char c = (short) 'c';
        short s = (short) 1005.22;
//        short s = (short) 1005.22;
        int i = 150000;
//        int i = (short) 150000;
        float f =  4.10f;
//        float f = (short) 4.10f;
        double d =  1.256d;
//        double d = (short) 1.256d;
        double result = (f * b) + (i / c) - (d * s) + 562.78d;
//        double result = (f * b) + (i / c) - (d * s) + 562.78d;
        System.out.println("result: " + result);
    }
}