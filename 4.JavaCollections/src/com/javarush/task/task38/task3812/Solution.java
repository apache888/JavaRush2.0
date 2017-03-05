package com.javarush.task.task38.task3812;

/* 
Обработка аннотаций
*/

import java.lang.annotation.Annotation;

public class Solution {
    public static void main(String[] args) {
        printFullyQualifiedNames(Solution.class);
        printFullyQualifiedNames(SomeTest.class);

        printValues(Solution.class);
        printValues(SomeTest.class);
    }

    public static boolean printFullyQualifiedNames(Class c) {
        if (c.isAnnotationPresent(PrepareMyTest.class)) {
            PrepareMyTest myTest = (PrepareMyTest) c.getAnnotation(PrepareMyTest.class);
            String[] names = myTest.fullyQualifiedNames();
            for (String name : names) {
                System.out.println(name);
            }
            return true;
        }
        return false;
    }

    public static boolean printValues(Class c) {
        if (c.isAnnotationPresent(PrepareMyTest.class)) {
            PrepareMyTest myTest = (PrepareMyTest) c.getAnnotation(PrepareMyTest.class);
            Class[] names = myTest.value();
            for (Class cl : names) {
                System.out.println(cl);
            }
            return true;
        }
        return false;
    }
}
