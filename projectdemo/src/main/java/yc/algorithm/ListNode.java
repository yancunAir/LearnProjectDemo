package yc.algorithm;

public class ListNode {

    public int code;

    public ListNode next;

    public ListNode(int code) {
        this.code = code;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append(this.code).append(" ");
        ListNode nodeNext = this.next;
        while(nodeNext != null) {
            sb.append(nodeNext.code).append(" ");
            nodeNext = nodeNext.next;
        }

        return sb.toString();
    }
}
