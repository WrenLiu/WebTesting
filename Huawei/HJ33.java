
import java.math.BigInteger;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

//        167773121
//        10.3.3.193

        while (sc.hasNext()) {
            String string = sc.nextLine();

            if (string.contains(".")) {
                System.out.println(IP2Integer(string));
            } else {
                System.out.println(Integer2IP(string));
            }

        }


    }

    // 10.3.3.193 -> 167773121
    // 10.3.3.193 -> 167773121
    private static String IP2Integer(String string){

        // 注意!!!!
        String[] strs = string.split("\\.");

        if(strs.length != 4){
            return null;
        }

        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < 4; i++) {
            long number = Long.decode(strs[i]);


            String binaryString = Long.toBinaryString(number);
            while (binaryString.length() < 8){
                binaryString = "0"+binaryString;
            }
            stringBuffer.append(binaryString);
        }
        return Long.valueOf(stringBuffer.toString(),2).toString();
    }

    private static String Integer2IP(String string){

        long number = Long.decode(string);
        String longNumber = Long.toBinaryString(number);
        
        return  Integer.valueOf(longNumber.substring(0,longNumber.length()-24),2) + "." +
                Integer.valueOf(longNumber.substring(longNumber.length()-24,longNumber.length()-16),2) + "." +
                Integer.valueOf(longNumber.substring(longNumber.length()-16,longNumber.length()-8),2) +"."+
                Integer.valueOf(longNumber.substring(longNumber.length()-8,longNumber.length()),2);
        
    }


}