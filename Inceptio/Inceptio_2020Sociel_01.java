
import java.util.Scanner;

public class Inceptio_2020Sociel_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        if(input.length() < 2){
            System.out.println("false");
            return;
        }

        if(input.charAt(0) == '"' && input.charAt(input.length()-1) == '"' && input.charAt(input.length()-2) != '\\'){
            for (int i = 1; i < input.length()-1; i++) {
                if(input.charAt(i) == '"'  ){
                    if(input.charAt(i-1) == '\\' && input.charAt(i-2) != '\\'){
                        System.out.println("true");
                        return ;
                    }else{
                        System.out.println("false");
                        return ;
                    }


                }
            }

            System.out.println("true");

        }else{
            System.out.println("false");
        }


        // System.out.println("true");
        // or
        // System.out.println("false");
    }
}