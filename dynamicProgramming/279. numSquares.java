class Solution {
    public int numSquares(int n) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i=2; i<=n; i++) {
            int res = i;
            if (isPerfectSquare(i)) {
                dp[i] = 1;
            } else {
                for (int j=i-1; j>=1; j--) {
                    int value = dp[j] + dp[i-j];
                    res = Math.min(value, res);
                }
                dp[i] = res;
            }
        }
        return dp[n];
    }

    private boolean isPerfectSquare(int n) {
        double a = Math.sqrt(n);
        int b = (int) a;
        return a-b == 0;
    }
}