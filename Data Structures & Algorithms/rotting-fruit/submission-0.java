class Solution {
    class Orange {
        int x;
        int y;
        int level;
        public Orange(int x,int y, int level) {
            this.x = x;
            this.y = y;
            this.level = level;
        }
    }
    public int orangesRotting(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        boolean [][] visited = new boolean[n][m];
        int countFresh = 0, maxLevel = 0;
        Queue<Orange> q = new LinkedList<>();
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(grid[i][j] == 2) q.add(new Orange(i,j,0));
                if(grid[i][j] == 1) countFresh++;
            }
        }
        int[] dx = {-1,0,0,1};
        int[] dy = {0,-1,1,0};
        while(!q.isEmpty()) {
            Orange curr = q.poll();
            maxLevel = Math.max(maxLevel, curr.level);
            for(int k=0;k<4;k++) {
                int x = curr.x+dx[k];
                int y = curr.y+dy[k];
                if(x>=0 && x<n && y>=0 && y<m && !visited[x][y] && grid[x][y] == 1) {
                    q.add(new Orange(x,y, curr.level+1));
                    visited[x][y] = true;
                    countFresh--;
                }
            }
        }
        return (countFresh == 0) ? maxLevel : -1;
    }
}
