class Solution {
    public int numIslands(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        if (row==0 && col==0) {
            return 0;
        }
        int numIsland = 0;
        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                if (grid[i][j] == '1') {
                    numIsland++;
                    grid[i][j] = '0';
                    Queue<Integer> neighbors = new LinkedList<>();
                    neighbors.add(i*col+j);
                    while (!neighbors.isEmpty()) {
                        int id = neighbors.remove();
                        int r = id/col;
                        int c = id%col;
                        if (r-1>=0 && grid[r-1][c]=='1') {
                            grid[r-1][c] = '0';
                            neighbors.add((r-1)*col+c);
                        }
                        if (r+1<row && grid[r+1][c]=='1') {
                            grid[r+1][c] = '0';
                            neighbors.add((r+1)*col+c);
                        }
                        if (c-1>=0 && grid[r][c-1]=='1') {
                            grid[r][c-1] = '0';
                            neighbors.add(r*col+c-1);
                        }
                        if (c+1<col && grid[r][c+1]=='1') {
                            grid[r][c+1] = '0';
                            neighbors.add(r*col+c+1);
                        }
                    }
                }
            }
        }
        return numIsland;
    }
}