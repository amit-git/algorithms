package org.skyblue.algorithms;

import static org.junit.Assert.*;

import org.junit.Test;

public class PasswordGenTest {

    @Test
    public void generateEightCharPasswd() {
        PasswordGenerator passGen = new PasswordGenerator();
        final String passWd = passGen.generate(8);
        assertTrue(passWd != null && !passWd.isEmpty());
        assertEquals(8, passWd.length());
        System.out.println("Generated passwd " + passWd);
    }

}
