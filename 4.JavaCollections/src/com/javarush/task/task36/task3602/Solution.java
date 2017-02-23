package com.javarush.task.task36.task3602;

import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* 
Найти класс по описанию (private static class EmptyList<E>)
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getExpectedClass());
    }

    public static Class getExpectedClass() {
        Class result = null;
//        List<Class> classList = new ArrayList<>();
        Class[] classes = Collections.class.getDeclaredClasses();
        for (Class clazz : classes) {
            if (clazz.getSimpleName().equals("EmptyList")) return clazz; // so simple
//            if (Modifier.isStatic(clazz.getModifiers()) && Modifier.isPrivate(clazz.getModifiers())) {
//                Class[] interfaces = clazz.getInterfaces();
//                for (Class c : interfaces) {
//                    if (c.equals(List.class)) {
//                        result = clazz;
////                        classList.add(clazz);
//                    }
//                }
//            }
        }
//        System.out.println(classList.isEmpty());
//        System.out.println(classes.length == 0);
//            for (Class aClass : classList) {
//                System.out.println(aClass.getSimpleName());
//            }
            return result;
        }
    }