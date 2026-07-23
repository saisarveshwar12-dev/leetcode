import java.util.LinkedList;
import java.util.Collections;
public class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        
        LinkedList<Integer> list = new LinkedList<>();
        ListNode curr = head;
        while (curr != null) {
            list.add(curr.val);
            curr = curr.next;
        }
        
        Collections.sort(list);
        
        curr = head;
        for (int val : list) {
            curr.val = val;
            curr = curr.next;
        }
        
        return head;
    }
}