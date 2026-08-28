class Solution {
    private int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;
        boolean[][] pac = new boolean[rows][cols];
        boolean[][] atl = new boolean[rows][cols];
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < cols;i++){
            dfs(0,i, pac, heights);
            dfs(rows-1,i, atl, heights);
        }
        for(int i = 0; i < rows;i++){
            dfs(i,0, pac, heights);
            dfs(i,cols-1, atl, heights);
        }
        for(int r = 0; r < rows; r++){
            for(int c = 0; c < cols; c++){
                if(pac[r][c] && atl[r][c]){
                    res.add(Arrays.asList(r,c));
                }
            }
        }
        return res;
    }
    
    private void dfs(int r, int c, boolean[][] ocean, int[][] heights){
        ocean[r][c] = true;
        for(int[] dir : directions){
            int nr = r + dir[0], nc = c + dir[1];
            if(nr >= 0 && nc >= 0 && nr <= heights.length - 1 && nc <= heights[0].length - 1 && !ocean[nr][nc] && heights[r][c] <= heights[nr][nc]){
                dfs(nr,nc,ocean,heights);
            }
        }
        
    }
}
