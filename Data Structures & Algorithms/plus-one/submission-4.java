class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 0;
        digits[digits.length-1] +=1;
        if(digits[digits.length-1] > 9) {
            digits[digits.length-1] = 0;
            carry = 1;
        }
        for(int i = digits.length - 2; i >= 0; i--){
            if(digits[i] == 9 && carry == 1){
                digits[i] = 0;
                carry = 1;
            }
            else{
                digits[i]+=carry;
                carry = 0;
                break;
            }
        }
        if(carry == 1){
            int[] res = new int[digits.length+1];
            res[0] = 1;
            return res;
        }
        return digits;
        
    }
}
