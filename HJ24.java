package WebTest.Huawei;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class HJ24 {
//    8
//    186 186 150 200 160 130 197 200
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(sc.hasNext()){

            int N = sc.nextInt();
            if(N < 2){
                System.out.println(0);
            }
            int[] nums = new int[N];
            int[] leftQueue = new int[N];
            int[] rightQueue = new int[N];

            for (int i = 0; i < N; i++) {
                nums[i] = sc.nextInt();
                leftQueue[i] = 1;
                rightQueue[i] = 1;
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < i; j++) {
                    // 核心
                    if(nums[i] > nums[j] && leftQueue[j]+1 > leftQueue[i]){
                        leftQueue[i] = leftQueue[j]+1;
                    }
                }
            }

            for (int i = N-1; i >= 0 ; i--) {
                for (int j = N-1; j > i ; j--) {
                    // 核心
                    // 反向依然是找最长递增子序列，所以是nums[i] > nums[j]
                    if(nums[i] > nums[j] && rightQueue[j]+1 > rightQueue[i]){
                        rightQueue[i] = rightQueue[j]+1;
                    }
                }
            }

            // 最后两个最长递增子序列相加，就是最大值
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < N; i++) {
                min = Math.min(min,N - rightQueue[i] - leftQueue[i]);

            }


            System.out.println(min+1);



        }



    }


}
