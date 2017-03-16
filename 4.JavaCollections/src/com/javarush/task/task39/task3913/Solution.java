package com.javarush.task.task39.task3913;

import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Solution {
    public static void main(String[] args) {
        LogParser logParser = new LogParser(Paths.get("G:\\IdeaProjects\\JavaRushTasks\\4.JavaCollections\\src\\com\\javarush\\task\\task39\\task3913\\logs"));
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        String afterString = "13.09.2015 5:04:50";
        String beforeString = "13.09.2072 05:04:50";
        try {
            Date after = simpleDateFormat.parse(afterString);
            Date before = null;
            System.out.println(logParser.getNumberOfUniqueIPs(after, before));
            System.out.println(logParser.getIPsForUser("Vasya Pupkin", after, before));
            System.out.println(logParser.getIPsForEvent(Event.DONE_TASK, after, before));
            System.out.println(logParser.getIPsForStatus(Status.OK, after, before));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}