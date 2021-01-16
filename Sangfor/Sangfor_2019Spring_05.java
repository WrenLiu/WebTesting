
import java.util.*;

/**
 *
10
8 10
2 3
11 20
9 11
9 12
6 5
25 28
3 4
33 34
3 10


 2 20
 25 28
 33 34


 */
public class Sangfor_2019Spring_05 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] num = new int[n][2];
        for(int i = 0; i < n; ++i){
            num[i][0] = sc.nextInt();
            num[i][1] = sc.nextInt();
        }

        // 重新对区间进行排序，begin小的就是真小，相同begin则比较end的大小
        Arrays.sort(num, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0]==o2[0]) return o1[1]-o2[1];
                return o1[0]-o2[0];
            }
        });


        int start = num[0][0];
        int end = num[0][1];
        // 时刻更新start 和 end
        // 相当于begin的位置已经排好序了，num[0][0]就是最小的数，循环就是为了找一样的区间和扩充原有区间的end边界
        for(int i = 1; i < n; ++i){
            // 扩充边界
            if(num[i][0] <= end){
                end = Math.max(end, num[i][1]);
            }
            else{
                // 找到新的区间
                System.out.println("" + start + " " + end);
                start = num[i][0];
                end = num[i][1];
            }
        }
        System.out.println("" + start + " " + end);
    }
}