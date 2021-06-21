package programs.problems;

public class BestBuySellStock {

    public static void main(String[] args) {
        int[] input = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(input));
    }
    public static int maxProfit(int prices[]) {
        int minprice = prices[0];
        int maxprofit = 0;
        for (int i = 1; i < prices.length; i++) {
                minprice = Math.min(prices[i],minprice);
                maxprofit = Math.max(maxprofit, prices[i] - minprice);
        }
        return maxprofit;
    }
}
