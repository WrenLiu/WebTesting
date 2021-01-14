
import java.util.Scanner;

public class HJ38 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(sc.hasNext()){
            float height = (float)sc.nextInt();
            if(height < 0.0f){
                System.out.println();
                continue;
            }
            if(height == 0.0f){
                System.out.println(0);
                continue;
            }

            float total = height + height +height/2 + height/4 + height/8 ;
            height = height / 32;

            System.out.println(total);
            System.out.println(height);


        }





    }


}
