class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (a,b) -> {
            if(a[0] == b[0]) return a[1]-b[1];
            return a[0]-b[0];
        });
        Stack<int[]> stck = new Stack<>();
        stck.push(intervals[0]);
        for(int i=1;i<n;i++){
            int[] temp = stck.peek();
            if(temp[1]>=intervals[i][0] && !stck.isEmpty()) {
                temp = stck.pop();
                int start = Math.min(temp[0], intervals[i][0]);
                int end = Math.max(temp[1], intervals[i][1]);
                stck.push(new int[]{start,end});
            } else stck.push(intervals[i]);
        }
        int k = stck.size();
        int[][] ans = new int[k][2];
        for(int i=0;i<k;i++) {
            ans[i] = stck.pop();
        }
        return ans;
    }
}
