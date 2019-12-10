package algorithm.swordToOffer;

import algorithm.datastructure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author zhiwen.qi
 * @description 二叉树的一些遍历操作
 * @date 2019/10/29
 */
public class PrintBinaryTree {

    private static int level = 0;
    private static int k = 2;

    /**
     * 使用队列，依次从左至右层次遍历二叉树。
     * @param root 根节点
     */
    public void queuePrintTopToBottom(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            if (node != null) {
                System.out.println(node.val);
                queue.add(node.left);
                queue.add(node.right);
            }
        }
    }

    /**
     *输出二叉树第n层节点，需要外部辅助变量level
     * @param node 节点
     * @param n 第n层
     */
    public void printByLevel(TreeNode node, int n) {
        //初始层次为0，每次调用层次+1
        level++;
        if (node != null) {
            if (level == n) {
                System.out.print(node.val + "-");
            }
            printByLevel(node.left,n);
            printByLevel(node.right,n);
        }
        //回溯
        level--;
    }

    /**
     * 查找二叉排序树第k个节点，外部辅助变量k
     * @param root 二叉排序树根节点
     * @return 第k个节点
     */
    public TreeNode KthNode(TreeNode root) {
        if (root == null) {
            return null;
        }
        KthNode(root.left);
        if (k == 0) {
            System.out.println(root.val);
        }
        k--;
        KthNode(root.right);
        return root;
    }
}
