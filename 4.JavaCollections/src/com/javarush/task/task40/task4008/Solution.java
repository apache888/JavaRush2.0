package com.javarush.task.task40.task4008;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.WeekFields;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Работа с Java 8 DateTime API
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
        Pattern pattern1 = Pattern.compile("(\\d{1,2}).(\\d{1,2}).(\\d{4})\\s(\\d{1,2}):(\\d{1,2}):(\\d{1,2})");
        Matcher case1 = pattern1.matcher(date);
        Pattern pattern2 = Pattern.compile("(\\d{1,2}).(\\d{1,2}).(\\d{4})");
        Matcher case2 = pattern2.matcher(date);
        Pattern pattern3 = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})");
        Matcher case3 = pattern3.matcher(date);
        if (case1.find()) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.M.yyyy H:m:s");
            LocalDate localDate = LocalDate.parse(date, formatter);
            LocalTime localTime = LocalTime.parse(date, formatter);
            System.out.println("День: " + localDate.getDayOfMonth());
            System.out.println("День недели: " + (localDate.getDayOfWeek().getValue()));
            System.out.println("День месяца: " + localDate.getDayOfMonth());
            System.out.println("День года: " + localDate.getDayOfYear());
            System.out.println("Неделя месяца: " + localDate.get(WeekFields.of(Locale.getDefault()).weekOfMonth()));
            System.out.println("Неделя года: " + localDate.get(WeekFields.of(Locale.getDefault()).weekOfYear()));
            System.out.println("Месяц: " + localDate.getMonth().getValue());
            System.out.println("Год: " + localDate.getYear());
            System.out.println("AM или PM: " + (localTime.get(ChronoField.AMPM_OF_DAY) == 1 ? "PM" : "AM"));
            System.out.println("Часы: " + localTime.get(ChronoField.CLOCK_HOUR_OF_AMPM));
            System.out.println("Часы дня: " + localTime.get(ChronoField.HOUR_OF_DAY));
            System.out.println("Минуты: " + localTime.get(ChronoField.MINUTE_OF_HOUR));
            System.out.println("Секунды: " + localTime.get(ChronoField.SECOND_OF_MINUTE));
            return;
        }
        if (case2.find()) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.M.yyyy");
            LocalDate localDate = LocalDate.parse(date, formatter);
            System.out.println("День: " + localDate.getDayOfMonth());
            System.out.println("День недели: " + (localDate.getDayOfWeek().getValue()));
            System.out.println("День месяца: " + localDate.getDayOfMonth());
            System.out.println("День года: " + localDate.getDayOfYear());
            System.out.println("Неделя месяца: " + localDate.get(WeekFields.of(Locale.getDefault()).weekOfMonth()));
            System.out.println("Неделя года: " + localDate.get(WeekFields.of(Locale.getDefault()).weekOfYear()));
            System.out.println("Месяц: " + localDate.getMonth().getValue());
            System.out.println("Год: " + localDate.getYear());
            return;
        }
        if (case3.find()) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("H:m:s");
            LocalTime localTime = LocalTime.parse(date, formatter);
            System.out.println("AM или PM: " + (localTime.get(ChronoField.AMPM_OF_DAY) == 1 ? "PM" : "AM"));
            System.out.println("Часы: " + localTime.get(ChronoField.CLOCK_HOUR_OF_AMPM));
            System.out.println("Часы дня: " + localTime.getHour());
            System.out.println("Минуты: " + localTime.getMinute());
            System.out.println("Секунды: " + localTime.getSecond());
            return;
        }
    }
}
