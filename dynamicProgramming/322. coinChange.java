class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        if (amount==0) {
            return 0;
        }
        for (Integer coin: coins) {
            if (coin <= amount) {
                dp[coin] = 1;
            }
        }
        for (int i=1; i<=amount; i++) {
            for (int j=0; j<coins.length; j++) {
                if (coins[j]<=i && dp[i - coins[j]]!=-1) {
                    if (dp[i] == -1) {
                        dp[i] = dp[i - coins[j]]+1;
                    } else {
                        dp[i] = Math.min(dp[i], dp[i - coins[j]]+1);
                    }

                }
            }
        }
        return dp[amount];
    }
}