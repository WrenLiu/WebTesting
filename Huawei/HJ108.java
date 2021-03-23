
import java.util.ArrayList;
import java.util.Scanner;

public class HJ108 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

//        538 13252
        while (sc.hasNext()) {

            int num01 = sc.nextInt();
            int num02 = sc.nextInt();

            ArrayList<Integer> arrayList01 = new ArrayList<>();
            ArrayList<Integer> arrayList02 = new ArrayList<>();

            fun(num01,arrayList01);
            fun(num02,arrayList02);


            for (Integer integer : arrayList01) {
                System.out.print(integer+" ");
            }
            System.out.print("    ");
            for (Integer integer : arrayList02) {
                System.out.print(integer+" ");
            }
            System.out.println();


            for (Integer integer : arrayList01) {
                if(arrayList02.contains(integer)){
                    arrayList02.remove(integer);
                }
            }
//            for (Integer integer : arrayList02) {
//                if(arrayList01.contains(integer)){
//                    arrayList01.remove(integer);
//                }
//            }

            int res = 1;
            for (Integer integer : arrayList01) {
                res *= integer;
            }

            for (Integer integer : arrayList02) {
                res *= integer;
            }

            System.out.println(res);





        }
    }


    private static void fun(int num , ArrayList<Integer> arrayList) {


        for(int i= 2;i<= Math.sqrt(num);i++) {
            while(num%i ==0) {
                arrayList.add(i);
                num /=i;
            }
        }
        if(num >1) {
            arrayList.add(num);
        }

    }


}
