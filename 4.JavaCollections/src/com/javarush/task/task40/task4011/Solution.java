package com.javarush.task.task40.task4011;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/* 
Свойства URL
*/

public class Solution {
    public static void main(String[] args) throws IOException {
//        decodeURLString("www.amrood.com/index.htm/language=en/j2se");
        decodeURLString("https://www.amrood.com/index.htm?language=en#j2se");
    }

    public static void decodeURLString(String s) /*throws MalformedURLException*/ {
        try {
            URL url = new URL(s);
            System.out.println("-protocol " + url.getProtocol());
            System.out.println("-authority " + url.getAuthority());
            System.out.println("-file " + url.getFile());
            System.out.println("-host " + url.getHost());
            System.out.println("-path " + url.getPath());
            System.out.println("-port " + url.getPort());
            System.out.println("-default port " + url.getDefaultPort());
            System.out.println("-query " + url.getQuery());
            System.out.println("-ref " + url.getRef());
        } catch (MalformedURLException e) {
            System.out.println(String.format("Parameter %s is not a valid URL", s));
        }

    }
}

