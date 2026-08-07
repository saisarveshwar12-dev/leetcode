class Solution {
    public int arrangeCoins(int n) {
        int i=0;
        int s=1;
        while(n>=0){
            n=n-s;
            if(n<0)
                return i;
                s++;
                i++;
            
        }return i;
    }
}