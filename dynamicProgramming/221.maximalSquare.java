class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] res = new int[m][n];
        int max = 0;
        for (int i=0; i<m; i++) {
            if (String.valueOf(matrix[i][0]).equals("1")) {
                res[i][0] = 1;
                max = 1;
            }
        }
        for (int i=0; i<n; i++) {
            if (String.valueOf(matrix[0][i]).equals("1")){
                res[0][i] = 1;
                max = 1;
            }
        }
        for (int i=1; i<m; i++) {
            for (int j=1; j<n; j++) {
                if (String.valueOf(matrix[i][j]).equals("0")) {
                    res[i][j] = 0;
                } else {
                    if (res[i-1][j-1]==0 ||
                            res[i-1][j]==0 ||
                            res[i][j-1]==0) {
                        res[i][j] = 1;
                    } else if (res[i-1][j-1]==res[i-1][j] && res[i-1][j]==res[i][j-1]) {
                        res[i][j] = (int)Math.pow(Math.sqrt(res[i-1][j-1])+1, 2);
                    } else {
                        int min = Math.min(res[i-1][j-1], Math.min(res[i-1][j], res[i][j-1]));
                        res[i][j] = (int)Math.pow(Math.sqrt(min)+1, 2);
                    }
                }
                if (res[i][j] > max) {
                    max = res[i][j];
                }
            }
        }
        return max;
    }
}


