package WebTest.Huawei;

import java.util.Scanner;

public class HJ39 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){

            String[] subNetMasks = sc.nextLine().split("\\.");
            String[] ip_01 = sc.nextLine().split("\\.");
            String[] ip_02 = sc.nextLine().split("\\.");
            int[] subNet = new int[4];
            int[] ip01 = new int[4];
            int[] ip02 = new int[4];
            boolean illegal = false;
            for (int i = 0; i < 4; i++) {
                subNet[i] = Integer.parseInt(subNetMasks[i]);
                ip01[i] = Integer.parseInt(ip_01[i]);
                ip02[i] = Integer.parseInt(ip_02[i]);
                if(subNet[i] >= 256 || subNet[i] < 0 || ip01[i]<0 || ip01[i] >= 256|| ip02[i]<0 || ip02[i] >= 256){

                    // 非法
                    System.out.println(1);
                    illegal = true;
                    break;
                }
            }

            if(illegal == true){
                continue;
            }

            // 子网掩码
            StringBuffer stringBuffer = new StringBuffer();
            for (int i = 0; i < 4; i++) {
                if(subNet[i] == 0){
                    stringBuffer.append("00000000");
                    continue;
                }
                StringBuffer tmp = new StringBuffer(Integer.toBinaryString(subNet[i]));
                while (tmp.length() < 8){

                    tmp.insert(0,"0");
                }
                stringBuffer.append(tmp);



            }
            System.out.println(stringBuffer);

            while(stringBuffer.charAt(0) == '1'){
                stringBuffer.deleteCharAt(0);
            }

            if(stringBuffer.toString().contains("1")){
                System.out.println(1);
                illegal = true;
            }
            if(illegal == true){
                continue;
            }

            for (int i = 0; i < 4; i++) {

                if(subNet[i] == 0){
                    System.out.println(0);
                    break;
                }

                if((ip01[i] & subNet[i]) != (subNet[i] & ip02[i])){
                    System.out.println(2);
                    break;
                }


            }




        }


    }


}
