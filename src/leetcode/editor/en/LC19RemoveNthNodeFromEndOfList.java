package leetcode.editor.en;

import Techbow.LinkedList.ListNode;

public class LC19RemoveNthNodeFromEndOfList{
    public static void main(String[] args) {
        Solution solution = new LC19RemoveNthNodeFromEndOfList().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    //TODO
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode fast = head;
        ListNode slow = head;

        while (n-- > 0 && fast != null) {
            fast = fast.next;
        }

        if (fast == null) {
            return head.next;
        }

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        ListNode remove = slow.next;
        slow.next = slow.next.next;
        remove.next = null;

        return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}