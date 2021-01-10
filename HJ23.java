package WebTest.Huawei;


import java.util.*;

public class HJ23 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(sc.hasNext()) {
            String str = sc.nextLine();

            int[] line = new int[26];
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                int index = c - 97;
                line[index] = line[index] + 1;
            }

            int minNum = 20;
            LinkedList<Character> linkedList = new LinkedList<>();
            for (int i = 0; i < 26; i++) {
                if (line[i] == 0) {
                    continue;
                }
                if (line[i] < minNum) {
                    minNum = line[i];
                    linkedList = new LinkedList<>();
                    linkedList.add((char) ('a' + i));
                } else if (line[i] == minNum) {
                    linkedList.add((char) ('a' + i));
                }
            }

            StringBuffer stringBuffer = new StringBuffer();
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if (linkedList.contains(c)) {
                    continue;
                } else {
                    stringBuffer.append(c);
                }
            }
            System.out.println(stringBuffer);

        }


    }

}
