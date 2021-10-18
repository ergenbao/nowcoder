import java.util.LinkedList;
/**
 * 二叉树根节点到叶子节点的所有路径和
 */
public class SumNumbers {
  /**
   * 思路: 定义两个队列。一个用来存储节点、另外一个存储该节点到根节点的距离
   * 进行广度优先遍历二叉树，也就是层级遍历
   * 只有节点时叶子节点的时候，才将该节点的值累加到总和中
   */
  public int sumNumbers(TreeNode root) {
    if (root == null) {
      return 0;
    }
    LinkedList<TreeNode> nodeQueue = new LinkedList<>();
    LinkedList<Integer> numberQueue = new LinkedList<>();
    nodeQueue.addFirst(root);
    numberQueue.addFirst(root.val);
    int sum = 0;
    while (!nodeQueue.isEmpty()) {
      TreeNode node = nodeQueue.removeLast();
      TreeNode left = node.left;
      TreeNode right = node.right;
      int number = numberQueue.removeLast();
      if (left == null && right == null) {
        sum += number;
      } else {
        if (left != null) {
          nodeQueue.addFirst(left);
          // 下一节点的值为父节点 * 10 + 下一节点
          numberQueue.addFirst(number * 10 + left.val);
        }
        if (right != null) {
          nodeQueue.addFirst(right);
          numberQueue.addFirst(number * 10 + right.val);
        }
      }
    }
    return sum;
  }
}
