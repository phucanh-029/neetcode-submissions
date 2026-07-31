class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = 0;
        for(int pile:piles)if(pile>=r)r=pile;
        int res = r;
        while(l<r){
            int mid = l+(r-l)/2;
            long sum = 0;
            for(int pile: piles){
                sum+=Math.ceil((double)pile/mid);
            }
            if(sum<=h){
                r=mid;
                res = r;
            }
            else l=mid+1;
        }
        return res;
    }
}
