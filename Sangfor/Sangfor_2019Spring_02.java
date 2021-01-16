
import java.util.*;

public class Sangfor_2019Spring_02 {

    private static int K,N;
    private static int[] counts ;
    private static TreeSet<String> set;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {

            K = sc.nextInt();
            N = sc.nextInt();
            counts = new int[K];
            set = new TreeSet<>();
            
            for (int i = 0; i < K; i++) {
                counts[i] = sc.nextInt();
            }
            int[] nums = new int[K];
            for (int i = 0; i < K; i++) {
                nums[i] = 0;
            }
//            dfs(K-1,0,nums);
            dfs02(0,0,nums);
            for (String string : set) {
                System.out.println(string);
            }
            



        }
    }

    private static void dfs02(int colour,int len,int[] nums){

        if(len == N){
            StringBuffer tmp = new StringBuffer();
            for (int i = 0; i < nums.length; i++) {
                tmp.append(nums[i]);
            }
            set.add(tmp.toString());
            return;
        }

        for (int i=colour;i<=K-1;i++){
            if(counts[i]>0){
                nums[i] += 1;
                counts[i]--;
                dfs(i,len+1,nums);
                counts[i]++;
                nums[i] -= 1;
            }
        }


    }

    private static void dfs(int index,int len,int[] nums){

        if(len == N){
            StringBuffer tmp = new StringBuffer();
            for (int i = 0; i < nums.length; i++) {
                tmp.append(nums[i]);
            }
            set.add(tmp.toString());
            return;
        }
        for (int i=index;i>=0;i--){
            if(counts[i]>0){
                nums[i] += 1;
                counts[i]--;
                dfs(i,len+1,nums);
                counts[i]++;
                nums[i] -= 1;
            }
        }


    }


}
