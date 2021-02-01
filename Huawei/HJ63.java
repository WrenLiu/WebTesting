

import java.util.Scanner;

public class HJ63 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while(scanner.hasNext()){

            String string = scanner.nextLine();
            int N = scanner.nextInt();
            int max = 0;
            int maxIndex = 0;

            for (int i = 0; i < string.length() - N; i++) {

                int counts = 0;
                for (int j = i; j < i+N; j++) {
                    if(string.charAt(j) == 'G' || string.charAt(j) == 'C'){
                        counts++;
                    }
                }
                if(max < counts){
                    max = counts;
                    maxIndex = i;
                }
                if(max == N){
                    break;
                }


            }

            System.out.println(string.substring(maxIndex, maxIndex+N));

        }

    }

}
