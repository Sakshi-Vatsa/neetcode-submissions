class Solution {
    public int bfs(int i, int j, int n, int m, char[][] grid, boolean[][] visited) {
        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{i,j});
        visited[i][j] = true;
        int[] dx = {-1, 0, 0, 1};
        int[] dy = {0, -1, 1, 0};
        while(!q.isEmpty()) {
            int[] curr = q.poll();
            for(int k=0;k<4;k++) {
                int x = curr[0] + dx[k];
                int y = curr[1] + dy[k];
                if(x>=0 && x<n && y>=0 && y<m && !visited[x][y] && grid[x][y] == '1') {
                    visited[x][y] = true;
                    q.add(new int[]{x,y});
                }
            }
        }
        return 1;
    }
    public int numIslands(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int cnt=0;
        boolean[][] visited = new boolean[n][m];
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(!visited[i][j] && grid[i][j] == '1') cnt+=bfs(i,j,n,m,grid,visited);
            }
        }
        return cnt;
    }
}
