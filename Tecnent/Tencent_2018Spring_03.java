

import java.util.Scanner;

public class Tencent_2018Spring_03 {

    private static boolean flag ;
    private static int M ;

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);

        while(sc.hasNext()){
            int N = sc.nextInt();
            // 巧克力数量
            int M = sc.nextInt();

            int low = 1;
            int high = M;
            boolean flag = false;

            while(low<high){

                // 向上取整是必须的
                int mid=(low+high+1)/2;
                int total = sum(mid,N);
                if(total > M){
                    high = mid-1;

                }else if(total == M){
                    System.out.println(mid);
                    flag = true;
                    break;
                }else{
                    low = mid;
                }


            }

            if(flag != true){
                System.out.println(high);
            }








        }
    }

    // s是第一天的巧克力数量
    private static int sum(int s,int N){

        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += s;
            s = (s+1)/2;// 可以有效的向上取整，最后一直是1

        }

        return sum;

    }

    // 可以通过，但是二分法更好
    private static void mainMine(){

        Scanner sc = new Scanner(System.in);

        while(sc.hasNext()){

            int N = sc.nextInt();
            // 巧克力数量
            int M = sc.nextInt();
            boolean flag = false;

            if(N ==1){
                System.out.println(M);
                break;
            }


            for (int i = M-N; i >= 0 ; i--) {

                int total = 0;
                int today = i;
                int day = 0;
                for ( ; day < N; day++) {

                    if(today == 1 ){
                        flag = true;
                        break;
                    }


                    total += today;
                    if(total > M){

                        break;
                    }


                    if(today % 2 !=0){
                        today = today/2 +1;
                    }else {
                        today /= 2;
                    }




                }

                System.out.println(i+" "+day+" "+total);
                if(flag == true && M-total >= N-day){
                    flag = false;
                    System.out.println(i);
                    break;
                }

                if(day == N){

                    System.out.println(i);
                    break;
                }



            }







        }



    }



}
