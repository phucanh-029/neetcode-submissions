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
        TreeMap<Integer,Integer> tm = new TreeMap<>();
        for(Interval i : intervals){
            tm.put(i.start, tm.getOrDefault(i.start,0)+1);
            tm.put(i.end, tm.getOrDefault(i.end,0)-1);
        }
        int prev = 0;
        int res = 0;
        for(Integer key : tm.keySet()){
            prev+=tm.get(key);
            res = Math.max(res,prev);
        }
        System.out.print(tm);
        return res;
    }
}
