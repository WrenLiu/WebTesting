import java.util.*;

public class HJ27 {


    // 这个还是很简单的
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while(sc.hasNext()){

            String[] strings=  sc.nextLine().split(" ");
            int N = Integer.decode(strings[0]);
            String str = strings[1+N];

            int k = Integer.decode(strings[N+2]);
            List<String> list = new ArrayList<>();

            int m = 0;
            char[] targetChars = str.toCharArray();
            Arrays.sort(targetChars);

            for (int i = 1; i < N+1; i++) {
                String strTmp = strings[i];
                if(strTmp.compareTo(str) == 0 || strTmp.length() != str.length()){
                    continue;
                }

                char[] chars = strTmp.toCharArray();
                Arrays.sort(chars);

                boolean flag = true;
                for (int j = 0; j < chars.length; j++) {
                    if(chars[j] != targetChars[j]){
                        flag = false;
                        break;
                    }
                }
                if(flag == true){
                    m++;
                    list.add(strTmp);
                }

            }
            System.out.println(m);
            Collections.sort(list);
            if (list.size() >= k) {
                System.out.println(list.get(k - 1));
            }


        }


    }





}
