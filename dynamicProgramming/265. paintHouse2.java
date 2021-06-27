class Solution {
    public int minCostII(int[][] costs) {
        int n = costs.length;
        int k = costs[0].length;
        for (int i=1; i<n; i++) {
            for (int j=0; j<k; j++) {
                if (j==0) {
                    costs[i][j] += getMinCost(Arrays.copyOfRange(costs[i-1], 1, k));
                } else if (j==k-1) {
                    costs[i][j] += getMinCost(Arrays.copyOfRange(costs[i-1], 0, k-1));
                } else {
                    costs[i][j] += Math.min(getMinCost(Arrays.copyOfRange(costs[i-1], 0, j)),
                            getMinCost(Arrays.copyOfRange(costs[i-1], j+1, k))
                    );
                }
            }
        }
        return getMinCost(costs[n-1]);
    }

    public int getMinCost(int[] costs) {
        int min = Integer.MAX_VALUE;
        for (int i=0; i<costs.length; i++) {
            if (costs[i] < min) {
                min = costs[i];
            }
        }
        return min;
    }
}