class RegionCutBySlashes {
    public int regionsBySlashes(String[] grid) {
        int col = grid.length;
        int row = grid[0].length();
        
        int[][] mat = new int[col*3][row*3];
        for (int i=0;i<grid.length;i++)
        {
            for (int j=0;j<grid[0].length();j++)
            {
                if (grid[i].charAt(j)=='\\')
                {
                    mat[i*3][j*3] = 1;
                    mat[i*3+1][j*3+1] = 1;
                    mat[i*3+2][j*3+2] = 1;
                }
                else if (grid[i].charAt(j)=='/')
                {
                    mat[i*3+2][j*3] = 1;
                    mat[i*3+1][j*3+1] = 1;
                    mat[i*3][j*3+2] = 1;
                }
            }
        }
        int reg = 0;
        for (int i=0;i<mat.length;i++)
        {
            for (int j=0;j<mat[0].length;j++)
            {
                if (mat[i][j]==0)
                {
                    dfs(mat,i,j);
                    reg++;
                }
            }
        }
        return reg;
    }
    public void dfs(int[][] g, int i, int j){
        int n = g.length, m = g[0].length;
        if(i<0 || i>=n || j<0 || j>=m || g[i][j]==1) return;
        g[i][j]=1;
        int d[] = {0,-1,0,1,0};
        for(int k=0;k<4;k++){
            dfs(g,i+d[k],j+d[k+1]);
        }
    }
}