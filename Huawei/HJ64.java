
import java.util.Scanner;

public class HJ64 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        while(sc.hasNext()){

            int pages = Integer.parseInt(sc.nextLine());

            String str = sc.nextLine();
            char[] ch = str.toCharArray();

            if(pages <= 4){
                Pages4_do(ch,pages);

            }else {
                PagesOver4_do(ch,pages);
            }

        }



    }

    private static void PagesOver4_do(char[] ch , int pages){

        int cur = 1;
        int[] curPage = new int[4];
        for (int i = 1; i <= 4; i++) {
            curPage[i-1] = i;
        }

        for (int i = 0; i < ch.length; i++) {
            if(ch[i] == 'U'){
                cur --;
            }else if(ch[i] == 'D'){
                cur ++;
            }

            if(cur == 0){
                cur = pages;

                for (int j = 1; j <= 4 ; j++) {
                    curPage[j-1] = pages - 4 + j;
                }
                continue;

            }else if(cur == pages+1){
                cur = 1;

                for (int j = 1; j <= 4; j++) {
                    curPage[j-1] = j;
                }
                continue;

            }

            if(cur > curPage[3]){
                for (int j = 1; j <= 4 ; j++) {
                    curPage[j-1] += 1;
                }
            }else if(cur < curPage[0]){
                for (int j = 1; j <= 4 ; j++) {
                    curPage[j-1] -= 1;
                }
            }

//            System.out.println(cur+" ");


        }

//        System.out.println("______");
        // 输出结果
        for (int i = 0; i < 4; i++) {
            System.out.print(curPage[i]+" ");
        }
        System.out.println();
        System.out.println(cur);
    }

    private static void Pages4_do(char[] ch,int pages){

        int cur = 1;
        for (int i = 0; i < ch.length; i++) {
            if(ch[i] == 'U'){
                cur -- ;
            }else if(ch[i] == 'D'){
                cur ++;
            }

            if(cur == 0){
                cur = pages;
            }else if(cur == pages+1){
                cur = 1;
            }

        }

        // 输出结果
        for (int i = 1; i <= pages; i++) {
            System.out.print(i+" ");
        }
        System.out.println();
        System.out.println(cur);


    }


}
