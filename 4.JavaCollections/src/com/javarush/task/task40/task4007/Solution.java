package com.javarush.task.task40.task4007;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* 
Работа с датами
*/
public class Solution {
    public static void main(String[] args) {
        printDate("21.4.2014 15:56:45");
        System.out.println();
        printDate("21.4.2014");
        System.out.println();
        printDate("17:33:40");
    }

    public static void printDate(String date) {
        //напишите тут ваш код
        Calendar calendar = Calendar.getInstance();
        Pattern pattern1 = Pattern.compile("(\\d{1,2}).(\\d{1,2}).(\\d{4})\\s(\\d{1,2}):(\\d{1,2}):(\\d{1,2})");
        Matcher case1 = pattern1.matcher(date);
        Pattern pattern2 = Pattern.compile("(\\d{1,2}).(\\d{1,2}).(\\d{4})");
        Matcher case2 = pattern2.matcher(date);
        Pattern pattern3 = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})");
        Matcher case3 = pattern3.matcher(date);
        if (case1.find()) {
            SimpleDateFormat format = new SimpleDateFormat("d.M.yyyy H:m:s");
            try {
                calendar.setTime(format.parse(date));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            System.out.println("День: " + calendar.get(Calendar.DAY_OF_MONTH));
            System.out.println("День недели: " + ((calendar.get(Calendar.DAY_OF_WEEK) - 1) == 0 ? 7 : calendar.get(Calendar.DAY_OF_WEEK) - 1));
            System.out.println("День месяца: " + calendar.get(Calendar.DAY_OF_MONTH));
            System.out.println("День года: " + calendar.get(Calendar.DAY_OF_YEAR));
            System.out.println("Неделя месяца: " + calendar.get(Calendar.WEEK_OF_MONTH));
            System.out.println("Неделя года: " + calendar.get(Calendar.WEEK_OF_YEAR));
            System.out.println("Месяц: " + (calendar.get(Calendar.MONTH) + 1));
            System.out.println("Год: " + calendar.get(Calendar.YEAR));
            System.out.println("AM или PM: " + (calendar.get(Calendar.HOUR_OF_DAY) > 12 ? "PM" : "AM"));
            System.out.println("Часы: " + calendar.get(Calendar.HOUR));
            System.out.println("Часы дня: " + calendar.get(Calendar.HOUR_OF_DAY));
            System.out.println("Минуты: " + calendar.get(Calendar.MINUTE));
            System.out.println("Секунды: " + calendar.get(Calendar.SECOND));
            return;
        }
        if (case2.find()) {
            SimpleDateFormat format = new SimpleDateFormat("d.M.yyyy");
            try {
                calendar.setTime(format.parse(date));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            System.out.println("День: " + calendar.get(Calendar.DAY_OF_MONTH));
            System.out.println("День недели: " + ((calendar.get(Calendar.DAY_OF_WEEK) - 1) == 0 ? 7 : calendar.get(Calendar.DAY_OF_WEEK) - 1));
            System.out.println("День месяца: " + calendar.get(Calendar.DAY_OF_MONTH));
            System.out.println("День года: " + calendar.get(Calendar.DAY_OF_YEAR));
            System.out.println("Неделя месяца: " + calendar.get(Calendar.WEEK_OF_MONTH));
            System.out.println("Неделя года: " + calendar.get(Calendar.WEEK_OF_YEAR));
            System.out.println("Месяц: " + (calendar.get(Calendar.MONTH) + 1));
            System.out.println("Год: " + calendar.get(Calendar.YEAR));
            return;
        }
        if (case3.find()) {
            SimpleDateFormat format = new SimpleDateFormat("H:m:s");
            try {
                calendar.setTime(format.parse(date));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            System.out.println("AM или PM: " + (calendar.get(Calendar.HOUR_OF_DAY) > 12 ? "PM" : "AM"));
            System.out.println("Часы: " + calendar.get(Calendar.HOUR));
            System.out.println("Часы дня: " + calendar.get(Calendar.HOUR_OF_DAY));
            System.out.println("Минуты: " + calendar.get(Calendar.MINUTE));
            System.out.println("Секунды: " + calendar.get(Calendar.SECOND));
            return;
        }
    }
}
