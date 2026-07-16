class Solution {
    public boolean isValid(String s) {
        Stack<Character> stk = new Stack<>();
        stk.push(s.charAt(0));
        for(int i = 1; i<s.length(); i++){
        
            if(!stk.isEmpty() && ((s.charAt(i) == ']' && stk.peek() == '[' ) || (s.charAt(i) == ')' && stk.peek() == '(' ) || (s.charAt(i) == '}' && stk.peek() == '{' ))){
                
                stk.pop();
            }
            else{
                
                stk.push(s.charAt(i));
            }
        }
        return stk.isEmpty();
    }
}
