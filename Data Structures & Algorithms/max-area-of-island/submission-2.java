class Solution {
    private static final int[][] directions = new int[][]{{0,1},{0,-1},{-1,0},{1,0}};
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                max = Math.max(max, dfs(grid, i, j));
            }
        }
        return max;
    }
    private int dfs(int[][] grid,int r, int c){
        if(r < 0 || c < 0 || r > grid.length - 1 || c > grid[0].length - 1 || grid[r][c] == 0){
            return 0;
        }
        grid[r][c] = 0;
        int res = 1;
        for(int[] dir : directions){
            res+=dfs(grid, r + dir[0], c + dir[1]);
        }
        return res;
    }
}
