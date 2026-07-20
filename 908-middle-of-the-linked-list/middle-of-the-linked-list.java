class Solution {
    public ListNode middleNode(ListNode head) {
        int count = 0;
        ListNode ptr = head;
        while(ptr!=null){
            count++;
            ptr=ptr.next;
        }
        count = count/2;
        ptr=head;
        while(count>0){
            ptr=ptr.next;
            count--;
        }
        return ptr;
        }
        
    }
