

import java.util.*;

public class HJ92 {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while(sc.hasNext()){

            String str = sc.nextLine();

//            TreeMap<Integer,String> treeMap = new TreeMap<>();

            ArrayList<String> arrayList = new ArrayList<>();



            for (int i = 0; i < str.length(); i++) {

                if(Character.isDigit(str.charAt(i))){
                    int left = i;
                    int right = i;
                    while(right < str.length() && Character.isDigit(str.charAt(right))){
                        right++;
                    }

                    arrayList.add(str.substring(left,right));
                    i = right-1;

                }

            }

            int maxLen = 0;
            for (String string : arrayList) {
                maxLen = Math.max(maxLen,string.length());
            }

            for (String string : arrayList) {
                if(string.length() == maxLen){
                    System.out.print(string);
                }
            }

            System.out.println(","+maxLen);






        }


    }


}
