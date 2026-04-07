class Solution {
    public int matrixScore(int[][] grid) {
        //firstly checking all rows;
        int row = grid.length;
        for(int i=0; i<row;i++){
            if(grid[i][0]==0){
                for(int j=0;j<grid[i].length;j++){
                    grid[i][j] ^=1;
                }
            }
        }
        //checking all the colms
        for(int j=0; j<grid[0].length;j++){
            int zeroes = 0 , ones = 0;
            for(int i=0; i<row; i++ ){
                if(grid[i][j]==0) zeroes++;
                else ones++;
            }
            if(zeroes>ones){
                for(int k=0; k<row;k++){
                    grid[k][j] ^= 1;
                }
            }
        }
        int sum=0;
        for(int i=0; i<grid.length;i++){
            int a=0;
            StringBuilder str = new StringBuilder("");
            for(int j=0;j<grid[i].length; j++){
                str.append(grid[i][j]);
            }
            for(int k=0; k<str.length();k++){
                if(str.charAt(k)=='1'){
                    a+=(1<<(str.length()-k-1));
                }
            }
            sum+=a;
        }
        return sum;
    }
}