package algorithm.datastructure.tree;

import algorithm.datastructure.TreeNode;

/**
 * @author zhiwen.qi
 * @description 二叉树遍历
 * @date 2019/11/3
 */
public class PrintTree {

    //前序遍历
    public void preOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.println(node.val);
        preOrder(node.left);
        preOrder(node.right);
    }

    //中序遍历
    public void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.println(node.val);
        inOrder(node.right);
    }

    //后续遍历
    public void backOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        backOrder(node.left);
        backOrder(node.right);
        System.out.println(node.val);
    }
}
