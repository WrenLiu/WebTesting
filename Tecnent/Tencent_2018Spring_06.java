

import java.util.Scanner;

public class Tencent_2018Spring_06 {



    private static void dfs_B(int x,int y,char[][] draw){

        while (x < draw.length && x >= 0 && y >= 0 && y < draw[0].length){

            if(draw[x][y] == 'B'){
                draw[x][y] = 'X';
                x += 1;
                y -= 1;
            }else if(draw[x][y] == 'G'){
                draw[x][y] = 'Y';
                x += 1;
                y -= 1;
            }else if(draw[x][y] == 'Y' || draw[x][y] == 'X' ){
                break;
            }
        }

    }
    private static void dfs_Y(int x,int y,char[][] draw){

        while (x < draw.length && x >= 0 && y >= 0 && y < draw[0].length){
            if(draw[x][y] == 'Y'){
                draw[x][y] = 'X';
                x += 1;
                y += 1;
            }else if(draw[x][y] == 'G'){
                draw[x][y] = 'B';
                x += 1;
                y += 1;
            }else if(draw[x][y] == 'B' || draw[x][y] == 'X'){
                break;
            }
        }


    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(sc.hasNext()){

            int N = sc.nextInt();
            int M=  sc.nextInt();
            
            char[][] draw = new char[N][M];

            sc.nextLine();
            for (int i = 0; i < N; i++) {
                draw[i]  = sc.nextLine().replace(" ","").toCharArray();
            }

            int count = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if(draw[i][j] == 'Y'){ // '\'
                        dfs_Y(i,j,draw);
                        count++;
                    }else if(draw[i][j] == 'B'){ // '/'
                        dfs_B(i,j,draw);
                        count++;
                    }else if(draw[i][j] == 'G'){
                        dfs_Y(i,j,draw);
                        count++;
                        dfs_B(i,j,draw);
                        count++;
                    }

                }
            }

            System.out.println(count);






        }
    }


}
