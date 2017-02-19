package com.javarush.task.task37.task3701;

import java.util.*;

/* 
Круговой итератор
*/
public class Solution<T> extends ArrayList<T> {
    public static void main(String[] args) {
        Solution<Integer> list = new Solution<>();
        list.add(1);
        list.add(2);
        list.add(3);

        int count = 0;
        for (Integer i : list) {
            //1 2 3 1 2 3 1 2 3 1
            System.out.print(i + " ");
            count++;
            if (count == 10) {
                break;
            }
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new RoundIterator();
    }

    public class RoundIterator<T> implements Iterator<T> {
        int cursor;       // index of next element to return
//        int lastRet = -1; // index of last element returned; -1 if no such

        @Override
        public boolean hasNext() {
//            return cursor != size();
            return true;
        }

        @Override
        public T next() {

            if (cursor >= size()){
//                throw new NoSuchElementException();
                cursor = 0;
            }
            int i = cursor;
//            T[] elementData = super.elementData;
            T next = (T) get(i);
//            if (i >= elementData.length)
//                throw new ConcurrentModificationException();
            cursor = i + 1;
            return next;
        }
    }
}
