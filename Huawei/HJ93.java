
import java.util.ArrayList;
import java.util.Scanner;

public class HJ93 {



    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while(sc.hasNext()){

            int total = sc.nextInt();




            ArrayList<Integer> arrayList = new ArrayList<>();
            int sum01 = 0;
            int sum02 = 0;


            for (int i = 0; i < total; i++) {

                int tmp = sc.nextInt();

                if(tmp %5 == 0){
                    sum01 += tmp;
                    continue;
                }else if(tmp % 3 == 0){
                    sum02 += tmp;
                    continue;
                }

                if(tmp == 0){
                    continue;
                }
                arrayList.add(tmp);
            }


            int[] nums = new int[arrayList.size()];
            int index = 0;
            for (Integer integer : arrayList) {
                nums[index++] = integer;
            }





            System.out.println(helper(sum01 ,sum02 ,nums ,0));



        }


    }

    private static boolean helper(int sum01 ,int sum02 ,int[] nums  , int index ){


        if(sum01 == sum02 && index == nums.length){
            return true;
        }

        if(sum01 != sum02 && index == nums.length){
            return false;
        }


        return helper(sum01 + nums[index] ,sum02 , nums,index+1) ||
                helper( sum01,sum02+nums[index] , nums,index+1);




/*

20
-2 0 -3 3 -3 -4 -3 1 3 3 -2 0 3 2 2 -5 1 -2 -3 -5
 */













    }


}
