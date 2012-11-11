package org.skyblue.algorithms;

import static org.junit.Assert.*;

import org.junit.Test;

public class FineUniqueTest {

    @Test
    public void sampleTest() {
        FindUnique fu = new FindUnique();
        int[] input = { 1, 1, 1, 1, 2, 2, 3, 3, 3, 3, 4, 4, 4, 5, 5 };
        int k = fu.unique(input);
        assertTrue(k == 4);
    }
}
