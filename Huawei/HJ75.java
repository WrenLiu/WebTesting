
import java.util.Scanner;

public class HJ75 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while(sc.hasNext()){

            String s1 = sc.nextLine();
            String s2 = sc.nextLine();

            int res = 0;

//            int leftIndex = 0 ;

            for (int leftIndex = 0; leftIndex < s1.length(); leftIndex++) {

                for (int rightIndex = res+leftIndex; rightIndex < s1.length(); rightIndex++) {

                    if(s2.indexOf(s1.substring(leftIndex,rightIndex+1)) == -1){
                        continue;
                    }

                    res = Math.max(res, rightIndex - leftIndex+1 );

                }


            }

            System.out.println(res);



        }



    }




}
