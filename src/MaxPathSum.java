
/**
 * 二叉树中的最大路径和
 */
public class MaxPathSum {

  int max = Integer.MIN_VALUE;
  /**
   * 对于二叉树  a
   *          / \
   *         b   c
   * 其中a是根节点(递归中的root)，bc是左右子节点(分别代表左右子节点递归后的最优解)
   * 最大的路径可能的情况有：
   * 1、b + a + c 这种情况不能再联络父节点，或者本身试试根节点的情况。这种情况没法递归(因为一个节点只能出现一次)，但结果可能是全局最大值
   * 2、b + a + a的父节点
   * 3、c + a + a的父节点 2和3两种情况 可以递归返回最优解
   */
  public int maxPathSum(TreeNode root) {
    dfs(root);
    return max;
  }

  /**
   * 递归记录全局最大和，返回经过node的单边分支最大和
   */
  public int dfs(TreeNode node) {
    if (node == null) {
      return 0;
    }
    int leftMax = dfs(node.left);
    int rightMax = dfs(node.right);
    // res 是情况2 和 3
    int res = node.val + Math.max(Math.max(leftMax, rightMax), 0);
    // lnr 是情况1
    int lnr = node.val + Math.max(leftMax, 0) + Math.max(rightMax, 0);
    max = Math.max(max, Math.max(res, lnr));
    return res;
  }
}
