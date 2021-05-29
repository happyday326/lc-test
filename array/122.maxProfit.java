//应该是对的但是timeout
//class Solution {
//    public int maxProfit(int[] prices) {
//        int maxProfit = 0;
//        int n = prices.length;
//        Map<Integer, Integer> map = new HashMap<>();
//        int profit = 0;
//        for (int i=0; i<n; i++) {
//            if (i != 0) {profit = map.get(i-1);}
//            for (int j=0; j<i; j++) {
//                if (prices[i]-prices[j] >= 0 && map.get(j)+prices[i]-prices[j]>=profit) {
//                    profit = map.get(j)+prices[i]-prices[j];
//                }  else {
//                    profit = map.get(j);
//                }
//            }
//            map.put(i, profit);
//        }
//        for (int k = 0; k<n; k++) {
//            if (map.get(k) > maxProfit) {maxProfit = map.get(k);}
//        }
//        return maxProfit;
//    }
//}

class Solution {
    public int maxProfit(int[] prices) {
        int i = 0;
        int valley = prices[0];
        int peak = prices[0];
        int maxProfit = 0;
        while (i < prices.length-1) {
            while (i < prices.length-1 && prices[i] >= prices[i+1])
                i++;
            valley = prices[i];
            while (i < prices.length-1 && prices[i] < prices[i+1])
                i++;
            peak = prices[i];
            maxProfit += peak-valley;
        }
        return maxProfit;
    }
}