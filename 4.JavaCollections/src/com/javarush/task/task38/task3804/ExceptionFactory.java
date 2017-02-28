package com.javarush.task.task38.task3804;

public class ExceptionFactory {

    public static Throwable createException(Enum argument) throws Exception {
        if (argument != null) {
            String message = argument.toString();
            message = message.substring(0, 1) + message.substring(1).replaceAll("_", " ").toLowerCase();
            if (argument instanceof ExceptionApplicationMessage) {

                return new Exception(message);
            } else if (argument instanceof ExceptionDBMessage) {
                return new RuntimeException(message);
            } else if (argument instanceof ExceptionUserMessage) {
                return new Error(message);
            }
        }
        return new IllegalArgumentException();
    }
}
