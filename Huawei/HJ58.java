
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class HJ58 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){

            int N = sc.nextInt();
            int k = sc.nextInt();

            int[] nums = new int[N];

            for (int i = 0; i < N; i++) {
                nums[i] = sc.nextInt();
            }

            Arrays.sort(nums);

            for (int i = 0; i < k; i++) {
                System.out.print(nums[i] + " ");
            }
            System.out.println();




        }

    }


}
