class Solution {
    public static final int[][] directions = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
    public int numIslands(char[][] grid) {
        int cnt = 0;
        int m = grid.length;
        int n = grid[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1'){
                    bfs(grid, i, j);
                    cnt++;
                }
            }
        }
        return cnt;
    }
    private void bfs(char grid[][], int r, int c){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{r,c});
        grid[r][c] = '0';
        while(!q.isEmpty()){
            int[] curr = q.poll();
            for(int[] direction : directions){
                int r1 = curr[0]+ direction[0], c1 = curr[1]+direction[1];
                if(r1 < 0 || c1 < 0 || r1 > grid.length - 1 || c1 > grid[0].length - 1|| grid[r1][c1]=='0'){
                    continue;
                }
                if(grid[r1][c1]=='1'){
                    grid[r1][c1] = '0';
                    q.add(new int[]{r1,c1});           
                }
            }
        }
    }

}
