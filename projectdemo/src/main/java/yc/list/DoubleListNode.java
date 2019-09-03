package yc.list;

public class DoubleListNode {

    private DoubleListNode next ;

    private int node ;

    private DoubleListNode pre ;

    DoubleListNode(int node){
        this.node = node;
    }

    private static DoubleListNode head = new DoubleListNode(0);

    public  DoubleListNode getHeader(){
        return head;
    }

    public static int getLength(DoubleListNode node){
      if(node == null){
          return 0;
      }
      int length = 0;
      DoubleListNode temp = node;
      while(temp != null){

          length ++ ;
          temp = temp.next;

      }
      return length;

    }

    //按顺序添加
    public static void addByOrder(DoubleListNode listNode){
       if(listNode == null){
           return;
       }
        DoubleListNode temp = head.next;
        while(temp != null){



            if(temp.node > listNode.node){

                temp = temp.next;

            }else {
                break;
            }
        }
        if(temp != null){

            //将当前节点加到temp前面
            temp.next = listNode;
            listNode.pre = temp;




        }else{

            //将当前节点加到末尾
            add(listNode);
        }


    }

    //增加一个节点到链表尾部
    public static void add(DoubleListNode listNode){

        DoubleListNode temp = head;

        while(temp.next!= null){

            temp = temp.next;

         }

        temp.next = listNode;
        listNode.pre = temp;

    }

    public static void main(String[] args){
        DoubleListNode node  = new DoubleListNode(1);
        node.next = new DoubleListNode(2);
        int length  = getLength(node);
        System.out.println(length);

    }

}
