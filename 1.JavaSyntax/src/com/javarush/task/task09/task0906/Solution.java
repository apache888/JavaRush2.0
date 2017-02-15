package com.javarush.task.task09.task0906;

/* 
Логирование стек трейса
*/

public class Solution {
    public static void main(String[] args) {
        log("In main method");
    }

    public static void log(String s) {
        //напишите тут ваш код
        StackTraceElement[] elements = Thread.currentThread().getStackTrace();
        StackTraceElement method = null;
        for (int i = 0; i < elements.length; i++) {
            if (elements[i].getMethodName().equals("log")) {
                method = elements[i+1];
            }
        }

        System.out.println(method.getClassName() + ": " + method.getMethodName() + ": " + s);
    }
}
