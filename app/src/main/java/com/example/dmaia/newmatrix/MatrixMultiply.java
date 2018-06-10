package com.example.dmaia.newmatrix;
class MatrixMultiply{

    public void multiply(int[][] matrix1, int[][] matrix2)  {
        int x = matrix1.length;
        int y = x;
        int result[][] = new int[matrix1.length][matrix1.length];

        for(int i = 0; i < x; i++) {
            for(int j = 0; j < y-1; j++) {
                for(int k = 0; k < y; k++){

                    result[i][j] += matrix1[i][k]*matrix2[k][j];
                }
            }
        }
    }
}
