

import java.util.Scanner;

public class HJ71 {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while(sc.hasNext()) {
            String wildStr = sc.nextLine();
            String goalStr = sc.nextLine();


            System.out.println(helper(wildStr,goalStr,0,0));




        }


    }


    private static boolean helper(String s1,String s2,int index01,int index02){



        //base case
        if (index01 == s1.length() && index02 == s2.length()){
            return true;
            
            // 因为前面已经比较过两者都是到字符串结尾的情况，所以只要有一个是到字符串结尾的就是错误的
        }else if (index01 == s1.length() || index02 == s2.length()){
            return false;
        }

        if(s1.charAt(index01) == '?' || s1.charAt(index01) == s2.charAt(index02)){

            // 这两种情况都是只需要前进一步继续比较就可以了
            return helper(s1,s2,index01+1,index02 +1);

        }else if(s1.charAt(index01) == '*'){

            // 当遇到 * 的时候，要不就忽略 * ，要不就让str2继续前进
            return helper(s1,s2,index01,index02+1) || helper(s1,s2,index01+1,index02+1);

        }
        
        return false;


    }

    public static void main_baoli(String[] args) {

        Scanner sc = new Scanner(System.in);

//        while(sc.hasNext()){
//            String wildStr = sc.nextLine() ;
//            String goalStr = sc.nextLine() ;



            String wildStr = "f*kdalchp*hxfbfyld*";
            String goalStr = "ftkdalchpmhxfbfyldc";

//        String wildStr = "nddpvisdc*?scrg?g*sgewtihjlen";
//        String goalStr = "nddpvisdcbtscrgigssgewtihjlen";

            int indexA = 0,indexB = 0;

            while(indexA < wildStr.length() && indexB < goalStr.length()){

                while(indexA < wildStr.length() && indexB< goalStr.length() && wildStr.charAt(indexA) == goalStr.charAt(indexB)){
                    indexA++;
                    indexB++;
                }

                if(indexA < wildStr.length() && wildStr.charAt(indexA) == '?'){
                    indexA++;
                    indexB++;

                    continue;
                }

                if(indexA < wildStr.length() && wildStr.charAt(indexA) == '*'){
                    while(indexA < wildStr.length() && (wildStr.charAt(indexA) == '*' || wildStr.charAt(indexA) == '?')){
                        indexA ++;
                    }

                    if(indexA == wildStr.length()){
                        indexB = goalStr.length();
                        break;
                    }

                    int leftIndex = indexA;
                    int rightIndex = indexA;
                    while(rightIndex < wildStr.length() &&  wildStr.charAt(rightIndex) != '*' && wildStr.charAt(rightIndex) != '?'){
                        rightIndex++;
                    }

                    String stringTmp = wildStr.substring(leftIndex,rightIndex);


                    int indexTmp = goalStr.substring(indexB).indexOf(stringTmp);

                    System.out.println("stringTmp  "+stringTmp);
                    System.out.println("index  "+(indexTmp+indexB));
                    if(indexTmp == -1){
                        break;
                    }else {
                        indexA = rightIndex;
                        indexB = indexTmp + indexB + rightIndex - leftIndex;

                    }



//                    System.out.println(indexA +" " +indexB+" "+wildStr.charAt(indexA)+" "+goalStr.charAt(indexB));

                    continue;



                }


//                System.out.println("----");

                break;



            }


            if(indexA == wildStr.length() && indexB == goalStr.length()){
                System.out.println(true);
            }else {
                System.out.println(false);
            }




        }

//    }




}
