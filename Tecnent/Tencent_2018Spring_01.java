package WebTest.Tecent;

import java.util.Scanner;

public class Tencent_2018Spring_01 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(sc.hasNext()){
            int n = sc.nextInt();
            int m = sc.nextInt();

            if(n % (2*m) != 0){
                continue;
            }

            long groups = n/(2*m);
            System.out.println(groups*(long)Math.pow(m,2));



        }


    }


}
