class Solution {
    public boolean isValid(char[][] board, int i , int j, int num){
        for(int r=0; r<9;r++){
            if(board[r][j] == num) return false;
        }
        for(int c=0; c<9; c++){
            if(board[i][c] == num) return false;
        }
        
        int startR = (i/3)*3;
        int endR = startR+2;
        int startC = (j/3)*3;
        int endC = startC+2;

        for(int r=startR; r<=endR; r++){
            for(int c=startC; c<=endC; c++){
                if(board[r][c]==num) return false;
            }
        }
        return true;
    }
    public boolean isValidSudoku(char[][] board) {
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                char num = board[i][j];
                if(num == '.') continue;
                board[i][j] = '.';
                if(isValid(board,i,j,num)==false) return false;
                board[i][j] = num;
            }
        }
        return true;
    }
}