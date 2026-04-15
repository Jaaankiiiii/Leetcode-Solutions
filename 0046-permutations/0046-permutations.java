class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> a = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        combinations(nums, ans, a,used);
        return ans;
        
    }
    public void combinations(int[] nums, List<List<Integer>> ans , ArrayList<Integer> a , boolean[] used){
        if(a.size()==nums.length){
            ans.add(new ArrayList<>(a));
            return;
        }
        for(int i=0; i<nums.length; i++){
            if(used[i] == true) continue;
            a.add(nums[i]);
            used[i] = true;
            combinations(nums, ans, a, used);
            a.remove(a.size()-1);
            used[i] = false;
        }
    }
}