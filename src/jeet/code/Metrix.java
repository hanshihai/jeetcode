package jeet.code;

public class Metrix {

    private int[][] matrix;

    public Metrix(int n, int m) {
        matrix = new int[n][m];
        init();
    }

    private void init() {
        for (int i = 0; i< matrix.length; i++) {
            for(int j = 0; j< matrix[i].length; j++) {
                matrix[i][j] = i * matrix[i].length + j;
            }
        }
     }

     public void print() {
        for (int i = 0; i< matrix.length; i++) {
            for (int j = 0; j< matrix[i].length; j++) {
                if (matrix[i][j] < 10) {
                    System.out.print("0"+ matrix[i][j] + " ");
                }else{
                    System.out.print(matrix[i][j] + " ");
                }
            }
            System.out.println();
        }
     }

     private void evert() {
         for (int i = 0; i< matrix.length; i++) {
             for(int j = i; j< matrix[i].length; j++) {
                 int temp = matrix[j][i];
                 matrix[j][i] = matrix[i][j];
                 matrix[i][j] = temp;
             }
         }
     }

    private void rotate() {
        if (null == matrix || matrix.length < 2) {
            return;
        }
        int n = matrix.length;
        for (int i = 0; i< matrix.length / 2; i++) {
            for(int j = i; j< matrix[i].length-i-1; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n-j-1][i];
                matrix[n-j-1][i] = matrix[n-i-1][n-j-1];
                matrix[n-i-1][n-j-1] = matrix[j][n-i-1];
                matrix[j][n-i-1] = temp;
            }
        }
    }

     public static void main(String[] args) {
        Metrix metrix = new Metrix(2,2);
        metrix.print();
        System.out.println(" ------------ rocate ------------");
        metrix.rotate();
        metrix.print();
     }
}
