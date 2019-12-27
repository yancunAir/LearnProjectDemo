package yc.algorithm;

public class ListNodeSort {


    public static void main(String[] args) {

        ListNodeSort sort = new ListNodeSort();

        ListNode mockNode = sort.mockListNode();
        sort.sort(mockNode);
        System.out.println(mockNode.toString());


    }

    private ListNode mockListNode() {

        ListNode head = new ListNode(0);
        head.next = new ListNode(1);
        head.next = new ListNode(5);
        head.next = new ListNode(4);
        head.next = new ListNode(3);
        return head;
    }


    public void sort(ListNode node) {

        if (node == null || node.next == null) {
            return;
        }

        ListNode temp = node.next;

        while (temp.next != null) {
            ListNode tempNext = temp.next;
            while (tempNext.next != null) {

                if (temp.next.code > tempNext.next.code) {
                    int t = temp.next.code;
                    temp.next.code = tempNext.next.code;
                    tempNext.next.code = t;
                }

                tempNext = tempNext.next;
            }
            temp = temp.next;
        }

    }


}
