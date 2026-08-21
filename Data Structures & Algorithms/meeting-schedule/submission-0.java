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
    public boolean canAttendMeetings(List<Interval> intervals) {
        int maxEnd = 0;
        Collections.sort(intervals,(a, b) -> a.start - b.start);
        for(int i = 0; i < intervals.size(); i++){
            if(intervals.get(i).start < maxEnd)return false;
            if(intervals.get(i).end > maxEnd){
                maxEnd = intervals.get(i).end;
            }
            
        }
        return true;
    }
}
