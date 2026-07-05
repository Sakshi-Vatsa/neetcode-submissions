class Solution {
    public int getDistanceFromOrigin(int a, int b) {
        return a*a + b*b;
    }
    public int[][] kClosest(int[][] points, int k) {
        int n = points.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> getDistanceFromOrigin(b[0],b[1]) - getDistanceFromOrigin(a[0], a[1]));
        for(int i=0;i<n;i++) {          
            pq.add(points[i]);
            if(pq.size()>k) {
                pq.poll();
            }
        }
        int[][] ans = new int[k][2];
        for(int i=0;i<k;i++) {
            ans[i] = pq.poll();
        }
        return ans;
    }
}
