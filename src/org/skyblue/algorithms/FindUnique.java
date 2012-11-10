package org.skyblue.algorithms;

public class FindUnique {

    public static void main (String [] args)
    {
        int [] input = { 1,1,1,1,2,2,3,3,3,3,4,4,4,5,5 };

        int i = 0;
        int j = 0;

        while(j < input.length) {
            
            while(j < input.length && input[i] == input[j]) {
                j++;
            }
            if (j < input.length) {
                input[++i] = input[j];
            }
        }
        System.out.println("Unique array");
        for (int k = 0; k <= i; k++) {
            System.out.print(input[k] + ",");
        }
    }
    
}
