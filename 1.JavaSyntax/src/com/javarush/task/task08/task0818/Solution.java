package com.javarush.task.task08.task0818;

import java.util.HashMap;
import java.util.Map;

/* 
Только для богачей
*/

public class Solution {
    public static HashMap<String, Integer> createMap() {
        //напишите тут ваш код
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Bogdanov", 550);
        map.put("Dirunov", 550);
        map.put("Ivanov", 450);
        map.put("Petrov", 450);
        map.put("Sidorov", 450);
        map.put("Kurkov", 550);
        map.put("Zhukov", 600);
        map.put("Popov", 550);
        map.put("Bodunov", 550);
        map.put("Shahov", 550);

        return map;
    }

    public static void removeItemFromMap(HashMap<String, Integer> map) {
        //напишите тут ваш код
        HashMap<String, Integer> coyMap = new HashMap<>(map);
        for (Map.Entry<String, Integer> pair : coyMap.entrySet()) {
            if (pair.getValue() < 500) {
                map.remove(pair.getKey());
            }
        }
    }

    public static void main(String[] args) {

    }
}