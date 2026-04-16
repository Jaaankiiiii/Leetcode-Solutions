class Solution {
    public int maximumNumberOfStringPairs(String[] words) {
        HashSet<String> set  = new HashSet<>();
        int count = 0;
        for(int i=0; i<words.length; i++){
            String s = reverse(words[i]);
            if(set.contains(s)){
                count++;
                set.remove(s);
            }else{
                set.add(words[i]);
            }
        }
        return count;
    }
    public String reverse(String s){
        String str = new StringBuilder(s).reverse().toString();
        return str;
    }
}