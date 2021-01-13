
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class HJ36 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){

            String key = sc.nextLine();
            key = key.toLowerCase();
            String word = sc.nextLine();

            Set<Character> set = new LinkedHashSet<>();
            for (int i = 0; i < key.length(); i++){
                set.add(key.charAt(i));
            }
            ArrayList<Character> arrayList = new ArrayList(26);
            int[] alphabet = new int[26];

            for (Character character : set) {
                arrayList.add(character);
            }

            for (int i = 0; i < 26; i++) {
                if(!set.contains((char)(i+'a'))){
                    arrayList.add((char)(i+'a'));
                }
            }
            for (Character character : arrayList) {
                System.out.print(character);
            }
            System.out.println();
            StringBuffer stringBuffer = new StringBuffer();
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if(c <= 'z' && c>='a'){
                    stringBuffer.append(arrayList.get(c - 'a'));
                }else if(c >= 'A' && c <= 'Z'){

//                    System.out.println(c+" "+i);
                    stringBuffer.append( (arrayList.get(c-'A')+"").toUpperCase());
                }else {
                    stringBuffer.append(c);
                }

            }

            System.out.println(stringBuffer);

        }

    }

}
