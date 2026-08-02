class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int pair[][] = new int[position.length][2];
        for(int i = 0; i < position.length; i++){
            pair[i][0]= position[i];
            pair[i][1]= speed[i];
        }
        Arrays.sort(pair, (a,b)->b[0]-a[0]);

        Stack<Double> stk = new Stack<>();
        for(int i = position.length-1; i>= 0; i--){
            double time = (double)(target-pair[i][0])/pair[i][1];
            while(!stk.isEmpty()&&stk.peek()<=time){
                stk.pop();
            }
            stk.push(time);
        }
        return stk.size();
    }
}

//1,1,12,7,3