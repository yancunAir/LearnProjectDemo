package yc.leetcode;

import yc.algorithm.ListNode;

public class Problem2 {


    public static void main(String[] args) {

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode result = new ListNode(0);

        ListNode pre = result;

        ListNode l1next = l1.next;

        ListNode l2next = l2.next;

        int carry = 0;

        while(l1next != null || l2next != null) {

             int value1 = l1next == null ? 0 : l1next.code;
             int value2 = l2next == null ? 0 : l2next.code;

            int sum  =  value1+value2+ carry;

            carry = sum / 10;

            pre.next = new ListNode(sum %10);
            if (l1next != null) {
                l1next = l1next.next;
            }
            if (l2next != null) {
                l2next = l2next.next;
            }
        }

        if (carry == 1) {
            pre.next = new ListNode(carry);
        }

        return result.next;

    }


}
