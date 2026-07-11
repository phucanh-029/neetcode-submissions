class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String s : strs){
            sb.append(s.length()).append('#').append(s);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> res= new ArrayList<>();
        // res.add(str);
        int i = 0;
        while(i<str.length()){
            // if(str.charAt(i)=='#'){
            //     res.add(str.substring(i+1,i+1+Integer.valueOf(str.substring(a,i))));
            //     a=i+1+Integer.valueOf(str.substring(a,i));
            // }
            int j = i;
            while(str.charAt(j)!='#'){
                j++;
            }
            int len = Integer.valueOf(str.substring(i,j));
            res.add(str.substring(j+1,len+j+1));
            i = len + j +1 ;
        }
        return res;
    }
}
