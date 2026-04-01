class Solution {
    public boolean isValid(char[][] board, int row, int col, int num){
        for(int i = 0; i<9; i++){
            if(board[i][col]==num) return false;
        }
        for(int j=0; j<9; j++){
            if(board[row][j]==num) return false;
        }

        int sR = (row/3)*3;
        int sC = (col/3)*3;
        for(int i=sR; i<sR+3; i++){
            for(int j=sC; j<sC+3; j++){
                if(board[i][j]==num) return false;
            }
        }
        return true;
    }
    public void solve(char[][] board, int row, int col,char[][] grid){
        if(row==9){
            for(int i=0; i<9; i++){
                for(int j =0; j<9; j++){
                    grid[i][j]=board[i][j];
                }
            }
            return;
        }
        else if(board[row][col]!='.'){
            if(col==8) solve(board,row+1,0,grid);
            else solve(board,row,col+1,grid);
        }
        else{
            for(char i='1'; i<='9'; i++){
                if(isValid(board,row,col,i)==true){
                    board[row][col] = i;
                    if(col==8) solve(board,row+1,0,grid);
                    else solve(board,row,col+1,grid);
                    board[row][col]='.';
                }
            }
        }
    }
    public void solveSudoku(char[][] board) {
        char[][] grid = new char[9][9];
        solve(board,0,0,grid);
        for(int i =0;i<9;i++){
            for(int j=0;j<9;j++){
                board[i][j]=grid[i][j];
            }
        }
    }
}