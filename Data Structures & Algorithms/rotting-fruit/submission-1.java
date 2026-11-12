class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int fresh = 0,time = 0;
        for(int i = 0; i< grid.length; i++){
            for(int j = 0; j< grid[0].length; j++){
                if(grid[i][j]==1)fresh++;
                if(grid[i][j]==2)q.offer(new int[]{i,j});
            }
        }
        
        int directions[][] = new int[][]{{1,0}, {-1,0}, {0, 1}, {0, -1}};
        while(!q.isEmpty() && fresh >0){
            int len = q.size();
            for(int i = 0; i< len;i++){
                int[] curr= q.poll();
                for(int[] dir: directions){
                    int r = curr[0]+dir[0];
                    int c = curr[1]+dir[1];
                    if(r >= 0 && c >=0 && r <grid.length && c < grid[0].length && grid[r][c]==1){
                        grid[r][c] = 2;
                        q.offer(new int[]{r,c});
                        fresh--;
                    }
                }
            }
            
            time++;
        }
        return fresh == 0 ? time : -1;
    }
}
