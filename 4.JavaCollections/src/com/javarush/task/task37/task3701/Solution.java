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
        //noinspection unchecked
        return new RoundIterator();
    }

//    public class RoundIterator<T> implements Iterator<T> {
//        int cursor;       // index of next element to return
//        int lastRet = -1; // index of last element returned; -1 if no such
//        int expectedModCount = modCount;
//
//        @Override
//        public boolean hasNext() {
////            return cursor != size();
//            return true;
//        }
//
//        @Override
//        public T next() {
//            checkForComodification();
//
//            if (cursor >= size()){
////                throw new NoSuchElementException();
//                cursor = 0;
//            }
//            int i = cursor;
////            T[] elementData = super.elementData;
//            T next = (T) Solution.this.get(i);
////            if (i >= elementData.length)
////                throw new ConcurrentModificationException();
//            lastRet = i;
//            cursor = i + 1;
//            return next;
//        }
//
//        @Override
//        public void remove() {
//            if (lastRet < 0)
//                throw new IllegalStateException();
//            checkForComodification();
//            try {
//                Solution.this.remove(lastRet);
//                cursor = lastRet;
//                lastRet = -1;
//                expectedModCount = modCount;
//            } catch (IndexOutOfBoundsException ex) {
//                throw new ConcurrentModificationException();
//            }
//        }
//
//        final void checkForComodification() {
//            if (modCount != expectedModCount)
//                throw new ConcurrentModificationException();
//        }
//    }
    //решение с подсказки
public class RoundIterator implements Iterator<T> {
    private Iterator<T> iterator;

    public RoundIterator()
    {
        this.iterator = Solution.super.iterator();
    }

    @Override
    public boolean hasNext()
    {
        return Solution.this.size() > 0;
    }

    @Override
    public T next()
    {
        if (!iterator.hasNext()) iterator = Solution.super.iterator();
        return iterator.next();
    }

    @Override
    public void remove()
    {
        iterator.remove();
    }
}
}
