package com.javarush.task.task36.task3605;

import java.io.*;
import java.util.TreeSet;

/* 
Использование TreeSet
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        TreeSet<String> set = new TreeSet<>();
        StringWriter stringWriter = new StringWriter();
//        BufferedWriter writer = new BufferedWriter(stringWriter);
        while (reader.ready()) {
            stringWriter.write(reader.readLine());
        }
        String data = stringWriter.toString();
        data = data.replaceAll("[\\p{Punct}, \\p{Space}]", "");
        data = data.toLowerCase();
//        System.out.println(data);
        char[] chars = data.toCharArray();
        StringBuilder builder = new StringBuilder();
        for (char ch : chars) {
            set.add(String.valueOf(ch));
        }
        if (set.size() < 5) {
            for (String str: set) {
                builder.append(str);
            }
            System.out.println(builder);
        } else {
            for (int i = 0; i < 5; i++) {
                builder.append(set.pollFirst());
            }
            System.out.println(builder);
        }

    }
}
