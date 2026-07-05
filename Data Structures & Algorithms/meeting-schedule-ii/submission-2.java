/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        Collections.sort(intervals, (a,b) -> a.start-b.start);
        int n=intervals.size();
        PriorityQueue<Interval> pq = new PriorityQueue<>((a,b) -> a.end-b.end);
        int maxMeetingRooms = 0;
        for(int i=0;i<n;i++) {
            while(!pq.isEmpty() && pq.peek().end <= intervals.get(i).start) {
                pq.poll();
            }
            pq.add(intervals.get(i));
            maxMeetingRooms = Math.max(maxMeetingRooms,pq.size());
        }
        return maxMeetingRooms;
    }
}
