package com.example.dmaia.newmatrix;
class MatrixMultiply{

    int matrix1[][];
    int matrix2[][];
    int result[][] = new int[64][64];

    public MatrixMultiply(int[][] op1, int[][] op2) {
        matrix1 = op1;
        matrix2 = op2;
    }

    public void multiply()  {
        int x = matrix1.length;
        int y = x;

        for(int i = 0; i < x; i++) {
            for(int j = 0; j < y-1; j++) {
                for(int k = 0; k < y; k++){

                    result[i][j] += matrix1[i][k]*matrix2[k][j];
                }
            }
        }
    }

    public int[][] getResult() {
        return result;
    }
}
