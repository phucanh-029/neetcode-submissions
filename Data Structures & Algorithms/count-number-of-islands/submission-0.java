class Solution {
    private static final int[][] direction = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
    public int numIslands(char[][] grid) {
        int cnt = 0;
        int m = grid.length;
        int n = grid[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1'){
                    dfs(grid, i, j);
                    cnt++;
                }
            }
        }
        return cnt;
    }
    private void dfs(char[][] grid, int r, int c){
        if(r < 0 || c < 0 || r > grid.length-1 || c > grid[0].length - 1 || grid[r][c]=='0'){
            return;
        }
        grid[r][c] = '0';// mark as zero to avoid next count
        for(int[] dir: direction){
            dfs(grid,r+dir[0],c+dir[1]);
        }
    }
}
