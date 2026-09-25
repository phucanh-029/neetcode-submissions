class Solution {
    public int reverseBits(int n) {
        int res = 0;
        for(int i = 31; i >= 0; i--){
            int cur = n & 1;
            res += cur << i;
            n >>=1;    
        }
        return res;
    }
}
