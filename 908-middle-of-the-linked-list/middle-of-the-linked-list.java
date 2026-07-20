class Solution {
    public ListNode middleNode(ListNode head) {
        int count = 0;
        ListNode curr=head;
        while(curr!=null){
            count++;
            curr=curr.next;
        }
        curr=head;
        for(int i=1;i<=count/2;i++){
            curr=curr.next;
        }
        
        return curr;
    }
}
