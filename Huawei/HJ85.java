

import java.util.Scanner;

public class HJ85 {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while(sc.hasNext()){

            String str = sc.nextLine();

            int left= 0, right = 1;

            int maxLen = 0;

            while(right < str.length()){

                if(str.charAt(left) == str.charAt(right)){

                    int newLeft = left, newRight = right;
                    while(newLeft >= 0 && newRight < str.length() && str.charAt(newLeft) == str.charAt(newRight)){
                        newLeft--;
                        newRight++;
                    }

                    maxLen = Math.max(maxLen , newRight-newLeft-1);


                }

                left++;
                right++;



            }

            System.out.println(maxLen);


        }


    }


}
