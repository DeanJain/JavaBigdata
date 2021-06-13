package programs.problems;

public class BestBuySellStock {

    public static void main(String[] args) {
        int[] input = {2,4,1};
        System.out.println(getMaxProfit(input));
    }
    // TODO: Incomplete
    static int getMaxProfit(int[] prices){
            int buy = 0;
            int total = 0;
            if(prices.length < 2)
                return 0;
            else if (prices.length == 2) {
                if (prices[0] > prices[1])
                    return 0;
                else
                    return prices[1] - prices[0];
            }

        for (int i = 0; i < prices.length-1; i++) {
            // buy logic
            System.out.println("stock = " + prices[i]);
            if (buy == 0 && prices.length - 2 > i ) {
                if(prices[i] < prices[i+1] && prices[i] < prices[i+2]) {
                    buy = prices[i];
                    System.out.println("bought = " + prices[i]);
                }
            }else if(buy == 0 && prices[i] < prices[i+1] ){
                buy = prices[i];
                System.out.println("bought = " + prices[i]);
            }
            // sell logic
            else if(buy > 0 && prices[i] > buy && prices[i] > prices[i+1] ) {
                total = total + prices[i] - buy;
                System.out.println("sold = "+ prices[i]);
                buy = 0;
            }
            System.out.println("total = "+ total);
        }
        if (buy>0){
            total = total + prices[prices.length-1] - buy;
            System.out.println("sold = "+ prices[prices.length-1]);
        }
        return total;
    }
}
