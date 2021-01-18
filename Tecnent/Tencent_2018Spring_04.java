

import java.util.Arrays;
import java.util.Scanner;

public class Tencent_2018Spring_04 {


    private static final long mod = 1000000007;
    private static long[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(sc.hasNext()){
            int K = sc.nextInt();
            int A = sc.nextInt();
            int X = sc.nextInt();
            int B = sc.nextInt();
            int Y = sc.nextInt();
            dp = new long[1010];
            int[] p = new int[210];

            // 回溯会超时，标准的是01背包问题+滚动数组

            for(int i=1; i<=X; i++) p[i]=A;
            for(int i=X+1; i<=X+Y; i++) p[i]=B;
            dp[0]=1;
            for (int i = 1; i <= X+Y; i++) {
                // j 其实是曲目剩余的长度
                for (int j = K; j >= p[i] ; j--) {
                    dp[j] = (dp[j] + dp[j-p[i]] ) % mod;

                }

            }
            System.out.println(dp[K] % mod);
//            5
//            2 3 3 3


        }


    }




}
