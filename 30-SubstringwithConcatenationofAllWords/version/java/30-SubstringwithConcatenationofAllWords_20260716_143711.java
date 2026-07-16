// Last updated: 7/16/2026, 2:37:11 PM
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
14
15import java.util.PriorityQueue;
16
17class Solution {
18    public ListNode mergeKLists(ListNode[] lists) {
19        PriorityQueue<ListNode> pq = new PriorityQueue<>(
20            (a, b) -> a.val - b.val
21        );
22
23        for (ListNode node : lists) {
24            if (node != null) {
25                pq.offer(node);
26            }
27        }
28
29        ListNode dummy = new ListNode(0);
30        ListNode curr = dummy;
31
32        while (!pq.isEmpty()) {
33            ListNode node = pq.poll();
34            curr.next = node;
35            curr = curr.next;
36
37            if (node.next != null) {
38                pq.offer(node.next);
39            }
40        }
41
42        return dummy.next;
43    }
44}