

import java.util.Scanner;

public class HJ83 {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while(sc.hasNext()){

            // 1 Init
            String[] str01 = sc.nextLine().split(" ");
            int rows = Integer.parseInt(str01[0]);
            int cols = Integer.parseInt(str01[1]);

            if(rows < 0 || rows > 9 || cols < 0 || cols > 9){
                System.out.println(-1);
            }else {
                System.out.println(0);
            }

            // 2 要交换的两个单元格的行列值
            String[] str02 = sc.nextLine().split(" ");
            int x1 = Integer.parseInt(str02[0]);
            int y1 = Integer.parseInt(str02[1]);
            int x2 = Integer.parseInt(str02[2]);
            int y2 = Integer.parseInt(str02[3]);

            if(x1 >= rows || x1 < 0 || y1 >= cols || y1 < 0 || x2 >= rows || x2 < 0 || y2 >= cols || y2 < 0){
                System.out.println(-1);
            }else {
                System.out.println(0);
            }

            //  3 输入要插入的行的数值
            int insertX = Integer.parseInt(sc.nextLine());

            if(insertX < 0 || insertX >= rows || rows == 9){
                System.out.println(-1);
            }else {
//                rows ++;
                System.out.println(0);
            }

            // 4 输入要插入的列的数值
            int insertY = Integer.parseInt(sc.nextLine());

            if(insertY < 0 || insertY >= cols || cols == 9){
                System.out.println(-1);
            }else {
//                cols ++;
                System.out.println(0);
            }

            // 输入要查询的单元格的坐标
            String[] str05 = sc.nextLine().split(" ");

            int findX = Integer.parseInt(str05[0]);
            int findY = Integer.parseInt(str05[1]);

            if(findX < 0 || findX >= rows || findY < 0 || findY >= cols){
                System.out.println(-1);
            }else {
                System.out.println(0);
            }




        }


    }


}
