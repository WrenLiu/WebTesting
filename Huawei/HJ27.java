package WebTest.Huawei;

import java.sql.Array;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class HJ27 {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while(sc.hasNext()){

            String[] strings = sc.nextLine().split(" ");
            System.out.println(strings.length);
            int N = Integer.decode(strings[0]);

            String str = strings[1+N];

            // strings 的第一个到第N个都是需要的数组
            int k = Integer.decode(strings[N+2]);

            StringBuffer stringBuffer = new StringBuffer();
            int m = 0;

            for (int i = 1; i < N+1; i++) {
                String strTmp = strings[i];

                if(strTmp.compareTo(str) == 0 || strTmp.length() != str.length()){
                    continue;
                }

                HashMap<Character,Integer> hashMap = new HashMap<>();

                for (int j = 0; j < str.length(); j++) {
                    if(hashMap.containsKey(str.charAt(j))) {
                        hashMap.put(str.charAt(j), hashMap.get(str.charAt(j)) + 1);
                    }else{
                        hashMap.put(str.charAt(j),1);
                    }
                }

                boolean flag = true;
                for (int j = 0; j < strTmp.length(); j++) {
                    char c = strTmp.charAt(j);
                    if(hashMap.containsKey(c)){
                        hashMap.put(c,hashMap.get(c)-1);
                    }else{
                        flag = false;
                    }
                }
                for (Character character : hashMap.keySet()) {
                    if(hashMap.get(character) != 0){
                        flag = false;
                    }
                }

                if(flag == true){
                    m++;
                    stringBuffer.append(strTmp+" ");
                }
            }

            System.out.println("------");
            String[] string_result = stringBuffer.toString().split(" ");

//            for (int i = 0; i < string_result.length-1; i++) {
//                for (int j = string_result.length-1; j > i ; j--) {
//
//                    if(string_result[j].compareTo(string_result[j-1]) < 0){
//                        String tmp = string_result[j];
//                        string_result[j] = string_result[j-1];
//                        string_result[j-1] = tmp;
//                    }
//                }
//            }

            for(int i=0;i<string_result.length-1;i++){

                // 设定一个标记，若为true，则表示此次循环没有进行交换，也就是待排序列已经有序，排序已经完成。
                boolean flag = true;

                // 比较的次数
                for(int j =0 ;j<string_result.length - i -1;j++){
                    if(string_result[j].compareTo(string_result[j+1]) > 0){
                        String tmp = string_result[j];
                        string_result[j] = string_result[j+1];
                        string_result[j+1] = tmp;
                    }

                }

                if (flag) {
                    break;
                }
            }




            // 输出
            System.out.println(m); // 兄弟个数
            if(m > k-1){
                System.out.println(string_result[k-1]);
            }



        }


    }






}
