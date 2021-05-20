//timeout but should be okay: Brute force
//class Solution {
//    public int maxProfit(int[] prices) {
//        int profit = 0;
//        for (int i=0; i<prices.length; i++) {
//            for (int j=i; j<prices.length; j++) {
//                if (prices[j]-prices[i] > profit) {
//                    profit = prices[j]-prices[i];
//                }
//            }
//        }
//        return profit;
//    }
//}

// One way
class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int minPrice = Integer.MAX_VALUE;
        for (int i=0; i<prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else if (prices[i]-minPrice > profit) {
                profit = prices[i] - minPrice;
            }
        }
        return profit;
    }
}





//Input: prices = [7,1,5,3,6,4]
//Output: 5