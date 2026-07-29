class Solution {
    public int trap(int[] height) {
        int res = 0;
        int l = 0,r = height.length -1;
        int lMax = 0,rMax=0;
        while(l<r){
            lMax = Math.max(lMax, height[l]);
            rMax = Math.max(rMax, height[r]);
            if(lMax<rMax){
                res += (lMax-height[l]);
                l++;
            }else{
                res += (rMax -height[r]);
                r--;
            }

        }
        return res;
    }
}
