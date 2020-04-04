package algorithm.datastructure.tree;

/**
 * @author zhiwen.qi/qiwonder@163.com
 * @version 1.0
 * @ClassName BTreeMinDepth
 * @description  二叉树最小深度。根节点到所有叶子节点路径最小值。
 * @date 2019/9/30 17:37
 * @since JDK 1.8
 */
public class BTreeMinDepth {

    public static void main(String[] args){
        BTreeMinDepth bTreeMinDepth = new BTreeMinDepth();
        TreeNode node0 = new TreeNode(0);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        node1.left = node3;
        node0.left = node1;
        node0.right = node2;
        System.out.println(bTreeMinDepth.getMinDepth(node0));
    }

    //递归方式
    public int getMinDepth(TreeNode root) {
        //如果根节点为空，返回0
        if (root == null) {
            return 0;
        }
        //如果左右子树为空，返回1
        if (root.left == null && root.right == null) {
            return 1;
        }
        //如果左子树为空，右子树不空，返回右子树最小深度+1
        if (root.left == null) {
            return getMinDepth(root.right) + 1;
        }
        //如果右子树为空，左子树不空，返回左子树最小深度+1
        if (root.right == null) {
            return getMinDepth(root.left) + 1;
        }
        //左右子树都不为空，返回二者中最小深度+1
        return getMinDepth(root.left) < getMinDepth(root.right) ? getMinDepth(root.left) + 1 : getMinDepth(root.right) + 1;
    }

}

