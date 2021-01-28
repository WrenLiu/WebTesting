

import java.util.Scanner;

public class HJ52 {

    /**
     * 生成大小为(N+1)*(M+1)的矩阵dp. dp[x][y]表示A前x个字符串编辑成 B前y个字符所花费的代价.
     * 对于第一行来说,dp[0][y]表示将一个空串变为B的前y个字符组成的子串,花费的代价为ic*y;
     * 同理,对于第一列dp[x][0] = x*dc;
     *
     * 对于其他的位置,dp[x][y]可能有以下几种取值:
     *     dp[x-1][y-1]+rc;//A[x-1]!=B[y-1] 将前x-1个字符变为B前y-1个字符,再将最后一个字符替换.
     *     dp[x-1][y-1];//A[x-1]==B[y-1] 将前x-1个字符变为B前y-1个字符,最后一个不用修改.
     *     dp[x-1][y]+dc;//删除一个字符,将前x-1个字符变为B的前y个字符
     *     dp[x][y-1]+ic;//将A前x-1个字符变为B的前y个字符,再插入一个字符
     *     dp[x][y]的值就为以上四者最小的一个.
     * 求解完毕,dp[n][m]即为所求.
     */


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str1 = sc.nextLine();
            String str2 = sc.nextLine();


            System.out.println(costFun(str1,str2));


        }


    }

    private static int costFun(String str1, String str2){

        int[][] dp = new int[str1.length()+1][str2.length()+1];



        for (int i = 0; i < str1.length()+1; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i < str2.length()+1; i++) {
            dp[0][i] = i;
        }

        for (int x = 1; x < dp.length; x++) {
            for (int y = 1; y < dp[0].length; y++) {
                if(str1.charAt(x-1) == str2.charAt(y-1)){
                    dp[x][y] = dp[x-1][y-1];
                }else{
                    dp[x][y] = Math.min(Math.min(dp[x - 1][y], dp[x - 1][y - 1]), dp[x][y - 1]) + 1;
                }
            }
        }

        return dp[dp.length - 1][dp[0].length - 1];
    }






}
