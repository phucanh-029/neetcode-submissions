class Solution {
    public int[] countBits(int n) {
        int[] res = new int[n+1];
        for(int i = 0; i <= n; i++){
            int tmp = i;
            while(tmp>0){
                res[i] += tmp&1;
                tmp>>=1;
            }
        }
        return res;
    }
}
