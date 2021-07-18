class Solution {
    private int rowNum;
    private int colNum;

    public void solve(char[][] board) {
        this.rowNum = board.length;
        this.colNum = board[0].length;
        List<Pair<Integer, Integer>> borders = new LinkedList<Pair<Integer, Integer>>();
        //1. Construct list of borders
        for (int r=0; r<this.rowNum; r++) {
            borders.add(new Pair(r, 0));
            borders.add(new Pair(r, this.colNum-1));
        }
        for (int c=0; c<this.colNum; c++) {
            borders.add(new Pair(0, c));
            borders.add(new Pair(this.rowNum-1, c));
        }

        //2. mark the escaped cells
        for (Pair<Integer, Integer> pair: borders) {
            this.BFS(board, pair.first, pair.second);
        }

        //3. flip the cells to their correct final states
        for (int r=0; r<this.rowNum; r++) {
            for (int c=0; c<this.colNum; c++) {
                if (board[r][c] == 'O'){
                    board[r][c] = 'X';
                }
                if (board[r][c] == 'E') {
                    board[r][c] = 'O';
                }
            }
        }
    }

    protected void BFS(char[][] board, int r, int c) {
        LinkedList<Pair<Integer, Integer>> queue = new LinkedList<Pair<Integer, Integer>>();
        queue.offer(new Pair<>(r, c));

        while (!queue.isEmpty()) {
            Pair<Integer, Integer> pair = queue.poll();
            int row = pair.first, col = pair.second;
            if (board[row][col] != 'O') {
                continue;
            }
            board[row][col] = 'E';
            if (col < this.colNum-1) {
                queue.offer(new Pair<>(row, col+1));
            }
            if (col > 0) {
                queue.offer(new Pair<>(row, col-1));
            }
            if (row < this.rowNum-1) {
                queue.offer(new Pair<>(row+1, col));
            }
            if (row > 0) {
                queue.offer(new Pair<>(row-1, col));
            }
        }
    }
}

class Pair<U, V> {
    public U first;
    public V second;

    public Pair(U first, V second) {
        this.first = first;
        this.second = second;
    }
}