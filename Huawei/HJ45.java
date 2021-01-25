import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class HJ45 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int N = Integer.parseInt(scanner.nextLine());
            for (int i = 0; i < N; i++) {
                System.out.println(helper(scanner.nextLine().trim().toLowerCase()));
            }


        }

    }

    private static int helper(String stringName){

        int[] arrAlpha = new int[26];
        for (int i = 0; i < stringName.length(); i++) {
            arrAlpha[(int)(stringName.charAt(i) - 'a')] ++;
        }

        int result = 0;

        Arrays.sort(arrAlpha);
        int index = 25, number = 26;
        while(index >= 0 && arrAlpha[index] != 0){
            result += arrAlpha[index--]*(number--);
        }

        return result;





    }


}
