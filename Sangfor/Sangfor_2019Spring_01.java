
import java.util.Scanner;

public class Sangfor_2019Spring_01 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            String string = sc.nextLine();
            String sub = sc.nextLine();

            int indexSub = 0;
            int indexString = 0;

            int result = Integer.MIN_VALUE;
            int count = 0;
            while ( indexString < string.length() && indexSub < sub.length() ) {

                if(string.charAt(indexString) == sub.charAt(indexSub)){
                    count++;
                    indexString++;
                    indexSub++;
                    continue;
                }

                if(sub.charAt(indexSub) != '?'){
                    count = -1;
                    break;
                }

                if(sub.charAt(indexSub) == '?'){
                    int k = 1;
                    for (; k <= 3; k++) {
                        if(sub.charAt(indexSub+1) == string.charAt(indexString+k)){
                            break;
                        }
                    }

                    if(k == 4){
                        count = -1;
                        break;
                    }else{
                        indexString += k;
                        count += k;
                        indexSub ++;
                    }

                }



            }

            if(indexSub != sub.length()){
                count = -1;
            }

            System.out.println(count);


        }
    }


}
