class Solution {
    public int countDigits(int num) {int p=num;
        int count=0;
        while(num!=0){
            int dig=num%10;
            num=num/10;
            if(p%dig==0){
                count++;
            }
        }return count;
    }
}