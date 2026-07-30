class Solution {
    public int maximumWealth(int[][] acc) {
        int max = 0;
        for(int i=0;i<acc.length;i++){
            int count =0;
            for(int j=0;j<acc[0].length;j++){
                count=count+acc[i][j];
                if(max<count){
                    max=count;
                }
            }
        }return max;
    }
}