package org.skyblue.algorithms;

import java.util.ArrayList;
import java.util.List;

public class mergeSort<T extends Comparable<T>> {

    public List<T> sort(List<T> input, int begin, int end) {
        if (end == begin) {
            List<T> result = new ArrayList<T>();
            result.add(input.get(begin));
            return result;
        }

        final int middle = (begin + end) / 2;
        List<T> firstHalf = sort(input, begin, middle);
        List<T> secondHalf = sort(input, middle + 1, end);
        return mergeLists(firstHalf, secondHalf);
    }

    public List<T> mergeLists(List<T> listA, List<T> listB) {
        final int aLen = listA.size();
        final int bLen = listB.size();
        final List<T> rlist = new ArrayList<T>();
        int i = 0;
        int j = 0;
        while (i < aLen && j < bLen) {
            if (listA.get(i).compareTo(listB.get(j)) < 0) {
                rlist.add(listA.get(i++));
            } else {
                rlist.add(listB.get(j++));
            }
        }

        while (i < aLen) {
            rlist.add(listA.get(i++));
        }
        while (j < bLen) {
            rlist.add(listB.get(j++));
        }
        return rlist;
    }

    public static void main(String[] args) {
        List<Integer> listA = new ArrayList<Integer>();
        listA.add(3);
        listA.add(4);
        listA.add(8);
        listA.add(9);
        listA.add(100);

        List<Integer> listB = new ArrayList<Integer>();
        listB.add(2);
        listB.add(6);
        listB.add(9);
        listB.add(10);
        listB.add(19);

        mergeSort<Integer> msort = new mergeSort<Integer>();
        List<Integer> rlist = msort.mergeLists(listA, listB);
        System.out.println("Result list - " + rlist);

        List<Integer> listC = new ArrayList<Integer>();
        listC.add(12);
        listC.add(986);
        listC.add(1);
        listC.add(123);
        listC.add(45);
        listC.add(9734);
        listC.add(100);

        List<Integer> result = msort.sort(listC, 0, listC.size() - 1);
        System.out.println("Sort Result - " + result);

        List<String> listD = new ArrayList<String>();
        listD.add("vyom");
        listD.add("manali");
        listD.add("mandar");
        listD.add("amit");
        listD.add("bhalchandra");

        mergeSort<String> msortB = new mergeSort<String>();
        List<String> resultB = msortB.sort(listD, 0, listD.size() - 1);
        System.out.println("String Sort Result - " + resultB);
    }

}
