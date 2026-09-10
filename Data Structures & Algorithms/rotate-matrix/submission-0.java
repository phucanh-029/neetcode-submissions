class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int[][] rotated = new int[n][n];
        for(int i = 0; i< n;i++){
            for(int j = 0; j < n; j++){
                rotated[j][n-1-i] = matrix[i][j];
                // System.out.println(rotated[j][n-i-1]);
                
            }
        }
        for(int i = 0; i< n;i++){
            for(int j = 0; j < n; j++){
                matrix[i][j] = rotated[i][j];
                
            }
        }
    }
}


/*
0,0 -> 0,2
0,1 -> 1,2
0,2 -> 2,2
1,0 -> 0,1
1,1 -> 1,1
1,2 -> 2,1
2,0 -> 0,0
2,1 -> 1,0
2,2 -> 2,0 
*/
