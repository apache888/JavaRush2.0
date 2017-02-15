package com.javarush.task.task05.task0507;

/* 
Среднее арифметическое
*/

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        int count = 0;
        int num;
        while (true) {
            num = scanner.nextInt();
            if (num == -1) break;
            sum += num;
            count++;
        }
        System.out.println(sum*1.0/count);
    }
}

