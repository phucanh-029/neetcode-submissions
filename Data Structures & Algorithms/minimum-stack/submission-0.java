class MinStack {
    private Stack<Integer> stk;
    public MinStack() {
        stk = new Stack<>();
    }
    
    public void push(int val) {
        stk.push(val);
    }
    
    public void pop() {
        stk.pop();
    }
    
    public int top() {
        return stk.peek();
    }
    
    public int getMin() {
        Stack<Integer> tmp = new Stack<>();
        int min = stk.peek();
        while(!stk.isEmpty()){
            min = Math.min(stk.peek(),min);
            tmp.push(stk.peek());
            stk.pop();
        }
        while(!tmp.isEmpty()){
            stk.push(tmp.peek());
            tmp.pop();
        }
        return min;
    }
}
