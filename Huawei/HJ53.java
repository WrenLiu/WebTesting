import java.util.*;
public class HJ53 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int line = sc.nextInt();
            int firstPos = getFirstEven(line);
            System.out.println(firstPos);
        }
    }

    public static int getFirstEven(int n){

        int[][] map = new int[n+1][2*n+2];
        map[1][1] = 1;
        map[1][0] = 0;
        map[1][2] = 0;
        for(int i= 2;i<n+1;i++){
            map[i][0] = 0;
            map[i][1] = 1;
            map[i][2*i-1] = 1;
            map[i][2*i] = 0;
            for(int j = 2 ; j < (2*i-1)  ;j++){
                map[i][j] = map[i-1][j-2]+ map[i-1][j-1] + map[i-1][j];
            }
        }

        for(int i =1 ;i<2*n+1;i++){
            if(map[n][i] % 2==0){
                return i;
            }
        }

        return -1;


    }

}
