
import java.util.Scanner;

public class HJ55 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while(sc.hasNext()){
            int number = sc.nextInt();
            if(number < 7){
                System.out.println(0);
                continue;
            }

            int total = 1;
            for (int i = 8; i <= number ; i++) {
                if(i%7 == 0){
                    ++total;
                    continue;
                }
                if(Integer.toString(i).contains("7")){
                    ++total ;
                    continue;
                }
            }
            System.out.println(total);
        }


    }



}
