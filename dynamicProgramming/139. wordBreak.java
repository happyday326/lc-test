class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n+1];
        dp[0] = true;
        for (int i=1; i<=n; i++) {
            dp[i] = false;
            for (int j=0; j<i; j++) {
                String currentStr = s.substring(0, i);
                if (dp[j] && inDict(currentStr.substring(j), wordDict)) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }

    private boolean inDict(String subStr, List<String> wordDict) {
        for (String word: wordDict) {
            if (subStr.equals(word)) {
                return true;
            }
        }
        return false;
    }
}