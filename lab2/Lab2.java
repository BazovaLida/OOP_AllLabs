import java.util.Random;

public class LabTwo {
    private static void printmatrix(short[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            } System.out.println(" ");
        }
    } public static void main(String[] args) {
        Random rand = new Random();
        int numofstr, numofcolumn;

        //You can change:
        numofcolumn = 4;
        numofstr = 3;
        short min = -10, max = 70; // от -32768 до 32767

        short[][] B = new short[numofstr][numofcolumn];
        short[][] C = new short[numofcolumn][numofstr];

        short small, big;
        int sumofbig = 0, sumofsmall = 0;

        for (int i = 0; i < numofstr; i++) {
            for (int j = 0; j < numofcolumn; j++) {
                B[i][j] = (short) (rand.nextInt((max - min)) + min);
                C[j][i] = B[i][j];
            }
        } for (int i = 0; i < numofcolumn; i++) {
            small = max;
            big = min;
            for (int j = 0; j < numofstr; j++) {
                if (C[i][j] > big && i % 2 == 0) {
                    big = C[i][j];
                } if (C[i][j] < small && i % 2 == 1) {
                    small = C[i][j];
                }
            } if (i % 2 == 0){
                sumofbig += big;
            } if (i % 2 == 1){
                sumofsmall += small;
            }
        } System.out.println("Matrix B:");
        printmatrix(B);
        System.out.println("Matrix C:");
        printmatrix(C);
        System.out.println("The sum of the largest elements in the rows of the matrix with odd numbers: "+sumofbig);
        System.out.println("The sum of the smallest elements in the rows of the matrix with even numbers: "+sumofsmall);
        System.out.println("Done!");
    }
}
