
import java.util.*;
public class HJ61 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while(sc.hasNext()) {

            String[] strs = sc.nextLine().split(" ");


            Integer M = Integer.parseInt(strs[0]);
            Integer N = Integer.parseInt(strs[1]);

            System.out.println(Solution(M, N));
            System.out.println(dp_method(M,N));
        }
    }

    public static int Solution(int m,int n){

        if(m<0){
            return 0;
        }
        if(m==1||n==1){
            return 1;
        }

        // 如果盘子的数量大于苹果数量，则不论如何都有空盘
        if(n>m){
            return Solution(m,m);
        }else {

            // 盘子的数量小于苹果，这就有两种情况，而最后的结果是两种情况之和
            // 1) 至少有一个盘子空着 f(m,n) = f(m,n-1);
            // 2) 所有的盘子都有苹果,相当于从每个盘子中拿掉一个苹果 f(m,n) = f(m-n,n)+f(m-n,n);
            return Solution(m-n,n)+Solution(m,n-1);
        }
    }

    public static int dp_method(int m,int n){
        int[][] dp = new int[m+1][n+1];

        for(int i=1;i<=n;i++){
            dp[0][i] = 1;
        }
        for(int i=1;i<=m ;i++){
            for(int j=1;j<=n;j++){
                dp[i][j] = dp[i][j-1]+(i<j?0:dp[i-j][j]);
            }
        }

        return dp[m][n];

    }

}
