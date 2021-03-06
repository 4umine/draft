package com.somelogs.javase;

import org.junit.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Iterator#remove()
 * Created by liubingguang on 2017/6/14.
 */
public class IteratorRemove {

    /**
     * Arrays.asList#remove()
     * UnsupportedOperationException
     */
    @Test
    public void test() {
        List<Integer> numList = Arrays.asList(1, 2, 3, 4);
        for (Integer num : numList) {
            if (num.equals(3)) {
                numList.remove(num);
            }
            //System.out.println(num);
        }
    }

    /**
     * ConcurrentModificationException
     */
    @Test
    public void test2() {
        List<Integer> numList = new ArrayList<Integer>();
        for (int i = 0; i < 4; i++) {
            numList.add(i);
        }
        for (Integer num : numList) {
            if (num.equals(3)) {
                numList.remove(num);
            }
        }
    }

    /**
     * OK
     */
    @Test
    public void test3() throws Exception {
        List<Integer> numList = new ArrayList<Integer>();
        for (int i = 0; i < 1000000; i++) {
            numList.add(i);
        }
        System.out.println(numList);

        long startTime = System.currentTimeMillis();
        Iterator<Integer> iterator = numList.iterator();
        while (iterator.hasNext()) {
            Integer num = iterator.next();
            if (num.equals(2000) || num.equals(500000)) {
                iterator.remove();
                System.out.println(num);
            }
        }
        System.out.println("total time:" + (System.currentTimeMillis() - startTime));
    }

    @Test
    public void test4() throws Exception {
        List<Integer> numList = new ArrayList<Integer>();
        for (int i = 0; i < 1000000; i++) {
            numList.add(i);
        }
        System.out.println(numList);

        long startTime = System.currentTimeMillis();
        Iterator<Integer> iterator = numList.iterator();
        while (iterator.hasNext()) {
            Integer num = iterator.next();
            if (num.equals(2000) || num.equals(500000)) {
                System.out.println(num);
            }
        }
        System.out.println("total time:" + (System.currentTimeMillis() - startTime));
    }

    @Test
    public void test5() throws Exception {
        String[] strings = new String[]{"a", "b", "c"};
        int index = 2;
        int cursor;
        System.out.println(strings[cursor = index]);
        System.out.println(cursor);
    }

    @Test
    public void systemTimeTest() throws Exception {
        int hour = 60 * 60 * 1000;
        System.out.println(System.currentTimeMillis() / hour);
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH");
        Date date = format.parse("2018-08-09 09");
        System.out.println(date.getTime() / hour);
        System.out.println(new Date());
    }
}
