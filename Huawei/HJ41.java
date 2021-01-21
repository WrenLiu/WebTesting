

import java.util.*;

public class HJ41 {

    public static Set<Integer> hashSet ;
    public static int N ;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(sc.hasNext()){
            N = sc.nextInt();
            int[] weight = new int[N];
            int[] count = new int[N];
            Set<Integer> set01 = new LinkedHashSet<>();

            for (int i = 0; i < N; i++) {
                weight[i] = sc.nextInt();
            }
            for (int i = 0; i < N; i++) {
                count[i] = sc.nextInt();
            }



            for (int i = 0; i <= count[0]; i++) {
                set01.add(weight[0] * i);
            }

            for (int i = 1; i < N; i++) {
                ArrayList<Integer> arrayList = new ArrayList<>(set01);

                for (int j = 0; j <= count[i]; j++) {
                    for (int k = 0; k < arrayList.size(); k++) {
                        set01.add(arrayList.get(k) + j * weight[i]);
                    }
                }
            }


            System.out.println(set01.size());








        }
    }



    public static void main01(String[] args) {

        Scanner sc = new Scanner(System.in);


//  2
//1 2
//2 1
        while(sc.hasNext()){

            N = sc.nextInt();
            int[] weight = new int[N];
            int[] count = new int[N];
            hashSet = new HashSet<>();
            for (int i = 0; i < N; i++) {
                weight[i] = sc.nextInt();
            }
            for (int i = 0; i < N; i++) {
                count[i] = sc.nextInt();
            }

            int total = 0;
            helper(weight,count,total);

            System.out.println(hashSet.size());





        }


    }

    private static void helper(int[] weight,int[] count,int total){
        if(!hashSet.contains(total)){
            hashSet.add(total);
        }

        for (int i = 0; i < N; i++) {
            if(count[i] == 0) continue;

            total += weight[i];
            count[i] --;
            helper(weight,count,total);

            total -= weight[i];
            count[i]++;
        }



    }


}
