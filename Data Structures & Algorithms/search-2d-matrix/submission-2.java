class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int r = m*n;
        int l = 0;
        // System.out.println(m+ " "+ n +" " + r);
        while(l<r){
            int mid = l + (r-l)/2;
            // System.out.println(mid);
            // System.out.println(l+" "+r);
            int x = mid/n, y = mid%n;
            // System.out.println(mid+" "+x+ " "+y + " value:"+ matrix[x][y]);
            if(matrix[x][y]<target){
                l = mid + 1;
            }
            else if(matrix[x][y]>target){
                r = mid;
            }
            else{
                return true;
            }
        }
        return false;
    }
}
