

import java.util.Scanner;

public class HJ65 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while(scanner.hasNext()){

            String string1 = scanner.nextLine();
            String string2 = scanner.nextLine();

            String str1 ,str2;
            if(string1.length() < string2.length()){
                str1 = string1;
                str2 = string2;
            }else{
                str1 = string2;
                str2 = string1;
            }

            int maxLength = 0;
            int startIndex = 0;
            for (int i = 0; i < str1.length();i++){


                for (int j = 0; j < str2.length(); j++) {


                    if(str1.charAt(i) != str2.charAt(j)){
                        continue;
                    }

                    int tmpLen = 1;
                    while(((i+tmpLen) < str1.length()+1) && ((j+tmpLen) <str2.length()+1) && str1.substring(i,i+tmpLen).equals(str2.substring(j,j+tmpLen))){


                        if(tmpLen > maxLength){
//                            System.out.println(str1.charAt(startIndex)+" "+tmpLen);
                            startIndex = i;
                            maxLength = tmpLen;
                        }

                        tmpLen++;

                    }


                }




            }

            System.out.println(str1.substring(startIndex,startIndex+maxLength));



        }


    }


}
