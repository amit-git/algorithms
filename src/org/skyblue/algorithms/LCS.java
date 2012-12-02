package org.skyblue.algorithms;

public class LCS {

    /**
     * Find longest common substring from the two input strings
     * 
     * @param left
     *            input string
     * @param right
     *            input string
     * @return Longest common substring
     */
    public static String findLongest(String left, String right) {
        return longest(left, left.length() - 1, right, right.length() - 1);
    }

    private static String longest(String left, int i, String right, int j) {
        if (i < 0 || j < 0) {
            return "";
        }

        char chLeft = left.charAt(i);
        char chRight = right.charAt(j);

        if (chLeft == chRight) {
            return longest(left, i - 1, right, j - 1) + chLeft;
        } else {
            final String longestOne = longest(left, i - 1, right, j);
            final String longestTwo = longest(left, i, right, j - 1);
            if (longestOne.length() > longestTwo.length()) {
                return longestOne;
            } else {
                return longestTwo;
            }
        }
    }

}
