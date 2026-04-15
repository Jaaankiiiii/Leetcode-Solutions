class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> a = new ArrayList<>();
        checkSum(candidates,0,target,ans,a);
        return ans;
    }
    public void checkSum(int[] candidates,int idx, int target ,List<List<Integer>> ans, ArrayList<Integer> a ){
        if(target==0){
            ans.add(new ArrayList<>(a));
            return;
        }
        if(target<0) return;
        for(int i=idx; i<candidates.length; i++){
            a.add(candidates[i]);
            checkSum(candidates,i, target-candidates[i],ans,a);
            a.remove(a.size()-1);
        }
    }
}