class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                // if(board[i][j]!=word.charAt(i))continue;
                if(backtrack(board, word, i, j, 0)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean backtrack(char[][] board, String word, int r, int c, int pos){
        if(pos == word.length()) return true;
        if( r < 0 || c < 0 || r > board.length-1 || c > board[0].length-1 || board[r][c] != word.charAt(pos)){
            return false;
        }
        board[r][c] = '#';
        boolean check = backtrack(board,word,r,c+1,pos+1) || backtrack(board,word,r+1,c,pos+1) || backtrack(board,word,r-1,c,pos+1) || backtrack(board,word,r,c-1,pos+1);
        board[r][c] = word.charAt(pos);
        return check;
    }
}
