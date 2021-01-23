

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class HJ43 {

    static class myPoint{

        int x,y;
        myPoint(int x,int y){
            this.x = x;
            this.y = y;
        }
    }

    public static Stack<myPoint> stack;
    public static int rows , cols;
    public static int[][] grid;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while(sc.hasNext()){

            rows = sc.nextInt();
            cols = sc.nextInt();
            grid = new int[rows][cols];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            stack = new Stack<>();


            helper(0,0);




        }



    }

    private static void helper(int row, int col){

        myPoint point = new myPoint(row,col);
        stack.push(point);

        if(row == rows-1 && col == cols-1){
            for (myPoint myPoint : stack) {
                System.out.println("("+myPoint.x+","+myPoint.y+")");
            }
        }

        if(row+1 >= 0 && col >= 0 && col < cols && row+1 < rows && grid[row+1][col] == 0 ){
            helper(row+1,col);
        }

        if(col+1 >= 0 && row >= 0 && col+1 < cols && row < rows && grid[row][col+1] == 0){
            helper(row,col+1);
        }

        stack.pop();













    }


}
