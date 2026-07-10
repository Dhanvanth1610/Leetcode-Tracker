// Last updated: 7/10/2026, 2:26:41 PM
1/**
2 * Definition for singly-linked list.
3 * public class ListNode {
4 *     int val;
5 *     ListNode next;
6 *     ListNode() {}
7 *     ListNode(int val) { this.val = val; }
8 *     ListNode(int val, ListNode next) {
9 *         this.val = val;
10 *         this.next = next;
11 *     }
12 * }
13 */
14class Solution {
15
16    public ListNode reverseKGroup(ListNode head, int k) {
17        ListNode dummy = new ListNode(0);
18        dummy.next = head;
19
20        ListNode groupPrev = dummy;
21
22        while (true) {
23            // Find the kth node
24            ListNode kth = getKthNode(groupPrev, k);
25
26            if (kth == null)
27                break;
28
29            ListNode groupNext = kth.next;
30
31            // Reverse the group
32            ListNode prev = groupNext;
33            ListNode curr = groupPrev.next;
34
35            while (curr != groupNext) {
36                ListNode temp = curr.next;
37                curr.next = prev;
38                prev = curr;
39                curr = temp;
40            }
41
42            // Reconnect the reversed group
43            ListNode temp = groupPrev.next;
44            groupPrev.next = kth;
45            groupPrev = temp;
46        }
47
48        return dummy.next;
49    }
50
51    private ListNode getKthNode(ListNode curr, int k) {
52        while (curr != null && k > 0) {
53            curr = curr.next;
54            k--;
55        }
56        return curr;
57    }
58}