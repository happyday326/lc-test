//应该是对的但是timeout
class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int n = prices.length;
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        map2.put(0,0);
        int profit = 0;
        for (int i=0; i<n; i++) {
            if (i != 0) {profit = map.get(i-1);}
            for (int j=0; j<i; j++) {
                if (prices[i]-prices[j] >= 0 && map.get(j)+prices[i]-prices[j]>=profit && map2.get(j)<=1) {
                    profit = map.get(j)+prices[i]-prices[j];
                    map2.put(i, map2.get(j)+1);
                }  else {
                    profit = map.get(j);
                    map2.put(i, map2.get(j));
                }
            }
            map.put(i, profit);
        }
        for (int k = 0; k<n; k++) {
            if (map.get(k) > maxProfit) {maxProfit = map.get(k);}
        }
        return maxProfit;
    }
}