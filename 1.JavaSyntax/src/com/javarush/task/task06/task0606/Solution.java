package com.javarush.task.task06.task0606;

import java.io.*;
import java.util.Scanner;

/* 
Чётные и нечётные циферки
*/

public class Solution {

    public static int even;
    public static int odd;

    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        char[] nums = String.valueOf(num).toCharArray();
        for (char digit : nums) {
            if (Integer.parseInt(String.valueOf(digit)) % 2 == 0) {
                even++;
            }else odd++;
        }
        System.out.printf("Even: %d Odd: %d", even, odd);
    }
}
