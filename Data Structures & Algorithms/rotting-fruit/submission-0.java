class Solution {

    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int fresh = 0;
        int time = 0;
        for(int r = 0; r < grid.length; r++){
            for(int c = 0; c < grid[0].length; c++){
                if(grid[r][c]==1)fresh++;
                if(grid[r][c]==2)q.offer(new int[]{r,c});
            }
        }
        while(fresh>0 && !q.isEmpty()){
            int length = q.size();
            for(int i = 0; i < length; i++){
                int[] cur = q.poll();
                for(int[] dir : directions){
                    int r = cur[0]+dir[0];
                    int c = cur[1]+dir[1];
                    if(r >=0  && r < grid.length && c >= 0 && c < grid[0].length && grid[r][c]==1){
                        grid[r][c]=2;
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
