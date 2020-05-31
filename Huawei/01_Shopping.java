import java.util.*;
//  https://www.nowcoder.com/ta/huawei  
//  购物单- 背包问题
public class Main {
    static class Good {
        int v;
        int vp;
        public Good(int v, int vp) {
            this.v = v;
            this.vp = vp;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int total = sc.nextInt();
        int num = sc.nextInt();

        int[] f = new int[total+1];

        Good[][] goods = new Good[60][4];

        for (int i = 1; i <= num ; i++) {

            int v = sc.nextInt();
            int p = sc.nextInt();
            int q = sc.nextInt();

            Good t = new Good(v,v*p);
            if(q ==0 ){
                goods[i][0] = t;
            }
            else{
                if(goods[q][1] == null){
                    goods[q][1] = t;
                }
                else{
                    goods[q][2] = t;
                }
            }

        }


        // f[] 数组存放的是不同的价格下可以得到的value值
        for (int i = 1; i <= num; i++) {

            for(int j = total ;j>=0 && goods[i][0] != null;j--){
                Good master = goods[i][0];

                int max = f[j];

                // 如果当前剩余的钱大于主件价格 且 当前f[j]小于之前方案的f[j]
                // 那么就尝试将 f[j] 变为当前方案的f[j]
                if (j >= master.v && max < f[j - master.v] + master.vp) {
                    max = f[j - master.v] + master.vp;
                }

                int vt;

                // 如果当前主件有附件1
                if (goods[i][1] != null) {

                    // 当前剩余金额大于 主件加附件1 的总额
                    if (j >= (vt = master.v + goods[i][1].v)
                            // 且 当前价值--f[j] 小于之前方案的价值--f[j]
                            && max <  f[j - vt] + master.vp + goods[i][1].vp) {
                        // 则 选用 主件加附件1 的价值
                        max = f[j - vt] + master.vp + goods[i][1].vp;
                    }
                }



                if (goods[i][2] != null) {
                    if (j >= (vt = master.v + goods[i][2].v)
                            && max < f[j - vt] + master.vp  + goods[i][2].vp) {
                        max = f[j - vt] + master.vp + goods[i][2].vp;
                    }

                    if (j >= (vt = master.v + goods[i][1].v + goods[i][2].v)
                            && max < f[j - vt] + master.vp + goods[i][1].vp + goods[i][2].vp) {
                        max = f[j - vt] + master.vp + goods[i][1].vp + goods[i][2].vp;
                    }
                }

                f[j] = max;

            }

        }


        System.out.println(f[total]);

    }
}
