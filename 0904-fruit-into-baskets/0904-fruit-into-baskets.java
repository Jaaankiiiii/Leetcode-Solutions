class Solution {
    public int totalFruit(int[] fruits) {
        int j=0, n=fruits.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        int i=0;
        int maxT=0;
        while(j<n){
            map.put(fruits[j],map.getOrDefault(fruits[j],0)+1);
            //contain nhi kr rha hai
            while(map.size()>2){
                int freq = map.get(fruits[i]);
                if(freq>1) map.put(fruits[i],freq-1);
                else map.remove(fruits[i]);
                i++;
            }
            maxT = Math.max(maxT, j-i+1);
            j++;
        }
        return maxT;
    }
}