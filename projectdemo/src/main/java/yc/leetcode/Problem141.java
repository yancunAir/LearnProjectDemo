package yc.leetcode;

import yc.list.ListNode;

import java.util.HashSet;
import java.util.Set;

public class Problem141 {

    public static boolean hasCycle(ListNode head) {

        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;


    }

    public static boolean hasCycle2(ListNode head){

        if(head == null || head.next == null){
            return false;
        }

        Set<ListNode> nodeSet = new HashSet<>();

        while(head!= null){

             if(nodeSet.contains(head)){
                 return true;
             }else{
                 nodeSet.add(head);
             }

            head = head.next;


        }

        return false;

    }


    public static void main(String[] args){


        ListNode head = new ListNode(0);
        ListNode head1 = new ListNode(2);
        ListNode head2 = new ListNode(3);
        ListNode head3 = new ListNode(4);
        head.next = head1;
        head1.next = head2;
        head2.next = head3;
        head3.next = null;
        boolean flag = hasCycle(head);

        System.out.println(flag);




    }

}
