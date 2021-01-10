
import java.util.*;
public class HJ21 {

    // 1--1， abc--2, def--3, ghi--4, jkl--5, mno--6, pqrs--7, tuv--8 wxyz--9, 0--0,
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        while (sc.hasNext()) {
            String keyword = sc.nextLine();
            StringBuffer stringBuffer = new StringBuffer();

            for (int i = 0; i < keyword.length(); i++) {
                char c = keyword.charAt(i);
                if (Character.isDigit(c)) {
                    stringBuffer.append(c);
                    continue;
                }
                if (Character.isUpperCase(c)) {
                    if(c=='Z'){
                        stringBuffer.append('a');
                        continue;
                    }
                    c = Character.toLowerCase(++c);
                    stringBuffer.append(c);
                    continue;
                }

                if (Character.isLowerCase(c)) {
                    if (c >= 'a' && c <= 'c') {
                        stringBuffer.append("2");
                    } else if (c >= 'd' && c <= 'f') {
                        stringBuffer.append("3");
                    } else if (c >= 'g' && c <= 'i') {
                        stringBuffer.append("4");
                    } else if (c >= 'j' && c <= 'l') {
                        stringBuffer.append("5");
                    } else if (c >= 'm' && c <= 'o') {
                        stringBuffer.append("6");
                    } else if (c >= 'p' && c <= 's') {
                        stringBuffer.append("7");
                    } else if (c >= 't' && c <= 'v') {
                        stringBuffer.append("8");
                    } else if (c >= 'w' && c <= 'z') {
                        stringBuffer.append("9");
                    }


                    continue;
                }


            }

            System.out.println(stringBuffer);
        }

    }
}

