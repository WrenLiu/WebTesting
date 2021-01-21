
import java.util.HashMap;
import java.util.Scanner;

public class HJ40 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(sc.hasNext()){

            String str = sc.nextLine();

            HashMap<String,Integer> hashMap = new HashMap<>();
            hashMap.put("alpha",0);
            hashMap.put("none",0);
            hashMap.put("number",0);
            hashMap.put("other",0);

            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if((c <= 'Z' && c >= 'A') || (c <= 'z' && c >= 'a')){
                    hashMap.put("alpha",hashMap.get("alpha")+1);
                }else if(c == ' '){
                    hashMap.put("none",hashMap.get("none")+1);
                }else if(c <= '9' && c >= '0'){
                    hashMap.put("number",hashMap.get("number")+1);
                }else{
                    hashMap.put("other",hashMap.get("other")+1);
                }
            }

            System.out.println(hashMap.get("alpha"));
            System.out.println(hashMap.get("none"));
            System.out.println(hashMap.get("number"));
            System.out.println(hashMap.get("other"));


        }


    }

}
