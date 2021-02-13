

import java.util.Scanner;

public class XiaoMi_2015Summer_01 {


    public static void main(String[] args) {
        System.out.println(countBitDiff(0,2147483647));


    }
    public static int countBitDiff(int m, int n) {
        String mStr = Integer.toBinaryString(m);
        String nStr=  Integer.toBinaryString(n);

//        System.out.println(mStr);
//        System.out.println(nStr);

//        int total = Math.abs(mStr.length()-nStr.length());
        int total = 0;
        int indexM = mStr.length()-1,indexN = nStr.length()-1;

        while(indexM>= 0 && indexN >= 0){

            if(mStr.charAt(indexM) != nStr.charAt(indexN)){
                total ++;
            }
            indexM--;
            indexN--;

        }


        if (indexM >= 0 && indexN < 0) {
            while (indexM >= 0 && indexM < mStr.length()) {
                if (mStr.charAt(indexM) == '1') {
                    total++;
                }
                indexM--;

            }
        } else if (indexN >= 0 && indexM < 0) {
            while (indexN >= 0 && indexN < nStr.length()) {
                if (nStr.charAt(indexN) == '1') {
                    total++;
                }
                indexN--;

            }

        }




        return total;
    }

}
