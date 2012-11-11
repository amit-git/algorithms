package org.skyblue.algorithms;

public class Matrix {
    private int [][] data;
    private int rows;
    private int cols;

    public Matrix(int [][] data) {
        this.data = data;
        rows = data.length;
        cols = data[0].length;
    }

    public Matrix multiply(Matrix other) {
        if (cols != other.rows) {
            throw new IllegalArgumentException("Invalid Matrix for multiplication operation");
        }

        int [][] result = new int[rows][other.cols];
        for (int i=0; i < rows; i++) {
            for (int j=0; j < other.cols; j++) {
                result[i][j] = 0;
                for (int k = 0; k < other.rows; k++) {
                    result[i][j] += data[i][k] * other.data[k][j];
                }
            }
        }
        return new Matrix(result);
    }

    public Matrix transpose() { 
        int [][] result = new int[cols][rows];
        for (int i=0; i < cols; i++) {
            for (int j=0; j < rows; j++) {
                result[i][j] = data[j][i];
            }
        }

        return new Matrix(result);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("--- Matrix ---\n");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                sb.append(String.format("%d ",data[i][j]));
            }
            sb.append("\n");
        }

        return sb.toString();
    }


    public static void main (String [] args) { 
        int [][] data = { { 3, 3, 3 }, 
                          {4, 4, 4 },
                          {5, 5, 5} };
        
        Matrix m = new Matrix(data);
        System.out.println("Matrix 1 :");
        System.out.println(m);

        int [][] data2 = { { 3, 3, 3 }, 
                          {4, 4, 4 },
                          {5, 5, 5} };
        Matrix m2 = new Matrix(data2);
        System.out.println("Matrix 2 :");
        System.out.println(m2);

        System.out.println("Multiplication result :");
        System.out.println(m.multiply(m2));

        System.out.println("Transpose :");
        System.out.println(m.transpose());
    }
        
}
