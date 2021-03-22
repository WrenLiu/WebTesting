import java.util.Arrays;
import java.util.Scanner;

public class HJ69 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while(sc.hasNext()){

//            int x = Integer.parseInt(sc.nextLine());
//            int y = Integer.parseInt(sc.nextLine());
//            int z = Integer.parseInt(sc.nextLine());

            int x = sc.nextInt();
            int y = sc.nextInt();
            int z = sc.nextInt();
            sc.nextLine();



            int[][] matrixA = new int[x][y];
            int[][] matrixB = new int[y][z];

            for (int i = 0; i < x; i++) {
                String[] strings = sc.nextLine().split(" ");

                for (int j = 0; j < y; j++) {
                    matrixA[i][j] = Integer.parseInt(strings[j]);
                }
            }

            for (int i = 0; i < y; i++) {
                String[] strings = sc.nextLine().split(" ");

                for (int j = 0; j < z; j++) {

                    matrixB[i][j] = Integer.parseInt(strings[j]);
                }
            }

            int[][] res = new int[x][z];


            for (int i = 0; i < x; i++) {
                for (int  j = 0;  j < z;  j++) {
                    res[i][j] = 0;
                    for (int k = 0; k < y; k++) {
                        res[i][j] += matrixA[i][k] * matrixB[k][j];
                    }

                }
            }

            for (int[] re : res) {
                for (int i : re) {
                    System.out.print(i+" ");
                }
                System.out.println();
            }


        }

    }




}
