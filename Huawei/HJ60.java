

import java.util.Scanner;

public class HJ60 {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while(scanner.hasNext()){

            int num = scanner.nextInt();

            for (int i = num/2 ; i < num ; i++) {

                if(isPrime(i) && isPrime(num-i)){
                    System.out.println((num-i));
                    System.out.println(i);
                    break;
                }


            }



        }



    }

    private static boolean isPrime(int x){

        if(x ==1 || x %2 ==0 && x !=2 )
        {
            return false;
        } else {
            for( int i =3; i<= Math.sqrt(x); i+=2) {


                if( x % i == 0) {
                    return false;
                }

            }
        }

        return true;
    }



}
