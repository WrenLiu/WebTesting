import java.util.ArrayList;
import java.util.Scanner;

public class HJ31 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while(sc.hasNext()){
            String str = sc.nextLine();

            ArrayList<StringBuffer> arrayList = new ArrayList<>();

            StringBuffer stringBufferTmp = new StringBuffer();

            // $bo*y gi!r#l #
            for (int i = 0; i < str.length(); i++) {

                if((str.charAt(i) <= 'Z' && str.charAt(i) >= 'A' ) || (str.charAt(i) <= 'z' && str.charAt(i) >= 'a' )){
                    stringBufferTmp.append(str.charAt(i));

                }else{

                    arrayList.add(stringBufferTmp);
                    stringBufferTmp = new StringBuffer();
                }


            }
            arrayList.add(stringBufferTmp);


            stringBufferTmp = new StringBuffer();
            for (int i = arrayList.size()-1; i > 0; i--) {
                stringBufferTmp.append(arrayList.get(i)+" ");
            }
            stringBufferTmp.append(arrayList.get(0));

            String result = stringBufferTmp.toString().trim();
            while(result.endsWith(" ")){
                result = result.substring(0,result.length()-1);
            }
            System.out.println(result);


        }


    }

    private void solution_nowcoder(){
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        if("".equals(text.trim())){
            System.out.println("");
        }else{
            String[] sp = text.split("[^a-zA-Z]+");
            StringBuilder sb = new StringBuilder();
            for (int i = sp.length - 1; i >= 0; i--)
                sb.append(sp[i] + " ");
            System.out.println(sb.toString().trim());
            sc.close();
        }
    }




}
