package com.javarush.task.task40.task4009;

import java.time.LocalDate;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;

/* 
Buon Compleanno!
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(weekDayOfBirthday("30.05.1984", "2015"));
        System.out.println(weekDayOfBirthday("1.12.2015", "2016"));
    }

    public static String weekDayOfBirthday(String birthday, String year) {
        //напишите тут ваш код
        LocalDate localDate = LocalDate.parse(birthday, DateTimeFormatter.ofPattern("d.M.yyyy", Locale.ITALIAN));
        //option 3
        localDate = localDate.withYear(Year.parse(year).getValue());
        return localDate.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.ITALIAN);

        //option 1
//        int adYears = Integer.parseInt(year) - localDate.getYear();
//        LocalDate newDate = localDate.plusYears(adYears);
//        return DateTimeFormatter.ofPattern("EEEE").withLocale(Locale.ITALIAN).format(newDate);
        //option 2
//        int day = localDate.getDayOfMonth();
//        int month = localDate.getMonthValue();
//        LocalDate currentDate = LocalDate.of(Integer.parseInt(year), month, day);
//        return DateTimeFormatter.ofPattern("EEEE", Locale.ITALIAN).format(currentDate);
    }
}
