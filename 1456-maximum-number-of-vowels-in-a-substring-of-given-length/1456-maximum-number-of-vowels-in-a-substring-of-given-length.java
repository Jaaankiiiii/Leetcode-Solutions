class Solution {
    public int maxVowels(String s, int k) {
        int maxVowels = 0;
        int count = 0;
        for(int i=0; i<k; i++){
            char ch = s.charAt(i);
            if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u'){
                count++;
            }
        }
        maxVowels = count;
        for(int i=k; i<s.length(); i++){
            char add = s.charAt(i);
            char remove = s.charAt(i-k);
            if(remove=='a' || remove=='e' || remove=='i' || remove=='o' || remove=='u'){
                count--;
            }
            if(add=='a' || add=='e' || add=='o' || add=='i' || add=='u'){
                count++;
            }

            maxVowels = Math.max(maxVowels,count);
        }
        return maxVowels;
    }
}