class Solution {
    public boolean isValidSudoku(char[][] board) {

        // Map<String , Character> square = new HashMap<>();
        for(int i = 0;i<9;i++){
            Set<Character> landscape= new HashSet<>();
            for(int j = 0; j<9;j++){
                if(board[i][j]!='.'){
                    if(!landscape.contains(board[i][j])){
                        landscape.add(board[i][j]);
                    }
                    else{
                        return false;
                    }
                }
                
            }
        }
        for(int i = 0;i<9;i++){
            Set<Character> vertical= new HashSet<>();
            for(int j = 0; j<9;j++){
                if(board[j][i]!='.'){
                    if(!vertical.contains(board[j][i])){
                        vertical.add(board[j][i]);
                    }
                    else{
                        return false;
                    }
                }
                
            }
        }
        Map<Integer, Set<Character>> hm = new HashMap<>();
        for(int i = 0; i < 9;i++){
            for(int j = 0; j < 9; j++){
                int pos = (i/3)*3+j/3;
                hm.putIfAbsent(pos, new HashSet<>());
                if(board[i][j]!='.'){
                    if(!hm.get(pos).contains(board[i][j])){
                        hm.get(pos).add(board[i][j]);
                    }
                    else{
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
