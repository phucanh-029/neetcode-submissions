class Solution {
    public int evalRPN(String[] tokens) {
        int res = 0;
        Stack<Integer> stk = new Stack<>();
        int top1=0,top2=0;
        for(String token : tokens){
            if(isNum(token)){
                stk.push(Integer.parseInt(token));
            }
            else{
                switch(token){
                    case "+":
                        top1 = stk.pop();
                        top2 = stk.pop();
                        // System.out.println(top1+" "+top2);
                        res = top1+top2;
                        stk.push(res);
                        break;
                    case "-":
                        top1 = stk.pop();
                        top2 = stk.pop();
                        res = top2-top1;
                        stk.push(res);
                        break;
                    case "*":
                        top1 = stk.pop();
                        top2 = stk.pop();
                        res = top1*top2;
                        // System.out.println(top1+" "+top2);
                        stk.push(res);
                        break;
                    case "/":
                        top1 = stk.pop();
                        top2 = stk.pop();
                        if(top1 ==0 ||top2 ==0)res=0;
                        else{
                            res = top2/top1;
                        }
                        stk.push(res);
                        break;
                    default:
                        break;
                }
                // System.out.println(top1+" "+top2);
            }
        }
        // while(!stk.isEmpty()){
        //     System.out.println(stk.pop());
        // }
        return stk.peek();
    }
    private boolean isNum(String s){
        if(s.length()==1){
            return s.charAt(0) - '0' >=0 && s.charAt(0) - '0' <=9;
        }
        for(int i = 0;i<s.length();i++){
            if(i==0 && s.charAt(i)=='-') continue;
            if(s.charAt(i) - '0' <0 || s.charAt(i) - '0' >9)return false;
        }
        return true;
    }
}
