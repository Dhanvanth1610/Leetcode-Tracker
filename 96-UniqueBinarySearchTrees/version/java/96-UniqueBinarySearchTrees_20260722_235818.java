// Last updated: 7/22/2026, 11:58:18 PM
1class Solution {
2    public Node connect(Node root) {
3        if (root == null) {
4            return null;
5        }
6
7        Node leftMost = root;
8
9        while (leftMost.left != null) {
10            Node current = leftMost;
11
12            while (current != null) {
13                // Connect left child to right child
14                current.left.next = current.right;
15
16                // Connect right child to next node's left child
17                if (current.next != null) {
18                    current.right.next = current.next.left;
19                }
20
21                current = current.next;
22            }
23
24            leftMost = leftMost.left;
25        }
26
27        return root;
28    }
29}
30