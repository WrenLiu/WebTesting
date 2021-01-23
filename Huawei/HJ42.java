
import java.util.Scanner;

public class HJ42 {

    public static String[] strings_1 = {"","one","two","three","four","five","six","seven","eight","nine"};
    public static String[] strings_10 = {"","","twenty","thirty","forty","fifty","sixty","seventy","eighty","ninety"};

    //    billion，million，thousand，hundred

    public static final String[] ones = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };
    public static final String[] tens = { "ten","eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nighteen" };
    public static final String[] twenties = { "zero","ten","twenty","thirty","forty","fifty","sixty","seventy","eighty","ninety" };
    public static final long[] ihundreds = { (long)1e2, (long)1e3, (long)1e6, (long)1e9, (long)1e12};
    public static final String[] hundreds =  { "hundred", "thousand", "million", "billion" };


    public static StringBuffer itoe (long number){

        if(number <= 9 && number >= 0) return new StringBuffer(ones[(int)number]);
        if(number < 20 && number >= 10) return new StringBuffer(tens[(int)number]);
        if(number < 1e2 && number >= 20) return new StringBuffer(twenties[(int)(number/10)] + (number % 10 != 0 ? " " +ones[(int)(number % 10)] : "" ));

        for (int i = 0; i < 4; i++) {
            if(number < ihundreds[i+1]){
                return new StringBuffer(itoe(number/ihundreds[i]) + " " + hundreds[i] + (number%ihundreds[i]!=0 ? (i!=0 ? " ": " and ") + itoe(number%ihundreds[i]) : ""));
            }
        }

        return new StringBuffer("");

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(sc.hasNext()){

            long number = sc.nextLong();
            StringBuffer result = itoe(number);
            System.out.println(result);



        }


    }

    public static void main_mine(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(sc.hasNext()){
            String numberString = sc.nextLine();

            if(numberString.length()>9 || numberString.contains(".") || numberString.contains("-")){
                System.out.println("error");
                break;
            }

            String[] strings = new String[3];

            for (int i = 0; i < 3; i++) {
                if(numberString.length()-1-i*3-3 >= 0){
                    strings[i] = numberString.substring(numberString.length()-i*3-3,numberString.length()-i*3);
                }else{
                    strings[i] = numberString.substring(0,numberString.length()-i*3);
                    break;
                }
            }



            StringBuffer stringBuffer01 = strings[0].length() >= 3 ? helper(strings[0],true) : helper(strings[0],false);

            StringBuffer stringBuffer02 = strings[1] != null && strings[1].length() >= 3 ? helper(strings[1],true) : helper(strings[1],false);
            StringBuffer stringBuffer03 = strings[2] != null && strings[2].length() >= 3 ? helper(strings[2],true) : helper(strings[2],false);

            StringBuffer result = new StringBuffer(stringBuffer01);
            if(stringBuffer02.length() != 0) {
                result.insert(0, stringBuffer02 + " thousand ");
            }

            if(stringBuffer03.length() != 0){
                result.insert(0, stringBuffer03 + " million ");
            }
            System.out.println(result);



        }


    }

    private static StringBuffer helper(String number,boolean needAnd){

        if(number == null){
            return new StringBuffer("");
        }
        StringBuffer stringBuffer01 = new StringBuffer();
        if(number.length()==3){
            if(needAnd == true){
                stringBuffer01.append(strings_1[number.charAt(0)-'0']+" hundred and "+strings_10[number.charAt(1)-'0']+" "+strings_1[number.charAt(2)-'0']);
            }else{
                stringBuffer01.append(strings_1[number.charAt(0)-'0']+" hundred "+strings_10[number.charAt(1)-'0']+" "+strings_1[number.charAt(2)-'0']);
            }
        }else if(number.length()==2){
            stringBuffer01.append(strings_10[number.charAt(0)-'0']+" "+strings_1[number.charAt(1)-'0']);

        }else if(number.length()==1){
            stringBuffer01.append(strings_1[number.charAt(0)-'0']);

        }

        return stringBuffer01;
    }


}
