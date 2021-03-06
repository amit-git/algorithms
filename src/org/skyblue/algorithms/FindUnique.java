package org.skyblue.algorithms;

public class FindUnique {

	public int unique(int [] input) {
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
        return i;
	}
}
