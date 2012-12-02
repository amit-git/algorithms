package org.skyblue.algorithms;

import static org.junit.Assert.*;

import org.junit.Test;

public class LCSTest {

    @Test
    public void simpleCase2() {
        final String a = "AGCAT";
        final String b = "GAC";

        final String result = LCS.findLongest(a, b);
        System.out.println("result = " + result);
        assertEquals(2, result.length());
    }

    @Test
    public void simpleCase4() {
        final String a = "XMJYAUZ";
        final String b = "MZJAWXU";

        final String result = LCS.findLongest(a, b);
        System.out.println("result = " + result);
        assertEquals(4, result.length());
    }

}
