package org.skyblue.algorithms;

import java.util.Random;

public class PasswordGenerator {

    public static class CharSet {

        private char[] chars;
        private int totalChars;

        private final Random rand = new Random();

        public CharSet() {
            final short upperA = 'A';
            final short upperZ = 'Z';
            final short lowerA = 'a';
            final short lowerZ = 'z';

            totalChars = (upperZ - upperA + 1) + (lowerZ - lowerA + 1);
            chars = new char[totalChars];

            int ai = 0; // array index
            for (int i = upperA; i <= upperZ; i++) {
                chars[ai++] = (char) i;
            }

            for (int i = lowerA; i <= lowerZ; i++) {
                chars[ai++] = (char) i;
            }
        }

        public char getRandomChar() {
            final int randIndex = rand.nextInt(totalChars);
            return chars[randIndex];
        }
    }

    public String generate(int len) {
        CharSet charSet = new CharSet();
        final char[] chars = new char[len];
        for (int i = 0; i < len; i++) {
            chars[i] = charSet.getRandomChar();
        }

        return new String(chars);
    }

}
