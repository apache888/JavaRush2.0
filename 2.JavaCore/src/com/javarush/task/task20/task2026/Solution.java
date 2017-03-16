package com.javarush.task.task20.task2026;

/* 
Алгоритмы-прямоугольники
*/
public class Solution {
    public static void main(String[] args) {
        byte[][] a = new byte[][]{
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 1}
        };
        int count = getRectangleCount(a);
        System.out.println("count = " + count + ". Должно быть 2");
    }

    public static int getRectangleCount(byte[][] a) { //общее решение
        int count;
        int verEnd;
        int horEnd;
        int result = 0;
        for (int i = 0; i < a.length; i++){
            for (int j = 0; j < a[i].length; j++){
                if (a[i][j] == 1){
                    verEnd = i;
                    horEnd = j;
                    //по вертикали
                    count = i + 1;
                    while (true){
                        if (count >= a.length || (a[count][j] == 0 && count < a.length)){
                            verEnd = count - 1;
                            break;
                        }
                        count++;
                    }
                    //по горизонтали
                    count = j + 1;
                    while (true){
                        if (count >= a[i].length || (a[i][count] == 0 && count < a[i].length)){
                            horEnd = count - 1;
                            break;
                        }
                        count++;
                    }
                    boolean flag = true;
                    for (int p = i; p <= verEnd; p++)
                        for (int q = j; q <= horEnd; q++)
                            if (a[p][q] != 1){
                                flag = false;
                                break;
                            }
                    if (flag){
                        for (int p = i; p <= verEnd; p++)
                            for (int q = j; q <= horEnd; q++)
                                a[p][q] = 0;
                        result++;
                    }
                }
            }
        }
        return result;
    }
}
