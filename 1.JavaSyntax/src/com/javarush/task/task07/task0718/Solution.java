package com.javarush.task.task07.task0718;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Проверка на упорядоченность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(reader.readLine());
        }
        int currentLength = list.get(0).length();
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).length() > currentLength) {
                currentLength = list.get(i).length();

            } else{
                System.out.println(i);
                break;
            }
        }
        reader.close();
    }
}

