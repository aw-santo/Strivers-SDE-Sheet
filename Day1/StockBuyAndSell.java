package Day1;

public class StockBuyAndSell {
    public static void main(String[] args) {
        int arr[] = {7,1,5,3,6,4};
        int maxPro = maxProfit1(arr);
        System.out.println("Max profit is: " + maxPro);
    }

    static int maxProfit(int[] prices) {
        int max = 0;

        for (int i = 0; i < prices.length; i++) {
            for (int j = i+1; j < prices.length; j++) {
                if (prices[j] > prices[i]) {
                    max = Math.max(max, prices[j]-prices[i]);
                }
            }
        }
        return max;
    }

    static int maxProfit1(int[] prices) {
        int min = Integer.MAX_VALUE;
        int pro = 0;

        for (int i = 0; i < prices.length; i++) {
            min = Math.min(prices[i], min);
            pro = Math.max(pro, prices[i] - min);
        }

        return pro;
    }
}
