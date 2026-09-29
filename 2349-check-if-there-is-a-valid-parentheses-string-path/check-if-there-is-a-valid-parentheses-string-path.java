class Solution {
    public boolean hasValidPath(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        if((n + m - 1) % 2 != 0){
            return false;
        }
        boolean[][][] dp = new boolean[n][m][n+m];

        if(grid[0][0] == '('){
            dp[0][0][1] = true;
        }
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                for(int k = 0; k<n+m; k++){
                    if(!dp[i][j][k]){
                        continue;
                    }
                    //down
                    if(i+1 < n){
                        int newK = k + (grid[i+1][j] == '(' ? 1 : -1);
                        if(newK >= 0){
                            dp[i+1][j][newK] = true;
                        }
                    }
                    //right
                    if(j+1 < m){
                        int newK = k + (grid[i][j+1] == '(' ? 1 : -1);
                        if(newK >= 0){
                            dp[i][j+1][newK] = true;
                        }
                    }
                    
                }
            }
        }
        return dp[n-1][m-1][0];
    }
}