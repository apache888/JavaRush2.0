package com.javarush.task.task40.task4006;

import java.io.*;
import java.net.Socket;
import java.net.URL;

/*
Отправка GET-запроса через сокет
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        getSite(new URL("http://javarush.ru/social.html"));
    }

    public static void getSite(URL url){
        String host = url.getHost();
        String request = url.getFile();
        try (Socket socket = new Socket(host, 80);
                PrintStream writer = new PrintStream(socket.getOutputStream());
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()))){
            writer.print("GET " + /*"/" +*/ request + /*" HTTP/1.1" +*/ "\r\n");
//            writer.print("Host: " + host + "\r\n");
//            writer.print("Connection: close\r\n");
            writer.print("\r\n");
            writer.flush();

            String responseLine;
            while ((responseLine = bufferedReader.readLine()) != null) {
                System.out.println(responseLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}