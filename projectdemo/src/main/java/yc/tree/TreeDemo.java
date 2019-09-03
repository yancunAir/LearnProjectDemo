package yc.tree;

public class TreeDemo {




    //二叉树的三种遍历
    //1.先序遍历 从根节点开始  然后遍历左子树 接着是右子树

    //2.中序遍历 从左边先遍历左子树  然后是根  然后是右子树

    //3.后序遍历 从左边先遍历左子树 然后是右子树 最后是根

    /**
     *
     *
     *                        9
     *                      3    4
     *                    5  6  7  8
     *
     *先: 9->3->5->6 ->4->7->8
     *中: 5->3->6->9->7->4->8
     *后: 5->6->3->7->8->4->9
     *
     *
     *
     *
     *
     *
     *
     */





}

class TreeNode{

    TreeNode left ;
    TreeNode right;
    int value;
    TreeNode(int value){
        this.value = value;
    }

}
