

import java.util.*;

public class HJ26 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(sc.hasNext()) {
            String str = sc.nextLine();

            // 得到只含英文的String
            StringBuffer stringBuffer = stringSort(str);
            StringBuffer result = new StringBuffer();

            int index = 0;
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);

                if (c <= 'z' && c >= 'a' || c <= 'Z' && c >= 'A') {
                    result.append(stringBuffer.charAt(index++));
                } else {
                    result.append(c);
                }

            }

            System.out.println(result);

        }






    }

    private static StringBuffer stringSort(java.lang.String str){

        StringBuffer stringBuffer = new StringBuffer();
        for(int j = 0 ;j<26 ;j++){
            for(int i =0 ;i < str.length() ; i++){

                char c =  str.charAt(i);
                if( c-'a' == j || c-'A' == j){
                    stringBuffer.append(c);
                }

            }
        }


        return stringBuffer;


    }

}
