package com.javarush.task.task38.task3810;

public @interface Revision {
    //напиши свой код
    int revision();
    Date date();
    String comment() default "";
    Author[] authors() default {};

}
