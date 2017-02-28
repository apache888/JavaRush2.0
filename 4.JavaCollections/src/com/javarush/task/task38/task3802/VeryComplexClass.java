package com.javarush.task.task38.task3802;

/* 
Проверяемые исключения (checked exception)
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;

public class VeryComplexClass {
    public void veryComplexMethod() throws Exception {
        //напишите тут ваш код
        InputStream stream = new FileInputStream("qwerty");
    }

    public static void main(String[] args) {
//        try {
//            new VeryComplexClass().veryComplexMethod();
//        } catch (Exception e) {
//            System.out.println("Excaption!");
//        }
    }
}
