class Solution {
    private static final int[][] directions = new int[][]{{-1,0},{0,-1},{1,0},{0,1}};
    public void islandsAndTreasure(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j]==0)q.add(new int[]{i,j});
            }
        }
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];
            for(int[] dir : directions){
                int row = r + dir[0];
                int col = c + dir[1];
                if(row < 0 || col < 0 || row >= m || col >= n || grid[row][col]!=Integer.MAX_VALUE){
                    continue;
                }
                grid[row][col] = grid[r][c] + 1;
                q.add(new int[]{row,col});
            }
        }
    }

}
