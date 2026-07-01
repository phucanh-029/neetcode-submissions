class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> hm = new HashMap<>();
        for(int i = 0; i < strs.length; i++){
            char[] idx = strs[i].toCharArray();
            Arrays.sort(idx);
            String s = Arrays.toString(idx);
            hm.putIfAbsent(s, new ArrayList<>());
            hm.get(s).add(strs[i]);
        }
        for( List<String> it: hm.values()){
            res.add(it);
        }
        return res;
    }
}
