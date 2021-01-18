


import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Tencent_2018Spring_05 {


    static class node{
        int maxTime=0,grade=0;
    }
    static class nodeMachine extends node{}
    static class nodeTask  extends node{}


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){


            int n = sc.nextInt(); // 机器的数量
            int m = sc.nextInt(); // 任务的数量
            nodeMachine[] nodeMachines = new nodeMachine[n];
            nodeTask[] nodeTasks = new nodeTask[m];

            for (int i = 0; i < n; i++) {
                nodeMachines[i] = new nodeMachine();
                nodeMachines[i].maxTime = sc.nextInt();
                nodeMachines[i].grade = sc.nextInt();
            }

            for (int i = 0; i < m; i++) {
                nodeTasks[i] = new nodeTask();
                nodeTasks[i].maxTime = sc.nextInt();
                nodeTasks[i].grade = sc.nextInt();
            }

            Arrays.sort(nodeMachines, new Comparator<nodeMachine>() {
                @Override
                public int compare(nodeMachine A,nodeMachine B) {
                    if(A.maxTime == B.maxTime){
                        return A.grade - B.grade;
                    }
                    return A.maxTime - B.maxTime;
                }
            });

            Arrays.sort(nodeTasks, new Comparator<node>() {
                @Override
                public int compare(node A,node B) {
                    if(A.maxTime == B.maxTime){
                        return  B.grade - A.grade;
                    }
                    return B.maxTime - A.maxTime;
                }
            });

            int num = 0;
            long ans = 0;
            int[] cnt = new int[105];

            int i=0,j=0,k;
            // i是任务，j是机器
            // 遍历任务
            for ( ; i < nodeTasks.length; i++) {

                // 遍历机器
                while(j<nodeMachines.length && nodeMachines[j].maxTime >= nodeTasks[i].maxTime){
                    cnt[nodeMachines[j].grade]++;
                    j++;
                }

                for (k = nodeTasks[i].grade ; k <= 100 ; k++) {
                    if(cnt[k] != 0){
                        num++;
                        cnt[k] --;
                        ans = ans + 200 * nodeTasks[i].maxTime + 3* nodeTasks[i].grade;
                        break;
                    }
                }
            }

            System.out.println(num +" "+ans);



//            1 2
//            100 3
//            100 2
//            100 1

//            Out : 1 20006


        }



    }


}
