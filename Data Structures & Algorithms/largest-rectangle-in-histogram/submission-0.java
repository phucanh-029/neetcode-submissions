class Solution {
    public int largestRectangleArea(int[] heights) {
        int max = 0;
        Stack<Integer> stk = new Stack<>();

        for(int i = 0;i<=heights.length; i++){
            int curr = i == heights.length ? 0 : heights[i];
            while(!stk.isEmpty() && heights[stk.peek()]>curr){
                int height = heights[stk.pop()];
                int width = stk.isEmpty() ? i :i-stk.peek()-1;
                max = Math.max(max, height*width);
            }
            stk.push(i);
            
        }
        return max;
    }
}
// 7 1