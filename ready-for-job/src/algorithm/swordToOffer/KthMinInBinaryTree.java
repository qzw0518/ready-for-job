package algorithm.swordToOffer;

import algorithm.datastructure.tree.TreeNode;

import java.util.ArrayList;

/**
 * @author zhiwen.qi
 * @description
 * 给定一棵二叉搜索树，请找出其中的第k小的结点。例如， （5，3，7，2，4，6，8）    中，按结点数值大小顺序第三小结点的值为4
 * @date 2020/1/16
 */
public class KthMinInBinaryTree {

    ArrayList<TreeNode> list = new ArrayList<>();

    public TreeNode KthNode(TreeNode pRoot, int k) {
        inOrder(pRoot);
        if (k > 0 && k <= list.size()) {
            return list.get(k - 1);
        }
        return null;
    }

    /**
     * 利用二叉搜索数的中序序列是有效到大有序来找第k小的节点
     * @param node 节点
     */
    public void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        list.add(node);
        inOrder(node.right);
    }

}
