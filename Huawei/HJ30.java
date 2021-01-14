
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class HJ30 {

//                                                                    7       9          12       14
    private static Character[] character =  {'0','8','4','C','2','A','6','E','1','9','5','D','3','B','7','F'};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()){

            String string = sc.nextLine();
            string = string.replace(" ","");

            ArrayList<Character> array01 = new ArrayList<>();
            ArrayList<Character> array02 = new ArrayList<>();
            for (int i = 0; i < string.length(); i++) {
                if(i % 2 == 0){
                    array02.add(string.charAt(i));
                }else{
                    array01.add(string.charAt(i));
                }
            }

            Collections.sort(array01);
            Collections.sort(array02);

            StringBuffer stringBuffer = new StringBuffer();

//            array01:b e f
//            array02:a c d

            int length = Math.min(array01.size(),array02.size());
            for (int i = 0; i < length; i++) {
                stringBuffer.append(array02.get(i));
                stringBuffer.append(array01.get(i));
            }

            if(array01.size() != array02.size()) {
                stringBuffer.append(array01.size() > array02.size() ? array01.get(array01.size() - 1) : array02.get(array02.size() - 1));

            }

            StringBuffer result = new StringBuffer();

            for (int i = 0; i < stringBuffer.length(); i++) {

                char tmpChar = stringBuffer.charAt(i);

                if(tmpChar <= '9' && tmpChar >= '0'){
                    result.append(character[tmpChar-'0']);
                }else if((tmpChar <= 'F' && tmpChar >= 'A') ){
                    int index = tmpChar-'A'+10;
                    result.append(character[index]);
                }else if((tmpChar <= 'f' && tmpChar >= 'a') ){
                    int index = tmpChar-'a'+10;
                    result.append(character[index]);
                }else {
                    result.append(tmpChar);
                }

            }
            System.out.println(result);

        }


    }


}
