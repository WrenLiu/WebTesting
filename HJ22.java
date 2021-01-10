package WebTest.Huawei;

import java.util.Scanner;

public class HJ22 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){

            int n = sc.nextInt();
            if(n == 0){
                break;
            }
            int res = fun(n);
            System.out.println(res);

        }

    }

    private static int fun(int n){
        if(n == 0 || n==1){
            return 0;
        }
        if( n == 2 ){
            return 1;
        }

        int num = n/3;

        return  num + fun(num+n%3);

    }
}
