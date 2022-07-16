//<p>You are given two <strong>non-empty</strong> linked lists representing two non-negative integers. The digits are stored in <strong>reverse order</strong>, and each of their nodes contains a single digit. Add the two numbers and return the sum&nbsp;as a linked list.</p>
//
//<p>You may assume the two numbers do not contain any leading zero, except the number 0 itself.</p>
//
//<p>&nbsp;</p>
//<p><strong>Example 1:</strong></p>
//<img alt="" src="https://assets.leetcode.com/uploads/2020/10/02/addtwonumber1.jpg" style="width: 483px; height: 342px;" />
//<pre>
//<strong>Input:</strong> l1 = [2,4,3], l2 = [5,6,4]
//<strong>Output:</strong> [7,0,8]
//<strong>Explanation:</strong> 342 + 465 = 807.
//</pre>
//
//<p><strong>Example 2:</strong></p>
//
//<pre>
//<strong>Input:</strong> l1 = [0], l2 = [0]
//<strong>Output:</strong> [0]
//</pre>
//
//<p><strong>Example 3:</strong></p>
//
//<pre>
//<strong>Input:</strong> l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//<strong>Output:</strong> [8,9,9,9,0,0,0,1]
//</pre>
//
//<p>&nbsp;</p>
//<p><strong>Constraints:</strong></p>
//
//<ul>
//	<li>The number of nodes in each linked list is in the range <code>[1, 100]</code>.</li>
//	<li><code>0 &lt;= Node.val &lt;= 9</code></li>
//	<li>It is guaranteed that the list represents a number that does not have leading zeros.</li>
//</ul>
//<div><div>Related Topics</div><div><li>Linked List</li><li>Math</li><li>Recursion</li></div></div><br><div><li>👍 17849</li><li>👎 3687</li></div>
    package leetcode.editor.en;

import Techbow.LinkedList.ListNode;

public class AddTwoNumbers {
        public static void main(String[] args) {
            Solution solution = new AddTwoNumbers().new Solution();
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
    /*
    added from head,
    need added value = (l1.val + l2.val + addToValue) % 10
    need addTo value = (l1.val + l2.val + addToValue) / 10

    test case:
    9,9,9,9
    5,4,6

     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //cc

        ListNode p1 = l1, p2 = l2, head = null, result = head;
        //handle length are equaled
        int addToValue = 0;
        while (p1 != null && p2 != null) {

            int addedValue = (p1.val + p2.val + addToValue) % 10;
            addToValue = (p1.val + p2.val + addToValue) / 10;

            if (head == null) {
                head = new ListNode(addedValue);
                result = head;
            } else {
                head.next = new ListNode(addedValue);
                head = head.next;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        //handle length extra
        while (p1 != null) {
            int addedValue = (p1.val + addToValue) % 10;
            addToValue = (p1.val + addToValue) / 10;
            head.next = new ListNode(addedValue);
            head = head.next;
            p1 = p1.next;
        }

        while (p2 != null) {
            int addedValue = (p2.val + addToValue) % 10;
            addToValue = (p2.val + addToValue) / 10;
            head.next = new ListNode(addedValue);
            head = head.next;
            p2 = p2.next;
        }

        if (addToValue > 0) {
            head.next = new ListNode(addToValue);
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    }