
import java.util.Scanner;

public class HJ37 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        while(sc.hasNext()){
            int month = sc.nextInt();

            if(month <= 0){
                System.out.println();
                continue;
            }
            if(month <= 2){
                System.out.println(1);
            }

            int child_1 = 1;
            int child_2 = 0;
            int parent = 0;

            int tmp = 0;
            for (int i = 0; i < month-1; i++) {

                tmp = child_2;
                child_2 = child_1;
                parent += tmp;
                child_1 = parent;

            }

            System.out.println(child_1+child_2+parent);



        }


    }




}
