import java.util.Scanner;

public class HJ46 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while(scanner.hasNext()){
            String str = scanner.nextLine();
            int stopIndex = Integer.parseInt(scanner.nextLine());
            if(stopIndex > str.length()){
                continue;
            }
            System.out.println(str.substring(0,stopIndex));


        }

    }


}
