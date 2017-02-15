package com.javarush.task.task36.task3601;

import java.util.ArrayList;
import java.util.List;

/* 
MVC - простая версия
*/
public class Solution {
    public static void main(String[] args) {
        new View().fireEventShowData();
    }

//    public void fireEventShowData() {
//        System.out.println(onDataListShow());
//    }
//    public List<String> onDataListShow() {
//        return getStringDataList();
//    }
//    public List<String> getStringDataList() {
//        return getData();
//    }
//    public List<String> getData() {
//        List<String> data = new ArrayList<String>() {{
//            add("First string");
//            add("Second string");
//            add("Third string");
//        }};
//        return data;
//    }

}
