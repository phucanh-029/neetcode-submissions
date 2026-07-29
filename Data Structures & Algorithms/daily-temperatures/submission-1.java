class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Stack<Integer> stk = new Stack<>();
    
        for(int i = temperatures.length - 1; i>=0; i--){
            while(!stk.isEmpty() && temperatures[stk.peek()]<=temperatures[i]){
                stk.pop();
            }
            res[i] = stk.isEmpty() ? 0 : stk.peek()-i;
            stk.push(i);
        }
        return res;
    }
    // 28 
    // 40
    // 40 35
    // 40 
}
