

import java.util.Scanner;

public class HJ91 {

    private static int res ;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while(sc.hasNext()){

            int rows = sc.nextInt();
            int cols = sc.nextInt();

            System.out.println(rows+" "+cols);


            int re = helper( 0,0,rows,cols);

            System.out.println(re);



        }


    }

    private static int helper(int curRow , int curCol , int rows , int cols){

        if(curRow == rows && curCol == cols){

            return 1;
        }

        if(curRow > rows || curCol > cols){
            return 0;
        }

        return helper(curRow + 1, curCol ,rows,cols) +   helper(curRow ,curCol +1 ,rows,cols);


    }


}
