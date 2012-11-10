package org.skyblue.algorithms;

public class binarySearch {

    public static boolean find(int term, int [] list, int rbegin, int rend) {
        if (rbegin == rend) {
            return list[rbegin] == term;
        }
        
        int middle = ( rbegin + rend ) / 2;
        if (list[middle] == term) {
            return true;
        }
        return find(term, list, rbegin, middle) || find (term, list, middle+1, rend);

    }

    public static void main (String [] args)
    {
        final String termStr = args[0];
        if (termStr == null || termStr.isEmpty()) {
            throw new RuntimeException("No search Term found");
        }

        final int term = Integer.parseInt(termStr);

        int [] list = { 2, 5, 8, 19, 110, 135, 150, 200 };

        System.out.println("Finding term using binarySearch");
        
        if (find(term, list, 0, list.length - 1)) {
            System.out.println("Found");
        } else {
            System.out.println("Not Found");
        }
    }
}
