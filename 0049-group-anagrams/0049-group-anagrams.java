class Solution {
    public String sortString(String str){
        char[] s = str.toCharArray();
        Arrays.sort(s);
        String newS = new String(s);
        return newS;
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for(int i = 0; i<strs.length; i++){
            String str = sortString(strs[i]);
            if(!map.containsKey(str)){
                List<String> newStrsArr = new ArrayList<>();
                newStrsArr.add(strs[i]);
                map.put(str, newStrsArr);
            }else{
                List<String> newStrsArr = map.get(str);
                newStrsArr.add(strs[i]);
                map.put(str,newStrsArr);
            }
        }
        List<List<String>> ans = new ArrayList<>();
        for(String keys : map.keySet()){
            ans.add(map.get(keys));
        }
        return ans;
    }
}