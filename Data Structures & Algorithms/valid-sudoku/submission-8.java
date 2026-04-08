class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> seen = new HashSet<>();

        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if(board[i][j] == '.') continue;

                String row = board[i][j]+" in row "+i;
                String col = board[i][j]+" in col "+j;
                String box = board[i][j]+" in box "+(i/3)+" and "+(j/3);
                
                if(seen.contains(row) || seen.contains(col) || seen.contains(box)) return false;

                seen.add(col);
                seen.add(row);
                seen.add(box);
            }
        }
        return true;
    }
}
