class Solution {
    private static final int empty = Integer.MAX_VALUE;
    private static final int gate = 0;
    private static final List<int[]> directions = Arrays.asList(
            new int[]{1,0},
            new int[]{-1,0},
            new int[]{0,1},
            new int[]{0,-1}
    );


    public void wallsAndGates(int[][] rooms) {
        int row = rooms.length;
        int col = rooms[0].length;
        Queue<int[]> queue = new LinkedList<>();
        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                if (rooms[i][j]==gate) {
                    queue.add(new int[]{i,j});
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            int r = point[0];
            int c = point[1];
            for (int[] dir: directions) {
                int rr = r+dir[0];
                int cc = c+dir[1];
                if (rr<0 || cc<0 || rr>=row || cc>=col || rooms[rr][cc]!=empty) {
                    continue;
                }
                rooms[rr][cc] = rooms[r][c]+1;
                queue.add(new int[]{rr,cc});
            }
        }
    }
}