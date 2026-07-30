class Solution {
    public int findNumbers(int[] nums) {
        int count=0;
        
        for(int i=0;i<nums.length;i++){
            int count1=0;
            while(nums[i]>0){
                int dig=nums[i]%10;
                nums[i]=nums[i]/10;
                count1++;
            }if(count1%2==0){
                count++;
            }
        }return count;
    }
}