package com.javarush.task.task37.task3706;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Давно забытый Array
*/
public class Solution {
    public static void main(String[] args) {
        List<Number> numbers = new ArrayList<>(Arrays.<Number>asList(1, 2, 3));
        addDataToList(numbers, getData());
        System.out.println(numbers);
    }

    public static Number[] getData() {
        ArrayList<Number> list = new ArrayList<>(Arrays.asList(4, 5, 6));
        Number[] nums = new Number[list.size()];
        return list.toArray(nums);
    }

    public static void addDataToList(List<Number> list, Number... data) {
        for (Number number : data) {
            list.add(number);
        }
    }
}
