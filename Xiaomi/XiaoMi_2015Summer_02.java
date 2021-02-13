
public class XiaoMi_2015Summer_02 {

    public static void main(String[] args) {
        int[] nums = {3, 8, 5, 1, 7, 8};
        System.out.println(calculateMax(nums));
    }

    public static int calculateMax(int[] prices) {

        int max = 0;

        for (int i = 0; i < prices.length; i++) {

            int temp = helper(prices,0,i) + helper(prices,i,prices.length-1);
            max = Math.max(temp,max);
        }




        return max;

    }

    private static int helper(int[] prices ,int start,int end ){

        int max = 0;
        int min = prices[start];

        for (int i = start; i < end+1; i++) {
            max = Math.max(max,prices[i]-min);
            min = Math.min(min,prices[i]);
        }

        return max;

    }


}
