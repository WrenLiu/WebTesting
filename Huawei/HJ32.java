
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class HJ32 {

    public static void main(String[] args) {


        // Manacher算法
        System.out.println(manacher("abaaab"));

        Scanner sc = new Scanner(System.in);

        while(sc.hasNext()){
            String string  = sc.nextLine();

            int[] dp = new int[string.length()];

            dp[0] = 1;

            for (int i = 1; i < string.length()-1; i++) {

                int tmp = calculate(string,i);


                dp[i] = Math.max(dp[i-1],tmp);

            }
            System.out.println(dp[dp.length-2]);

        }


    }

    private static int calculate(String string,int center){

        int count = 1;
        int index = center+1;
        int left ,right;
        while(index >= 0 && index < string.length() && string.charAt(index) == string.charAt(center)){
            index++;
            count++;
        }
        right = index;
        index = center-1;

        while(index >= 0 && index < string.length() && string.charAt(index) == string.charAt(center)){
            index--;
            count++;
        }

        left = index;
        while(left >= 0 && left < string.length() && right >= 0 && right < string.length() && string.charAt(left) == string.charAt(right)){
            count += 2;
            left--;
            right++;
        }


        return count;

    }


    // manacher算法,时间复杂度O(n)
    public static int manacher(String s) {
        int count =0;//记录最大回文
        StringBuffer sb = new StringBuffer();
        char[] c =s.toCharArray();
        sb.append("#");
        //对字符串进行封装
        for (int i = 0; i < c.length; i++) {
            sb.append(c[i]);
            sb.append("#");
        }
        // "#a#b#a#a#a#b#"

        int[] rad = new int[sb.length()];//记录新字符串以每个字符为中心的最大回文半径
        char[] cl = sb.toString().toCharArray();
        int max=0;//记录已经搜寻到的回文半径能到达右端的最达大值
        int id=0;//记录回文半径能到达最有端的回文字符串的中心
        for (int i = 1; i < cl.length; i++) {
            if (max>i) {
                rad[i]=Math.min(rad[2*id-i], max-i);
            }else {
                rad[i]=1;
            }
            while (i-rad[i]>=0 && i+rad[i]<cl.length && cl[(i-rad[i])]==cl[(i+rad[i])]) {
                rad[i]++;
            }
            if (i+rad[i]>max) {
                max=i+rad[i];
                id=i;
            }
            count=Math.max(count, rad[i]-1);
        }

        return count;
    }

}
