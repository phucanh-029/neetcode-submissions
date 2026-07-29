class Solution {
    public int trap(int[] height) {
        int res = 0;
        Stack<Integer> stk = new Stack<>();
        for(int i = 0; i< height.length; i++){
            while(!stk.isEmpty() && height[stk.peek()]<=height[i]){
                int mid = height[stk.pop()];
                if(!stk.isEmpty()){
                    // System.out.println("peek:"+stk.peek()+" "+height[stk.peek()]+" pos: "+ i+" "+ height[i]);
                    // System.out.println("mid: "+mid);
                    int right = height[i];
                    int left = height[stk.peek()];
                    int h = Math.min(left,right)-mid;
                    int w = i-stk.peek()-1;
                    res+=h*w;
                }
            }
            stk.push(i);
        }
        return res;
    }
}
