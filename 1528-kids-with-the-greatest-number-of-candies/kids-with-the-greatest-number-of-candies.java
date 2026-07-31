class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int ex) {
        ArrayList<Boolean> ans=new ArrayList<>();
        int max=candies[0];
        for(int i=0;i<candies.length;i++){
            max=Math.max(max,candies[i]);
        }
        for(int i=0;i<candies.length;i++){
            ans.add(candies[i]+ex>=max);
        }
        return ans;
    }
}