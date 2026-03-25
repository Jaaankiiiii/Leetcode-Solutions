class Solution {
    public boolean checkValidGrid(int[][] grid) {
        if(grid[0][0] != 0) return false;
        return helper(grid,0,0,0);
    }
    public boolean helper(int[][] grid, int row, int col, int num){
        int n = grid.length;
        if(grid[row][col]==n*n-1) return true;
        int i = row;
        int j = col;

        //down right/left
        if((i+2 < n && j+1 < n) && grid[i+2][j+1] == num+1 ){
            return helper(grid,i+2,j+1,num+1);
        }

        else if((i+2 < n && j-1 >=0) && grid[i+2][j-1] == num+1 ){
            return helper(grid,i+2,j-1,num+1);
        }
        
        //up right/left
        else if((i-2 >=0 && j+1 < n) && grid[i-2][j+1] == num+1 ){
            return helper(grid,i-2,j+1,num+1);
        }
        else if((i-2 >=0 && j-1 >=0) && grid[i-2][j-1] == num+1 ){
            return helper(grid,i-2,j-1,num+1);
        }
        //right up/down
        else if((j+2 < n && i-1 >=0) && grid[i-1][j+2] == num+1 ){
            return helper(grid,i-1,j+2,num+1);
        }
        else if((j+2 < n && i+1 < n) && grid[i+1][j+2] == num+1 ){
            return helper(grid,i+1,j+2,num+1);
        }

        //left up/down
        else if((j-2 >= 0 && i-1 >=0) && grid[i-1][j-2] == num+1 ){
            return helper(grid,i-1,j-2,num+1);
        }
        else if((j-2 >= 0 && i+1 < n) && grid[i+1][j-2] == num+1 ){
            return helper(grid,i+1,j-2,num+1);
        }
        return false;

    }
}