class Solution {
    private static final int[][] directions = new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        int m = grid.length;
        int n = grid[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){

                    int area = dfs(grid,i,j);
                    if(area > max)max = area;
                }
            }
        }
        return max;
    }
    private int dfs(int[][] grid, int r, int c){
        if(r < 0 || c < 0 || r > grid.length - 1 || c > grid[0].length - 1 || grid[r][c] == 0) return 0;
        grid[r][c] = 0;
        int res = 1;
        for(int[] dir: directions){
            res+=dfs(grid,r + dir[0], c + dir[1]);
        }
        return res;
    }
    
}
