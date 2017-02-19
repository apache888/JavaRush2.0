package com.javarush.task.task36.task3612;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/* 
Почему сет не содержит элемент?
*/

public class Solution {
    private Set<Date> dates;
    private Date lastDate;

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.initializeDates();
        solution.updateLastDate(3_600_000L);
        System.out.println(solution.isLastDateContainsInDates());
    }

    public boolean isLastDateContainsInDates() {
        return dates.contains(lastDate);
    }

    private void initializeDates() {
        dates = new HashSet<>();
        lastDate = new Date(4738615447000L);
        dates.add(lastDate);
        dates.add(new Date(1346328493000L));
        dates.add(new Date(1476842647000L));
        dates.add(new Date(1568340290000L));
        dates.add(new Date(2435709847000L));
    }

    protected void updateLastDate(long delta) {
        dates.remove(lastDate);
        lastDate.setTime(lastDate.getTime() + delta);
        dates.add(lastDate);

    }
}