import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class HJ105 {

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);

        while(sc.hasNext()){

            int res = 0;
            int fushu = 0;
            ArrayList<Integer> arrayList = new ArrayList<>();

            while(sc.hasNext()){
                if(sc.nextLine() == ""){
                    break;
                }
                int num = sc.nextInt();
                if(num < 0){
                    fushu ++;
                    continue;
                }else {
                    arrayList.add(num);
                    res += num;
                }

            }
            DecimalFormat df = new DecimalFormat("0.0");
            System.out.println(fushu);

            System.out.println(df.format(1.0f * res / arrayList.size()));



        }
    }




}
