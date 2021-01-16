

import java.util.Scanner;

public class Sangfor_2019Spring_04 {

    private static int total ;


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while(scanner.hasNext()){
            int N = scanner.nextInt();
            int[] cuboid = new int[3];
            cuboid[0] = scanner.nextInt();cuboid[1] = scanner.nextInt();cuboid[2] = scanner.nextInt();
            total = 0;
            dfs(cuboid,N);
            System.out.println(total);
        }

    }

    public static void dfs(int[] cuboid,int height ){

        if(height < 0){
            return;
        }
        if(height == 0){
            total += 1;
        }

        dfs(cuboid,height - cuboid[0]);
        dfs(cuboid,height - cuboid[1]);
        dfs(cuboid,height - cuboid[2]);

    }


}
