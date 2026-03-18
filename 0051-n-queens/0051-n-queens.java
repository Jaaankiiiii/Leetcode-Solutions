class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                board[i][j] = '.';
            }
        }
        nqueen(board,0,n,ans);
        return ans;
    }
    public static void nqueen(char[][] board, int row, int n, List<List<String>> ans){
        if(row==n){
            List<String> a = new ArrayList<>();
            for(int i=0; i<n; i++){
                StringBuilder s = new StringBuilder("");
                for(int j=0; j<n; j++){
                    s.append(board[i][j]);
                }
                String str = s.toString();
                a.add(str);
            }
            ans.add(a);
        }
        for(int j=0; j<n; j++){
            if(isSafe(board,row,j,n)){
                board[row][j] = 'Q';
                nqueen(board,row+1,n,ans);
                board[row][j] = '.';
            }
        }
    }

    public static boolean isSafe(char[][] board, int row, int col,int n){
        for(int i=0; i<n; i++){
            if(board[i][col]=='Q'){
                return false;
            }
        }
        for(int j=0; j<n; j++){
            if(board[row][j]=='Q'){
                return false;
            }
        }

        int i=row;
        int j=col;
        while(i>=0 && j>=0){
            if(board[i][j]=='Q') return false;
            i--;
            j--;
        }

        i=row;
        j=col;
        while(i<n && j<n){
            if(board[i][j]=='Q') return false;
            i++;
            j++;
        }

        i=row;
        j=col;
        while(i>=0 && j<n){
            if(board[i][j]=='Q') return false;
            i--;
            j++;
        }

        i=row;
        j=col;
        while(i<n && j>=0){
            if(board[i][j]=='Q') return false;
            i++;
            j--;
        }
        return true;
    }
}