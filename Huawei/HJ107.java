package WebTest.Huawei.Page03;

import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.TreeMap;

public class HJ107 {

    public static void main(String[] args)  {

        Scanner sc = new Scanner(System.in);

        while(sc.hasNext()){

            double numIn = sc.nextDouble();

            double num ;

            if(numIn < 0.0){
                num = Math.abs(numIn);
            }else {
                num = numIn;
            }
            int numInt = (int) num;


            int left = 0;
            int right = numInt;
            double res = 0;

            while(right < num+1){
                int mid = left + (right-left)/2;

//                System.out.println(left+" "+right +" "+mid);
                if ( (mid * mid * mid <= numInt) && (mid+1)*(mid+1)*(mid+1) >= numInt){
                    res = (double) mid;
                    break;
                }

                if( mid * mid * mid > numInt ){
                    right = mid;
                    continue;
                }

                if( (mid+1)*(mid+1)*(mid+1) < numInt){
                    left = mid+1;
                    continue;
                }

            }



            TreeMap<Double , Integer> treeMap = new TreeMap<>();
            for (int i = 0; i < 10; i++) {

                double tmp = res + i * 0.1;

                double chazhi = Math.abs(tmp * tmp * tmp - num);

                treeMap.put(chazhi,i);
            }

            res += treeMap.get(treeMap.firstKey() ) * 0.1;

            DecimalFormat df = new DecimalFormat("0.0");
                if(numIn < 0){
                    System.out.println(df.format(-1 * res));
                }else {
                    System.out.println(df.format(res));
                }









        }


    }


}
