// Last updated: 7/9/2026, 2:16:58 PM
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
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow =slow.next;
            fast=fast.next.next;
        }
        ListNode prev = null;
        while(slow != null){
            ListNode next = slow.next;
            slow.next=prev;
            prev = slow;
            slow= next;
        }
        while (prev != null && head!=null){
            if(prev.val != head.val){
                return false;
            }
            prev = prev.next;
            head=head.next;
        }
        return true;       
    }
}