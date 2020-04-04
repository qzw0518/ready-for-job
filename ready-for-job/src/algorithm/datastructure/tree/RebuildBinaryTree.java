package algorithm.datastructure.tree;

/**
 * @author zhiwen.qi
 * @description 重建二叉树(不含重复元素)。中序+后序，中序+前序。必须要有中序才能确定相对位置
 * 例子：
 *          7
 *      6       5
 *   3     1  2    9
 * 10             8
 * 中序[10, 3, 6, 1, 7, 2, 5, 8, 9]
 * 后序[10, 3, 1, 6, 2, 8, 9, 5, 7]
 * 前序[7, 6, 3, 10, 1, 5, 2, 9, 8]
 * @date 2020/2/16 11:12
 */
public class RebuildBinaryTree {
    public static void main(String[] args) {
        int[] in = {10, 3, 6, 1, 7, 2, 5, 8, 9};
        int[] back = {10, 3, 1, 6, 2, 8, 9, 5, 7};
        int[] pre = {7, 6, 3, 10, 1, 5, 2, 9, 8};
//        TreeNode root = rebuildByInAndPre(pre, 0, pre.length - 1, in, 0, in.length - 1);
        TreeNode root = rebuildByInAndBack(back, 0 ,back.length - 1, in, 0, in.length - 1);
        System.out.println(root.right.left.val);
    }

    /**
     * 根据前序和中序重建二叉树
     * @param pre 前序序列
     * @param startPre 需要构建的子树在前序中的开始位置
     * @param endPre 需要构建的子树在前序序列的结束位置
     * @param in 中序序列
     * @param startIn 需要构建的子树在中序序列的开始位置
     * @param endIn 需要构建的子树在中序序列的结束位置
     * @return 构建的子树
     */
    public static TreeNode rebuildByInAndPre(int[] pre, int startPre, int endPre, int[] in, int startIn, int endIn) {
        if (startPre > endPre || startIn > endIn) {
            return null;
        }
        TreeNode root = new TreeNode(pre[startPre]);
        for (int i = startIn; i <= endIn; i++) {
            if (in[i] == pre[startPre]) {
                root.left = rebuildByInAndPre(pre, startPre + 1, startPre + i - startIn,
                                               in, startIn, i - 1);     //i - startIn左子树元素个数
                root.right = rebuildByInAndPre(pre, endPre - (endIn - i) + 1, endPre,
                                                in, i + 1, endIn);      //endIn - i右子树元素个数
                break;
            }
        }
        return root;
    }

    /**
     * 根据后序和中序重建二叉树
     * @param back 后序序列
     * @param startBack 需要构建的子树在后序中的开始位置
     * @param endBack 需要构建的子树在后序序列的结束位置
     * @param in 中序序列
     * @param startIn 需要构建的子树在中序序列的开始位置
     * @param endIn 需要构建的子树在中序序列的结束位置
     * @return 构建的子树
     */
    public static TreeNode rebuildByInAndBack(int[] back, int startBack, int endBack, int[] in, int startIn, int endIn) {
        if (startBack > endBack || startIn > endIn) {
            return null;
        }
        TreeNode root = new TreeNode(back[endBack]);
        for (int i = startIn; i <= endIn ; i++) {
            if (in[i] == back[endBack]) {
                root.left = rebuildByInAndBack(back, startBack, startBack + i - startIn - 1,
                                                in, startIn, i - 1);
                root.right = rebuildByInAndBack(back, endBack - (endIn - i), endBack - 1,
                                                  in, i + 1, endIn);
                break;
            }
        }
        return root;
    }


}
