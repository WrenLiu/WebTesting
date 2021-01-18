package WebTest.Tecent;

import java.util.Arrays;
import java.util.Scanner;

public class Tencent_2018Spring_02 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while(sc.hasNext()){

            int N = sc.nextInt();
            int[] nums = new int[N];

            for (int i = 0; i < N; i++) {
                nums[i] = sc.nextInt();
            }

            Arrays.sort(nums);
            int jishu = 0 , oushu = 0;
            for (int i = 0; i < N; i++) {
                if(i % 2==0){
                    oushu+=nums[i];
                }else{
                    jishu+=nums[i];
                }
            }

            System.out.println((int)Math.abs(jishu-oushu));




        }
    }


}
